package model.heroes;

import model.cards.Card;
import model.cards.minions.Minion;

abstract public class Hero {
	private String name;// geter
	private int currentHP;// getter and setter
	private boolean heroPowerUsed;// getter and setter
	private int totalManaCrystal;// getter and setter
	private int currentManaCrystal; // getter and setter
	private Card[] deck;// read
	private Minion[] field;// read
	private Card[] hand;// read
	private int fatigueDamage;// neither
//end of all 8 instance
// TODO Auto-generated constructor stub
//public static Minion[] getAllNeutralMinions(String filePath) {}

	public Hero(String n) {
		// TODO Auto-generated constructor stub
		{
			this.name = n;
		}
		deck = new Card[20];
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public void setHeroPowerUsed(boolean heroPowerUsed) {
		this.heroPowerUsed = heroPowerUsed;
	}

	public void setTotalManaCrystal(int totalManaCrystal) {
		this.totalManaCrystal = totalManaCrystal;
	}

	public void setCurrentManaCrystal(int currentManaCrystal) {
		this.currentManaCrystal = currentManaCrystal;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	}

	public void setField(Minion[] field) {
		this.field = field;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public boolean isHeroPowerUsed() {
		return heroPowerUsed;
	}

	public int getTotalManaCrystal() {
		return totalManaCrystal;
	}

	public int getCurrentManaCrystal() {
		return currentManaCrystal;
	}

	public Card[] getDeck() {
		return deck;
	}

	public Minion[] getField() {
		return field;
	}

	public Card[] getHand() {
		return hand;
	}
}