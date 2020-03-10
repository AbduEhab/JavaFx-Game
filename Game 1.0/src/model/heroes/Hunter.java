package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.KillCommand;
import model.cards.spells.MultiShot;

public class Hunter extends Hero {

	public Hunter() {
		super("Rexxar");
		// TODO Auto-generated constructor stub
		}

	@Override
	public void buildDeck() throws IOException {
		// TODO Auto-generated method stubmul
		Minion d =new Minion("King Krush",9,Rarity.LEGENDARY,8,8);
		MultiShot e=new MultiShot();
		KillCommand t=new KillCommand();
		ArrayList<Card>c=new ArrayList<Card>();
		ArrayList<Minion> r=getNeutralMinions(getAllNeutralMinions("edfghjklhgfdsfgh"),15);
		c.addAll(r);
		c.add(t);
		c.add(t);
		c.add(e);
		c.add(e);
		c.add(d);}

}