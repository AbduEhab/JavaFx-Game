package model.heroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.KillCommand;
import model.cards.spells.MultiShot;

public class Hunter extends Hero {

	public Hunter() throws IOException, CloneNotSupportedException {
		super("Rexxar");
	}

	@Override
	public void buildDeck() throws IOException, CloneNotSupportedException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 15);
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new KillCommand());
			getDeck().add(new MultiShot());

		}
		Minion krush = (new Minion("King Krush", 9, Rarity.LEGENDARY, 8, 8, false, false, true));

		getDeck().add(krush);
		Collections.shuffle(getDeck());
		for (Card c : this.getDeck())
			if (c instanceof Minion) {
				((Minion) c).setListener(this);
			}
		ArrayList<Card> t = new ArrayList<Card>();
		while (!this.getDeck().isEmpty()) {
			t.add(this.getDeck().remove(0));
		}
		while (!t.isEmpty()) {
			this.getDeck().add(t.remove(0).clone());
		}
	}

	public void useHeroPower(Hero h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException,
			FullHandException, FullFieldException, CloneNotSupportedException {
		try {
			super.useHeroPower();
		} catch (NotEnoughManaException e) {
			System.out.println(e.getMessage());
			return;
		} catch (HeroPowerAlreadyUsedException e) {
			System.out.println(e.getMessage());
			return;
		} catch (NotYourTurnException e) {
			System.out.println(e.getMessage());
			return;
		}
		this.inflictDamage(h, 2);
	}

}
