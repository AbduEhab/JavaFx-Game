package model.cards;

public abstract class Card implements Cloneable {
	private String name;
	private int manaCost;
	private Rarity rarity;

	public Card(String name, int manaCost, Rarity rarity) {
		this.name = name;
		setManaCost(manaCost);
		this.rarity = rarity;
	}

	public @Override Card clone() throws CloneNotSupportedException {
		return (Card) super.clone();
	}

	public int getManaCost() {
		return manaCost;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
		if (this.manaCost > 10)
			this.manaCost = 10;
		else if (this.manaCost < 0)
			this.manaCost = 0;
	}

}
