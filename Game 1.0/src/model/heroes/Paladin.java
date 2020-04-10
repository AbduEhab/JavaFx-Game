package model.heroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.*;
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
	}

public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException{
	Minion l = new Minion("Silver Hand Recruit", 1, Rarity.BASIC, 1, 1, false, false, false);
	try {
	this.uhp();} catch (NotYourTurnException e) {
		System.out.println(e.getLocalizedMessage());
		return;
	} catch (HeroPowerAlreadyUsedException e) {
		System.out.println(e.getMessage());
		return;
	} catch (NotEnoughManaException e) {
		System.out.println(e.getMessage());
		return;
	}catch (FullFieldException e) {
		System.out.println(e.getMessage());
		return;
	}
	this.getField().add(l);}
}
