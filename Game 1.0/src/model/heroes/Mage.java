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
import model.cards.spells.Flamestrike;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;

public class Mage extends Hero {

	public Mage() throws IOException,CloneNotSupportedException {
		super("Jaina Proudmoore");
	}

	@Override
	public void buildDeck() throws IOException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 13);
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new Polymorph());
			getDeck().add(new Flamestrike());
			getDeck().add(new Pyroblast());
		}
		Minion kalycgos = (new Minion("Kalycgos", 10, Rarity.LEGENDARY, 4, 12, false, false, false));
		;
		getDeck().add(kalycgos);
		Collections.shuffle(getDeck());

		for(Card c:this.getDeck()) if(c instanceof Minion){((Minion) c).setListener(this);}}
	 public void useHeroPower(Hero h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
	try{super.useHeroPower(h);}
	catch(NotEnoughManaException e) {System.out.println(e.getMessage());}
	catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());}
	catch(NotYourTurnException e) {System.out.println(e.getMessage());}
	 this.inflictDamage(h, 1);}

	 public void useHeroPower(Minion h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
			try{super.useHeroPower(h);}
			catch(NotEnoughManaException e) {System.out.println(e.getMessage());}
			catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());}
			catch(NotYourTurnException e) {System.out.println(e.getMessage());}
			 this.inflictDamage(h, 1);}
	 }
