package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class KillCommand extends Spell implements MinionTargetSpell, HeroTargetSpell {

	public KillCommand() {
		super("Kill Command", 3, Rarity.COMMON);

	}

	@Override
	public void performAction(Hero h) {
		if (!(h.getCurrentHP() - 3 < 0))
			h.setCurrentHP(h.getCurrentHP() - 3);
	}

	@Override
	public void performAction(Minion m) throws InvalidTargetException {
		if (!(m.getCurrentHP() - 5 <= 0))
			m.setCurrentHP(m.getCurrentHP() - 5); 
		else {
			m.setCurrentHP(0);
		}
	}
}
