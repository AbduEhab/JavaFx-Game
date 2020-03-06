package model.cards.spells;

import model.cards.Rarity;

public class LevelUp extends Spell implements FieldSpell {
	public LevelUp() {
		super("LevelUp", 6, Rarity.EPIC);
	}
}
