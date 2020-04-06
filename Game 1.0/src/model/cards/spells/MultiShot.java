package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class MultiShot extends Spell implements AOESpell {

	public MultiShot() {
		super("Multi-Shot", 4, Rarity.BASIC);

	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		if (oppField.size() >= 3) {

			int x = (int) (Math.random() * (oppField.size() - 1));
			oppField.get(x).setCurrentHP(oppField.get(x).getCurrentHP() - 4);
			;

			int y = (int) (Math.random() * (oppField.size() - 1));
			oppField.get(y).setCurrentHP(oppField.get(y).getCurrentHP() - 4);

		} else if (oppField.size() == 2) {
			oppField.get(0).setCurrentHP(oppField.get(0).getCurrentHP() - 4);
			oppField.get(1).setCurrentHP(oppField.get(1).getCurrentHP() - 4);
		} else if (oppField.size() == 1) {
			oppField.get(0).setCurrentHP(oppField.get(0).getCurrentHP() - 4);
		}
	}
}