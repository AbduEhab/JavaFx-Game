package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.SiphonSoul;
import model.cards.spells.TwistingNether;

public class Warlock extends Hero {
	public Warlock() {
		super("Gul'dan");
	}

	@Override
	public void buildDeck() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Minion> r = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 13);
		c.addAll(r);
		c.add(new CurseOfWeakness());
		c.add(new SiphonSoul());
		c.add(new TwistingNether());
		c.add(new CurseOfWeakness());
		c.add(new SiphonSoul());
		c.add(new TwistingNether());
		c.add(new Minion("wilfred", 6, Rarity.LEGENDARY, 4, 4, false, false, false));

	}

}
