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
			if (!oppField.get(x).isDivine())
				oppField.get(x).setCurrentHP(oppField.get(x).getCurrentHP() - 3);
			else
				oppField.get(x).setDivine(false);

			int y = (int) (Math.random() * (oppField.size() - 1));
			if (!oppField.get(y).isDivine())
				oppField.get(y).setCurrentHP(oppField.get(x).getCurrentHP() - 3);
			else
				oppField.get(y).setDivine(false);

		} else if (oppField.size() == 2) {
			if (!oppField.get(1).isDivine())
				oppField.get(1).setCurrentHP(oppField.get(1).getCurrentHP() - 3);
			else
				oppField.get(1).setDivine(false);

			if (!oppField.get(0).isDivine())
				oppField.get(0).setCurrentHP(oppField.get(0).getCurrentHP() - 3);
			else
				oppField.get(0).setDivine(false);
		} else if (oppField.size() == 1) {
			if (!oppField.get(0).isDivine())
				oppField.get(0).setCurrentHP(oppField.get(0).getCurrentHP() - 3);
			else
				oppField.get(0).setDivine(false);
		}
	}
}