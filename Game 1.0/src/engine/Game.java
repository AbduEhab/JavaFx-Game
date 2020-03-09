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

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

}
