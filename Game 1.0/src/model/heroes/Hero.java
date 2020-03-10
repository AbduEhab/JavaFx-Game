package model.heroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.DivineSpirit;
import model.cards.spells.Flamestrike;
import model.cards.spells.HolyNova;
import model.cards.spells.KillCommand;
import model.cards.spells.LevelUp;
import model.cards.spells.MultiShot;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;
import model.cards.spells.SealOfChampions;
import model.cards.spells.ShadowWordDeath;
import model.cards.spells.SiphonSoul;
import model.cards.spells.TwistingNether;

abstract public class Hero {
	private String name;// geter
	private int currentHP;// getter and setter
	private boolean heroPowerUsed;// getter and setter
	private int totalManaCrystals;// getter and setter
	private int currentManaCrystals; // getter and setter
	private ArrayList<Card> deck;// read
	private ArrayList<Minion> field;// read
	private ArrayList<Card> hand;// read
	private int fatigueDamage;// neither
//end of all 8 instance
// TODO Auto-generated constructor stub
//public static Minion[] getAllNeutralMinions(String filePath) {}

	public Hero(String n) throws IOException {
		// TODO Auto-generated constructor stub
		this.name = n;
		buildDeck(n);
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public void setHeroPowerUsed(boolean heroPowerUsed) {
		this.heroPowerUsed = heroPowerUsed;
	}

	public void setTotalManaCrystals(int totalManaCrystal) {
		this.totalManaCrystals = totalManaCrystal;
	}

	public void setCurrentManaCrystals(int currentManaCrystal) {
		this.currentManaCrystals = currentManaCrystal;
	}

	public void setField(ArrayList<Minion> field) {
		this.field = field;
	}


	public String getName() {
		return name;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public boolean isHeroPowerUsed() {
		return heroPowerUsed;
	}

	public int getTotalManaCrystals() {
		return totalManaCrystals;
	}

	public int getCurrentManaCrystals() {
		return currentManaCrystals;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Minion> getField() {
		return field;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	final public static ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException {
		ArrayList<Minion> m = new ArrayList<Minion>();
		int x = 1;
		String[] s;
		String currentLine = "";
		FileReader fileReader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
			s = currentLine.split(",");
			if (s[0].equals("Icehowl")) {
				Minion n = new Icehowl(Boolean.parseBoolean(s[5]), Boolean.parseBoolean(s[6]));
				m.add(n);
			} else {
				Rarity r = Rarity.BASIC;
				switch (s[2]) {
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

				Minion n = new Minion(s[0], Integer.parseInt(s[1]), r, Integer.parseInt(s[3]), Integer.parseInt(s[4]),
						Boolean.parseBoolean(s[5]), Boolean.parseBoolean(s[6]), Boolean.parseBoolean(s[7]));
				m.add(n);
			}

		}
		return m;
	}

	final public static ArrayList<Minion> getNeutralMinions(ArrayList<Minion> minions, int count) {
		Boolean k = false;
		Minion c;
		int x;
		ArrayList<Minion> m = new ArrayList<Minion>();
		while (count >= 1) {
			x = (int) (Math.random() * (minions.size() - 1));
			count--;
			c = minions.get(x);
			if ((c.getRarity() == Rarity.LEGENDARY) && (k)) {
				count++;
				continue;
			} else {
				if ((c.getRarity() == Rarity.LEGENDARY)) {
					k = true;
				}
				if (!m.isEmpty()) {
					if (m.contains(c)) {
						m.remove(c);
						if (!m.isEmpty()) {
							if (m.contains(c)) {
								count++;
								m.remove(c);
							}

							m.add(c);
						}
					}
				}
				m.add(c);
			}
		}
		return m;
	}

	public void buildDeck(String l) throws IOException {
		switch (l) {
		case "Rexxar":
			Minion d = new Minion("King Krush", 9, Rarity.LEGENDARY, 8, 8, false, false, true);
			MultiShot e = new MultiShot();
			KillCommand t = new KillCommand();
			ArrayList<Card> c = new ArrayList<Card>();
			ArrayList<Minion> r = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 15);
			c.addAll(r);
			c.add(t);
			c.add(t);
			c.add(e);
			c.add(e);
			c.add(d);
			this.deck = c;
			;
			break;
		case "Jaina Proudmoore":
			Minion u = new Minion("Kalyegos", 10, Rarity.LEGENDARY, 4, 12, false, false, false);
			// TODO Auto-generated method stub
			ArrayList<Card> i = new ArrayList<Card>();
			ArrayList<Minion> p = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 13);
			i.addAll(p);
			i.add(new Polymorph());
			i.add(new Polymorph());
			i.add(new Flamestrike());
			i.add(new Flamestrike());
			i.add(new Pyroblast());
			i.add(new Pyroblast());
			i.add(u);
			this.deck = i;
			break;
		case"Anduin Wryun":
			ArrayList<Card> j = new ArrayList<Card>();
			ArrayList<Minion> q = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 13);
			j.addAll(q);
			j.add(new DivineSpirit());
			j.add(new DivineSpirit());
			j.add(new HolyNova());
			j.add(new ShadowWordDeath());
			j.add(new HolyNova());
			j.add(new ShadowWordDeath());
			j.add(new Minion("Prophet Velen", 7, Rarity.LEGENDARY, 7, 7, false, false, false));
			this.deck=j;break;
		case"Gul'dan":ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Minion> h = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 13);
		b.addAll(h);
		b.add(new CurseOfWeakness());
		b.add(new SiphonSoul());
		b.add(new TwistingNether());
		b.add(new CurseOfWeakness());
		b.add(new SiphonSoul());
		b.add(new TwistingNether());
		b.add(new Minion("wilfred", 6, Rarity.LEGENDARY, 4, 4, false, false, false));
		this.deck=b;
		
		case"Uther Lightbringer":ArrayList<Card> z = new ArrayList<Card>();
		ArrayList<Minion> v = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 15);
		z.addAll(v);
		z.add(new SealOfChampions());
		z.add(new SealOfChampions());
		z.add(new LevelUp());
		z.add(new Minion("Tirion Fording", 4, Rarity.LEGENDARY, 6, 6, true, true, false));
		this.deck=z;
}
	}
}