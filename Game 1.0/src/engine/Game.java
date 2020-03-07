package engine;

import model.heroes.Hero;

public class Game {

	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;

	public Game(Hero p1, Hero p2) {
		int x = (int) Math.random() * 100 + 1;
		if (x / 2 == 0) {
			firstHero = p1;
			currentHero = p1;
		} else {
			secondHero = p2;
			opponent = p2;
		}
	}

	public Hero getSecondHero() {
		return secondHero;
	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public void setCurrentHero(Hero currentHero) {
		this.currentHero = currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

	public void setOpponent(Hero opponent) {
		this.opponent = opponent;
	}

}
