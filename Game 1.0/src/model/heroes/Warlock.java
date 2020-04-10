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
import model.cards.minions.MinionListener;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.SiphonSoul;
import model.cards.spells.TwistingNether;

public class Warlock extends Hero implements MinionListener{
	public void onMinionDeath(Minion m) {
		this.getField().remove(m);
	}

	public Warlock() throws IOException ,CloneNotSupportedException{
		super("Gul'dan");
	}

	@Override
	public void buildDeck() throws IOException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 13);
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new CurseOfWeakness());
			getDeck().add(new SiphonSoul());
			getDeck().add(new TwistingNether());
		}
		Minion wilfred = new Minion("Wilfred Fizzlebang", 6, Rarity.LEGENDARY, 4, 4, false, false, false);
		getDeck().add(wilfred);
		Collections.shuffle(getDeck());

	}
	public void useHeroPower(Hero h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
		try{super.useHeroPower();}
		catch(NotEnoughManaException e) {System.out.println(e.getMessage());}
		catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());}
		catch(NotYourTurnException e) {System.out.println(e.getMessage());}
		try{this.drawCard();}catch(FullHandException e){System.out.println(e.getMessage());} 
		if (h==null) this.inflictDamage(this, 2);
		else this.inflictDamage(h, 2);}
public void useHeroPower(Minion h) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
	try{super.useHeroPower();}
	catch(NotEnoughManaException e) {System.out.println(e.getMessage());}
	catch(HeroPowerAlreadyUsedException e) {System.out.println(e.getMessage());}
	catch(NotYourTurnException e) {System.out.println(e.getMessage());}
	try{this.drawCard();}catch(FullHandException e){System.out.println(e.getMessage());} 
	if (h==null) this.inflictDamage(this, 2);
	else this.inflictDamage(h, 2);}
}