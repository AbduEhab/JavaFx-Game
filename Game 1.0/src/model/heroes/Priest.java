package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.DivineSpirit;
import model.cards.spells.HolyNova;
import model.cards.spells.SealOfChampions;
import model.cards.spells.ShadowWordDeath;

public class Priest extends Hero {

	public Priest() throws IOException {
		super("Anduin Wryun");
		buildDeck();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildDeck() throws IOException {
		// TODO Auto-generated method stu
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Minion> r = getNeutralMinions(getAllNeutralMinions("neutral_minion.csv"), 13);
		c.addAll(r);
		c.add(new DivineSpirit());
		c.add(new DivineSpirit());
		c.add(new HolyNova());
		c.add(new ShadowWordDeath());
		c.add(new HolyNova());
		c.add(new ShadowWordDeath());
		c.add(new Minion("Prophet Velen", 7, Rarity.LEGENDARY, 7, 7, false, false, false));
	}

}
