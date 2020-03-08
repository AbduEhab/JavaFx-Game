package exceptions;

import model.cards.Card;

public class FullHandException extends HearthstoneException {
	private Card burned;
	
	public FullHandException(Card b) {
		burned = b;
	}


}
