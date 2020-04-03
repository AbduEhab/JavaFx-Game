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
			int x = (int) (Math.random() * (oppField.size() - 1)), y = (int) (Math.random() * (oppField.size() - 1));
			for (int i = 0; i < oppField.size(); i++) {

				if (i == x || i == y)
					if (!(oppField.get(i).getCurrentHP() - 4 < 0))
						oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 2);
					else {
						oppField.remove(i);
					}
			}
		} else if (oppField.size() == 2) {
			for (Minion m : oppField) {
				if (!(m.getCurrentHP() - 4 < 0))
					m.setCurrentHP(m.getCurrentHP() - 2);
				else {
					oppField.remove(m);
				}
			}
		} else if (oppField.size() == 1) {
			for (Minion m : oppField) {

				if (!(m.getCurrentHP() - 4 < 0))
					m.setCurrentHP(m.getCurrentHP() - 2);
				else {
					oppField.remove(m);
				}
			}
		}
	}
}