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
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.HeroListener;
import model.heroes.Mage;

public class Game implements ActionValidator, HeroListener {
	GameListener listener;
	HeroListener clistener;
	HeroListener olistener;

//habd //neek wmdi2 error ya mtnak
	private Hero firstHero;
	// a7a btl 3olo2ya ya fady

	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;

	public Game(Hero p1, Hero p2) throws FullHandException, CloneNotSupportedException {
		firstHero = p1;
		secondHero = p2;

		int coin = (int) (Math.random() * 2);
		currentHero = coin == 0 ? firstHero : secondHero;
		opponent = currentHero == firstHero ? secondHero : firstHero;
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);
		currentHero.drawCard();
		currentHero.drawCard();
		currentHero.drawCard();
		opponent.drawCard();
		opponent.drawCard();
		opponent.drawCard();
		opponent.drawCard();
		currentHero.setListener(clistener);
		opponent.setListener(olistener);

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
			throw new NotYourTurnException("Not your turn");
	}

	@Override
	public void validateAttack(Minion attacker, Minion target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if (attacker.isAttacked())
			throw new CannotAttackException("this minion has zero attack points");
		else if (currentHero.getField().contains(target))
			throw new InvalidTargetException("invalid target");
		else if (target.isDivine())
			throw new InvalidTargetException("invalid target");
		else if (hasTaunt(opponent))
			throw new TauntBypassException("he has Taunt");
		else if (!(opponent.getField().contains(target)))
			throw new NotSummonedException("not summoned");
		else if (!(currentHero.getField().contains(attacker)))
			throw new NotSummonedException("not summoned");

	}

	public boolean hasTaunt(Hero h) {
		for (Minion m : h.getField()) {
			if (m.isTaunt())
				return true;
		}
		return false;
	}

	@Override
	public void validateAttack(Minion attacker, Hero target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if (attacker instanceof Icehowl)
			throw new CannotAttackException();
		else if (attacker.isSleeping())
			throw new CannotAttackException();
		else if (attacker.isAttacked())
			throw new CannotAttackException("this minion has zero attack points");
		else if (target.getField().contains(attacker))
			throw new InvalidTargetException("invalid target");
		else if (hasTaunt(opponent))
			throw new TauntBypassException("he has Taunt");

	}

	public void validateManaCost(Card card) throws NotEnoughManaException {
		boolean flag = false;
		if (currentHero instanceof Mage) {
			for (Minion q : currentHero.getField()) {
				if (q.getName().equalsIgnoreCase("Kalycgos"))
					flag = true;
			}
			if (flag) {
				if (!(currentHero.getCurrentManaCrystals() < card.getManaCost() - 4))
					throw new NotEnoughManaException();
				return;
			}
		}
		if (!(currentHero.getCurrentManaCrystals() < card.getManaCost()))
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
		listener.onGameOver();

	}

	@Override
	public void damageOpponent(int amount) {
		opponent.setCurrentHP(opponent.getCurrentHP() - amount);

	}

	@Override
	public void endTurn() throws FullHandException, CloneNotSupportedException {
		Hero temp = currentHero;
		currentHero = opponent;
		opponent = temp;
		currentHero.setTotalManaCrystals(currentHero.getTotalManaCrystals() + 1);
		currentHero.setCurrentManaCrystals(currentHero.getTotalManaCrystals());
		currentHero.setHeroPowerUsed(false);
		wakeUpMinions(currentHero);
		resetMinionAttack(currentHero);
		currentHero.getHand().add(currentHero.drawCard());
	}

	public void resetMinionAttack(Hero h) {
		for (Minion m : h.getField())
			m.setAttacked(false);
	}

	public void wakeUpMinions(Hero h) {
		for (Minion m : h.getField())
			m.setSleeping(false);
	}

	public void setListener(GameListener listener) {
		this.listener = listener;
	}

}
