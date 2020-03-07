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
}