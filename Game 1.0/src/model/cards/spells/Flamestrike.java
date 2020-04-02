package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class Flamestrike extends Spell implements AOESpell {

	public Flamestrike() {
		super("Flamestrike", 7, Rarity.BASIC);
	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		// TODO Auto-generated method stub

	}
}
