package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.SealOfChampions;

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
		ArrayList<Minion> r = getNeutralMinions(getAllNeutralMinions("edfghjklhgfdsfgh"), 13);
		c.addAll(r);
	}

}
