package model.heroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import engine.ActionValidator;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.cards.minions.MinionListener;
import model.cards.spells.*;

public abstract class Hero implements MinionListener {
	private HeroListener listener;
	private ActionValidator validator;
	private String name;
	private int currentHP;
	private boolean heroPowerUsed;
	private int totalManaCrystals;
	private int currentManaCrystals;
	private ArrayList<Card> deck;
	private ArrayList<Minion> field;
	private ArrayList<Card> hand;
	@SuppressWarnings("unused")
	private int fatigueDamage = 1;

	public Hero(String name) throws IOException, CloneNotSupportedException {
		this.name = name;
		currentHP = 30;
		deck = new ArrayList<Card>();
		field = new ArrayList<Minion>();
		hand = new ArrayList<Card>();
		buildDeck();
	}

	public abstract void buildDeck() throws IOException, CloneNotSupportedException;

	public static final ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		ArrayList<Minion> minions = new ArrayList<Minion>();
		String current = br.readLine();
		while (current != null) {
			String[] line = current.split(",");
			Minion minion = null;
			String n = line[0];
			int m = Integer.parseInt(line[1]);
			Rarity r = null;
			switch ((line[2])) {
			case "b":
				r = Rarity.BASIC;
				break;
			case "c":
				r = Rarity.COMMON;
				break;
			case "r":
				r = Rarity.RARE;
				break;
			case "e":
				r = Rarity.EPIC;
				break;
			case "l":
				r = Rarity.LEGENDARY;
				break;
			}
			int a = Integer.parseInt(line[3]);
			int p = Integer.parseInt(line[4]);
			boolean t = line[5].equals("TRUE") ? true : false;
			boolean d = line[6].equals("TRUE") ? true : false;
			boolean c = line[7].equals("TRUE") ? true : false;
			if (!n.equals("Icehowl"))
				minion = new Minion(n, m, r, a, p, t, d, c);
			else
				minion = new Icehowl();
			minions.add(minion);
			current = br.readLine();
		}
		br.close();
		return minions;
	}

	public static final ArrayList<Minion> getNeutralMinions(ArrayList<Minion> minions, int count) {
		ArrayList<Minion> res = new ArrayList<Minion>();
		int i = 0;
		while (i < count) {

			int index = (int) (Math.random() * minions.size());
			Minion minion = minions.get(index);
			int occ = 0;
			for (int j = 0; j < res.size(); j++) {
				if (res.get(j).getName().equals(minion.getName()))
					occ++;
			}
			if (occ == 0) {
				res.add(minion);
				i++;
			} else if (occ == 1 && minion.getRarity() != Rarity.LEGENDARY) {
				res.add(minion);
				i++;
			}
		}
		return res;
	}

