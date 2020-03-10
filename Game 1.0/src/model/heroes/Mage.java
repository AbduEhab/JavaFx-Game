package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.Flamestrike;
import model.cards.spells.Polymorph;

public class Mage extends Hero{

	public Mage() {
		super("Jaina Proudmoore");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildDeck() throws IOException {
		Minion u=new Minion("Kalyegos",10 ,Rarity.KEGENDARY,4,12);
		// TODO Auto-generated method stub
		ArrayList<Card>c=new ArrayList<Card>();
		ArrayList<Minion> r=getNeutralMinions(getAllNeutralMinions("edfghjklhgfdsfgh"),13);
		c.addAll(r);
		c.add(new Polymorph());
		c.add(new Polymorph());
		c.add(new Flamestrike());
		c.add(new Flamestrike());
	}

}
