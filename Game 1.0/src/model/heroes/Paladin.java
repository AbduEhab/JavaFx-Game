package model.heroes;
import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.LevelUp;
import model.cards.spells.SealOfChampions;

public class Paladin extends Hero {

	public Paladin() throws IOException {
		super("Uther Lightbringer");
		// TODO Auto-generated constructor stub
		buildDeck();
	}

	@Override
	public void buildDeck() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Minion> r = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 15);
		c.addAll(r);
		c.add(new SealOfChampions());
		c.add(new SealOfChampions());
		c.add(new LevelUp());
		c.add(new Minion("Tirion Fording", 4, Rarity.LEGENDARY, 6, 6, true, true, false));
		setDeck(c);

	}

}
