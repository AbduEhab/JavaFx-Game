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
			ArrayList<Minion> p = new ArrayList<Minion>();
			for (Minion m : oppField) {
				if (oppField.indexOf(m) == x)
					p.add(m);
			}
			while (!p.isEmpty())
				p.remove(0);

			int y = (int) (Math.random() * (oppField.size() - 1));
			for (Minion m : oppField) {
				if (oppField.indexOf(m) == y)
					p.add(m);
			}
			while (!p.isEmpty())
				p.remove(0);

		} else if (oppField.size() == 2) {
			ArrayList<Minion> p = new ArrayList<Minion>();
			for (Minion m : oppField) {
				if (!(m.getCurrentHP() - 4 < 0))
					m.setCurrentHP(m.getCurrentHP() - 2);
				else {
					p.add(m);
				}
			}
			while (!p.isEmpty())
				p.remove(0);
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