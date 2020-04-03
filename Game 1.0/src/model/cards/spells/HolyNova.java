package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.minions.MinionListener;

public class HolyNova extends Spell implements AOESpell {

	public HolyNova() {
		super("Holy Nova", 5, Rarity.BASIC);

	}

	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		{
			ArrayList<Minion> p= new ArrayList<Minion>();
			for (Minion m : oppField) {
				if (!(m.getCurrentHP() - 4 < 0))
					m.setCurrentHP(m.getCurrentHP() - 2);
				else {
					p.add(m);
					
				}
			}
			while(!p.isEmpty())
				p.remove(0);
		}
		for (Minion m : curField) {
			m.setCurrentHP(m.getCurrentHP() + 2 > m.getMaxHP() ? m.getMaxHP() : m.getCurrentHP() + 2);
		}
	}
}
