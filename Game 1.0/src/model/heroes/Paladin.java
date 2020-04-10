package model.heroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.*;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.minions.MinionListener;
import model.cards.spells.LevelUp;
import model.cards.spells.SealOfChampions;

public class Paladin extends Hero implements MinionListener {
	public Paladin() throws IOException,CloneNotSupportedException
	{
		super("Uther Lightbringer");
	}
	
	@Override
	public void buildDeck() throws IOException {
		ArrayList<Minion> neutrals= getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),15);
		getDeck().addAll(neutrals);
		for(int i = 0 ; i < 2; i++)
		{
			getDeck().add(new SealOfChampions());
			getDeck().add(new LevelUp());
		}
		Minion tirion=new Minion("Tirion Fordring", 4, Rarity.LEGENDARY, 6, 6, true, true, false);
	
		getDeck().add(tirion);
		Collections.shuffle(getDeck());
	for(Card c:this.getDeck()) if(c instanceof Minion){((Minion) c).setListener(this);}}
	public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
		Minion h=new Minion("Silver Hand Recruit", 1, Rarity.BASIC, 1, 1, false, false, false);
		h.setListener(this);
		try {super.useHeroPower();}
		catch(NotEnoughManaException e) {System.out.println(e.getMessage());return;}
		catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());return;}
		catch(NotYourTurnException e) {System.out.println(e.getMessage());return;}
		try {super.useHeroPower(h);}
		catch(FullFieldException e) {System.out.println(e.getMessage());return;}
		catch(NotEnoughManaException e) {System.out.println(e.getMessage());return;}
		this.getField().add(h);
}
}
