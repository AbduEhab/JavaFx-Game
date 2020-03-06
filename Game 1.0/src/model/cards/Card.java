package model.cards;

abstract public class Card {
	String name;
	int manaCost;
	private Rarity rarity;

	public Card(String name, int manaCost, Rarity rarity) {
		this.name = name;
		this.manaCost = manaCost;
		this.rarity = rarity;
	}
}
