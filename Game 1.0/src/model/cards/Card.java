package model.cards;

abstract public class Card {
	private String name;
	private int manaCost;
	private Rarity rarity;

	public Card() {
	}

	public Card(String name, int manaCost, Rarity rarity) {
		this.name = name;
		while(manaCost<=0 || manaCost>10) {
			if(manaCost<0)
				manaCost+=10;
			else
				manaCost-=10;
		}
		this.manaCost = manaCost;
		this.rarity = rarity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public Rarity getRarity() {
		return this.rarity;
	}
}
