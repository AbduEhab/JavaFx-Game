package model.cards.minions;

import model.cards.Card;
import model.cards.Rarity;

public class Minion extends Card {
	private int attack;
	private int maxHP;
	private int currentHP;
	private boolean taunt;
	private boolean devine;
	private boolean sleeping;
	private boolean attacked;

	public Minion(boolean taunt, boolean devine) {
		super("Icehowl", 9, Rarity.LEGENDARY);
		this.attack = 10;
		this.currentHP = 10;
		this.maxHP = 10;
		this.taunt = taunt;
		this.devine = devine;
		sleeping = false;

	}

	public Minion(String name, int manaCost, Rarity rarity, int attack, int maxHP, boolean taunt, boolean devine,
			boolean charge) {
		super(name, manaCost, rarity);
		this.attack = attack;
		this.currentHP = maxHP;
		this.maxHP = maxHP;
		this.taunt = taunt;
		this.devine = devine;
		sleeping = !charge;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return this.currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public boolean getTaunt() {
		return this.taunt;
	}

	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}

	public boolean getDevine() {
		return this.devine;
	}

	public void setDevine(boolean devine) {
		this.devine = devine;
	}

	public boolean getSleeping() {
		return this.sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	public boolean getAttacked() {
		return this.attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}
	// instanceof, printStackTrace
	//test
}
