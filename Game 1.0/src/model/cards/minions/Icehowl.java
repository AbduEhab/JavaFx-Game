package model.cards.minions;

import model.cards.Rarity;

public class Icehowl extends Minion {
	public Icehowl() {
		super("Icehowl", 9, Rarity.LEGENDARY, 10, 10, false, false, true);
	}

	public Icehowl(boolean taunt, boolean devine) {
		super("Icehowl", 9, Rarity.LEGENDARY, 10, 10, taunt, devine, true);
	}
}
