package model.heroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.DivineSpirit;
import model.cards.spells.HolyNova;
import model.cards.spells.ShadowWordDeath;

public class Priest extends Hero {

	public Priest() throws IOException {
		super("Anduin Wrynn");
	}

	@Override
	public void buildDeck() throws IOException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 13);
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new DivineSpirit());
			getDeck().add(new HolyNova());
			getDeck().add(new ShadowWordDeath());
		}
		Minion velen = new Minion("Prophet Velen", 7, Rarity.LEGENDARY, 7, 7, false, false, false);

		getDeck().add(velen);
		Collections.shuffle(getDeck());

	}

	public void useHeroPower(Object l) throws NotEnoughManaException, HeroPowerAlreadyUsedException,
			NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException {
		String o = l.getClass() + "";
		if (o.equals("Hero")) {
			this.restoreHP((Hero) l, 2);
		} else {
			this.restoreHP((Minion) l, 2);
		}
	}

}
