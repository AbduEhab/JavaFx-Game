package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class HolyNova extends Spell implements AOESpell {

	public HolyNova() {
		super("Holy Nova", 5, Rarity.BASIC);

	}

	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {

		ArrayList<Minion> p = new ArrayList<Minion>();
		for (int i = 0; i < oppField.size(); i++) {
			if (oppField.get(i).getCurrentHP() - 2 == 0) {
				oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 2);
				i--;
			} else
				oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 2);
		}
		for (Minion m : curField) {
			m.setCurrentHP(m.getCurrentHP() + 2 > m.getMaxHP() ? m.getMaxHP() : m.getCurrentHP() + 2);
		}
	}
}
/*
 * if (n.getCurrentHP() - 2 == 0) p.add(n); else n.setCurrentHP(n.getCurrentHP()
 * - 2); } while (!p.isEmpty()) p.get(0).setCurrentHP(0);
 */