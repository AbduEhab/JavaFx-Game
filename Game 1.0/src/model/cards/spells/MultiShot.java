package model.cards.spells;

import model.cards.Rarity;

public class MultiShot extends Spell implements AOESpell{

	public MultiShot() {
		super("MultiShot", 4, Rarity.Basic);
	}

}
