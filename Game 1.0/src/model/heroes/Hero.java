package model.heroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;

abstract public class Hero {
	private String name;// geter
	private int currentHP;// getter and setter
	private boolean heroPowerUsed;// getter and setter
	private int totalManaCrystal;// getter and setter
	private int currentManaCrystal; // getter and setter
	private ArrayList<Card> deck;// read
	private ArrayList<Minion> field;// read
	private ArrayList<Card> hand;// read
	private int fatigueDamage;// neither
//end of all 8 instance
// TODO Auto-generated constructor stub
//public static Minion[] getAllNeutralMinions(String filePath) {}

	public Hero(String n) {
		// TODO Auto-generated constructor stub
		{
			this.name = n;
		}
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

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public void setField(ArrayList<Minion> field) {
		this.field = field;
	}

	public void setHand(ArrayList<Card> hand) {
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

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Minion> getField() {
		return field;
	}

	public ArrayList<Card> getHand() {return hand;}
	
	public static ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException{
		ArrayList<Minion> m=new ArrayList<Minion>();
		int x=1;
		String []s;
		String currentLine="";
		FileReader fileReader= new FileReader(filePath);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
	   s=currentLine.split(",");
	   Rarity r=Rarity.BASIC;
	   switch (s[2]) {
	   case "c":r=Rarity.COMMON; 
	   case"r":r=Rarity.RARE;
	   case"e":r=Rarity.EPIC;
	   case"l":r=Rarity.LEGENDARY;
	   }
	   
	   Minion n =new Minion(s[0] , Integer.parseInt(s[1]),Integer.parseInt(s[3]),r,Integer.parseInt(s[4]),Boolean.parseBoolean(s[5]),Boolean.parseBoolean(s[6]),Boolean.parseBoolean(s[7]));;
	    m.add(n);
		   
	   }
		return m;}
	public static  ArrayList<Minion> getNeutralMinions(ArrayList<Minion> minions,int count){
		Minion c;
		int x;
		ArrayList<Minion>m=new ArrayList<Minion>();
		while (count!=0) {x=(int)(Math.random()*(minions.size()-1)+1);
		count--;
		c=minions.get(x);
		if (m.contains(c)) {m.remove(c);
		if(m.contains(c)) {count++;m.remove(c);}
		m.add(c);} 
		m.add(c);}
	return m;}
	abstract public void buildDeck() throws IOException;
}