package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class LevelUp extends Spell implements FieldSpell {

	public LevelUp() {
		super("Level Up!", 6, Rarity.EPIC);

	}

	@Override
	public void performAction(ArrayList<Minion> field) {
		for (Minion m : field) {
			if (m.getName().equalsIgnoreCase("silver hand recruit")) {
				m.setAttack(m.getAttack() + 1);
				m.setMaxHP(m.getMaxHP() + 1);
				m.setCurrentHP(m.getCurrentHP() + 1);
			}
		}
	}

}