//	public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException,
//			FullHandException, FullFieldException, CloneNotSupportedException { // COMPLETE THIS
//		try {
//			validator.validateTurn(this);
//		} catch (NotYourTurnException e) {
//			System.out.println(e.toString());
//			return;
//		}
//		try {
//			validator.validateUsingHeroPower(this);
//		} catch (HeroPowerAlreadyUsedException e) {
//			System.out.println(e.toString());
//			return;
//		}
//	}

	public void useHeroPower(Object l) throws NotEnoughManaException, HeroPowerAlreadyUsedException,
			NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException {
	}

	public void useHeroPower(Hero l) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException,
			FullHandException, FullFieldException, CloneNotSupportedException {
		this.inflictDamage(l, 2);
		hand.add(deck.remove(0));
	}

	public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException,
			FullHandException, FullFieldException, CloneNotSupportedException {
	}

	public void attackWithMinion(Minion attacker, Minion target) throws CannotAttackException, NotYourTurnException,
			TauntBypassException, InvalidTargetException, NotSummonedException {
		attacker.attack(target);
	}

	public void playMinion(Minion m) throws NotYourTurnException, NotEnoughManaException, FullFieldException {
		field.add(m);
		hand.remove(m);
	}

	public void attackWithMinion(Minion attacker, Hero target) throws CannotAttackException, NotYourTurnException,
			TauntBypassException, NotSummonedException, InvalidTargetException {
		attacker.attack(target);
	}

	public void castSpell(FieldSpell s) throws NotYourTurnException, NotEnoughManaException {

		try {
			validator.validateTurn(this);
		} catch (NotYourTurnException e) {
			System.out.println(e.getMessage());
			return;
		}
		try {
			validator.validateManaCost((Card) s);
		} catch (NotEnoughManaException e) {
			System.out.println(e.getMessage());
			return;
		}
		s.performAction(this.getField());
		this.hand.remove(s);
	}

	public void castSpell(AOESpell s, ArrayList<Minion> oppField) throws NotYourTurnException, NotEnoughManaException {
		try {
			validator.validateTurn(this);
		} catch (NotYourTurnException e) {
			System.out.println(e.getMessage());
			return;
		}
		try {
			validator.validateManaCost((Card) s);
		} catch (NotEnoughManaException e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		s.performAction(oppField, this.field);
		this.hand.remove(s);
		for (Minion n : this.field) {
			if (n.getName().equalsIgnoreCase("Kalycgos")) {
				this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost() - 4);
				return;
			}
		}
		this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost());
	}

	public void castSpell(MinionTargetSpell s, Minion m)
			throws NotYourTurnException, NotEnoughManaException, InvalidTargetException {
		try {
			validator.validateTurn(this);
		} catch (NotYourTurnException e) {
			System.out.println(e.getMessage());
			return;
		}
		try {
			validator.validateManaCost((Card) s);
		} catch (NotEnoughManaException e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		try {
			if (!(this.field.contains(m)))
				throw new InvalidTargetException();
		} catch (InvalidTargetException e) {
			System.out.println(e.getMessage());
			return;
		}
		s.performAction(m);
		this.hand.remove(s);
		for (Minion n : this.field) {
			if (n.getName().equalsIgnoreCase("Kalycgos")) {
				this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost() - 4);
				return;
			}
		}
		this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost());
	}

	public void castSpell(HeroTargetSpell s, Hero h) throws NotYourTurnException, NotEnoughManaException {

		try {
			validator.validateTurn(this);
		} catch (NotYourTurnException e) {
			System.out.println(e.getMessage());
			return;
		}
		try {
			validator.validateManaCost((Card) s);
		} catch (NotEnoughManaException e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		s.performAction(h);
		this.hand.remove(s);
		for (Minion n : this.field) {
			if (n.getName().equalsIgnoreCase("Kalycgos")) {
				this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost() - 4);
				return;
			}
		}
		this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost());
	}

	public void castSpell(LeechingSpell s, Minion m) throws NotYourTurnException, NotEnoughManaException {

		try {
			validator.validateTurn(this);
		} catch (NotYourTurnException e) {
			System.out.println(e.getMessage());
			return;
		}
		try {
			validator.validateManaCost((Card) s);
		} catch (NotEnoughManaException e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		s.performAction(m);
		this.hand.remove(s);

		for (Minion n : this.field) {
			if (n.getName().equalsIgnoreCase("Kalycgos")) {
				this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost() - 4);
				return;
			}
		}
		this.setCurrentManaCrystals(this.getCurrentManaCrystals() - ((Card) s).getManaCost());
	}

	public void endTurn() throws FullHandException, CloneNotSupportedException {
		listener.endTurn();
	}

	public Card drawCard() throws FullHandException, CloneNotSupportedException {
		Card n;
		if (this.deck.size() == 0) {
			this.setCurrentHP(currentHP - fatigueDamage++);
			return null;
		}

		else
			n = this.deck.remove(0).clone();

		for (Minion o : this.field) {
			if (o.getName().equalsIgnoreCase("Chromaggus")) {
				this.hand.add(n.clone());
			}
			if (this instanceof Warlock) {
				if (o.getName().equalsIgnoreCase("Wilfred Fizzlebang"))
					n.setManaCost(0);
			}
		}
		return n;
	}

	public void onMinionDeath(Minion m) {
		this.field.remove(m);
	}

	public void inflictDamage(Hero o, int value) {
		o.setCurrentHP(o.getCurrentHP() - value);
	}

	public void inflictDamage(Minion o, int value) {
		o.setCurrentHP(o.getCurrentHP() - value);
	}

	public void restoreHP(Hero o, int value) {
		o.setCurrentHP(o.getCurrentHP() + value);
	}

	public void restoreHP(Minion o, int value) {
		o.setCurrentHP(o.getCurrentHP() + value);
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int hp) {
		this.currentHP = hp;
		if (this.currentHP > 30)
			this.currentHP = 30;
		else if (this.currentHP <= 0) {
			this.currentHP = 0;
			listener.onHeroDeath();
		}
	}

	public int getTotalManaCrystals() {
		return totalManaCrystals;
	}

	public void setTotalManaCrystals(int totalManaCrystals) {
		this.totalManaCrystals = totalManaCrystals;
		if (this.totalManaCrystals > 10)
			this.totalManaCrystals = 10;
	}

	public int getCurrentManaCrystals() {
		return currentManaCrystals;
	}

	public void setCurrentManaCrystals(int currentManaCrystals) {
		this.currentManaCrystals = currentManaCrystals;
		if (this.currentManaCrystals > 10)
			this.currentManaCrystals = 10;
	}

	public ArrayList<Minion> getField() {
		return field;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public boolean isHeroPowerUsed() {
		return heroPowerUsed;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setHeroPowerUsed(boolean powerUsed) {
		this.heroPowerUsed = powerUsed;
	}

	public String getName() {
		return name;
	}

	public HeroListener getListener() {
		return listener;
	}

	public void setListener(HeroListener listener) {
		this.listener = listener;
	}

	public void setValidator(ActionValidator validator) {
		this.validator = validator;
	}
}