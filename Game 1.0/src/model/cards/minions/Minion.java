package model.cards.minions;

import model.cards.Card;
import model.cards.Rarity;

public class Minion extends Card {
	int attack;
	int maxHP;
	int currentHP;
	boolean taunt;
	boolean devine;
	boolean sleeping;
	boolean attacked;

	public Minion(String name, int manaCost, Rarity rarity, int attack, int currentHP, int maxHP, boolean taunt,
			boolean devine, boolean charge) {
		super(name, manaCost, rarity);
		this.attack = attack;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.taunt = taunt;
		this.devine = devine;
		sleeping = charge;

	}
	// instanceof, printStackTrace
}
