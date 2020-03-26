package engine;

import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class Game implements GameListener, ActionValidator {
	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;

	public Game(Hero p1, Hero p2) {
		firstHero = p1;
		secondHero = p2;

		int coin = (int) (Math.random() * 2);
		currentHero = coin == 0 ? firstHero : secondHero;
		opponent = currentHero == firstHero ? secondHero : firstHero;
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);

	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

	public void onGameOver() {

	}

	@Override
	public void validateTurn(Hero user) throws NotYourTurnException {
		if (currentHero != user)
			throw new NotYourTurnException();
	}

	@Override
	public void validateAttack(Minion attacker, Minion target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if (attacker.getAttack() == 0)
			throw new CannotAttackException("this minion has zero attack points");
		else if (currentHero.getField().contains(target))
			throw new InvalidTargetException();
		else if (!opponent.getDeck().contains(target))
			throw new NotSummonedException();
		else if (hasTaunt(opponent))
			throw new TauntBypassException();
	}

	public boolean hasTaunt(Hero h) {
		for (Minion m : h.getField()) {
			if (!m.isTaunt())
				return true;
		}
		return false;

	}

	@Override
	public void validateAttack(Minion attacker, Hero target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateManaCost(Card card) throws NotEnoughManaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateUsingHeroPower(Hero hero) throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		// TODO Auto-generated method stub

	}

}
