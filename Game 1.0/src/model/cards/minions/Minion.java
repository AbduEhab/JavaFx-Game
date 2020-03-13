package model.cards.minions;

import model.cards.Card;
import model.cards.Rarity;

public class Minion extends Card {
	private int attack;
	private int maxHP;
	private int currentHP;
	private boolean taunt;
	private boolean divine;
	private boolean sleeping;
	private boolean attacked;

	public Minion() {
	}

	public Minion(String name, int manaCost, Rarity rarity, int attack, int maxHP, boolean taunt, boolean devine,
			boolean charge) {
		super(name, manaCost, rarity);
		if (attack < 0)
			this.attack = 0;
		else
			this.attack = attack;
		this.currentHP = maxHP;
		this.maxHP = maxHP;
		this.taunt = taunt;
		this.divine = devine;
		sleeping = !charge;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		if (attack < 0)
			this.attack = 0;
		else
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
		if (currentHP <= maxHP)
			this.currentHP = currentHP;
		else
			this.currentHP = maxHP;
	}

	public boolean getTaunt() {
		return this.taunt;
	}

	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}

	public boolean isDivine() {
		return this.divine;
	}

	public void setDivine(boolean devine) {
		this.divine = devine;
	}

	public boolean isSleeping() {
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
}