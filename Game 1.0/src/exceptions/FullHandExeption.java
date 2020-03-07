package exceptions;

import model.cards.Card;

public class FullHandExeption extends Exception {
	Card burned;

	public FullHandExeption(Card b) {
	}

	public FullHandExeption(String message, Card b) {
		super(message);
	}

}
