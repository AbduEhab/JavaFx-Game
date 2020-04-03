package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class HolyNova extends Spell implements AOESpell {

	public HolyNova() {
		super("Holy Nova", 5, Rarity.BASIC);

	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		{
			for (Minion m : oppField) {
				if (!(m.getCurrentHP() - 4 <= 0))
					m.setCurrentHP(m.getCurrentHP() - 2);
				else {
					oppField.remove(m);
				}
			}
			for (Minion m : curField) {
				m.setCurrentHP(m.getCurrentHP() + 2 > m.getMaxHP() ? m.getMaxHP() : m.getCurrentHP() + 2);
			}
		}
	}

}
