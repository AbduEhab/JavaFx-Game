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

	public Priest() throws IOException, CloneNotSupportedException {
		super("Anduin Wrynn");
	}

	@Override
	public void buildDeck() throws IOException, CloneNotSupportedException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 13);
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new DivineSpirit());
			getDeck().add(new HolyNova());
			getDeck().add(new ShadowWordDeath());
		}
		Minion velen = new Minion("Prophet Velen", 7, Rarity.LEGENDARY, 7, 7, false, false, false);

		getDeck().add(velen);
		Collections.shuffle(getDeck());}
	 public void useHeroPower(Hero h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
			try{super.useHeroPower();}
			catch(NotEnoughManaException e) {System.out.println(e.getMessage());return;}
			catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());return;}
			catch(NotYourTurnException e) {System.out.println(e.getMessage());return;}
			int value=2;
			for(Minion m:this.getField()) {if (m.getName().equalsIgnoreCase("Prophet Velen"))value=8;}
			this.restoreHP(h, value);}
	 public void useHeroPower(Minion h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
			try{super.useHeroPower();}
			catch(NotEnoughManaException e) {System.out.println(e.getMessage());return;}
			catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());return;}
			catch(NotYourTurnException e) {System.out.println(e.getMessage());return;}
			int value=2;
			for(Minion m:this.getField()) {if (m.getName().equalsIgnoreCase("Prophet Velen"))value=8;}
			this.restoreHP(h, value);}
}
