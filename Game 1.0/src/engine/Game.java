package engine;

import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.HeroListener;

public class Game implements ActionValidator, HeroListener {
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
		if (attacker.getAttack() == 0)
			throw new CannotAttackException("this minion has zero attack points");
		else if (target.getField().contains(attacker))
			throw new InvalidTargetException();
		else if (hasTaunt(opponent))
			throw new TauntBypassException();

	}

	@Override
	public void validateManaCost(Card card) throws NotEnoughManaException {
		if (!(currentHero.getCurrentManaCrystals() <= card.getManaCost()))
			throw new NotEnoughManaException();
	}

	@Override
	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		if (currentHero.getField().size() == 7)
			throw new FullFieldException();

	}

	@Override
	public void validateUsingHeroPower(Hero hero) throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		if (currentHero.isHeroPowerUsed())
			throw new HeroPowerAlreadyUsedException();
		if (!(currentHero.getCurrentManaCrystals() >= 2))
			throw new NotEnoughManaException();

	}

	@Override
	public void onHeroDeath() {
		// onGameOver();

	}

	@Override
	public void damageOpponent(int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endTurn() throws FullHandException, CloneNotSupportedException {
		// TODO Auto-generated method stub

	}

}
