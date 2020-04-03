package model.cards.spells;

import java.util.ArrayList;
import engine.Game;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class Flamestrike extends Spell implements AOESpell {

	public Flamestrike() {
		super("Flamestrike", 7, Rarity.BASIC);
	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		for (Minion m : oppField) {
			if (!(m.getCurrentHP() - 4 < 0))
				m.setCurrentHP(m.getCurrentHP() - 2);
			else {
				oppField.remove(m);
			}
		}
	}
}
