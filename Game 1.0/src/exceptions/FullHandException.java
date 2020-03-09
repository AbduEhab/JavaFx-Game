package exceptions;

import model.cards.Card;

public class FullHandException extends HearthstoneException {
	private Card burned;

	public FullHandException(Card b) {
		super();
		burned = b;
	}

	FullHandException(String s, Card b) {
		super();
		burned = b;
	}

}
