package engine;

import model.heroes.Hero;

public class Game {

	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;

	public Game(Hero p1, Hero p2) {
		firstHero = p1;
		secondHero = p2;
		int x = (int) (Math.random() * 10+1);
		if (x / 2 == 0) {
			opponent = p2;
			currentHero = p1;
		} else {
			opponent = p1;
			currentHero = p2;
		}

	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

}
