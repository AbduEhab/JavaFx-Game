package model.cards.spells;

import model.cards.Rarity;

public class KillCommand extends Spell implements HeroTargetSpell, MinionTargetSpell {

	public KillCommand() {
		super("Kill Command", 3, Rarity.COMMON);
	}

}
