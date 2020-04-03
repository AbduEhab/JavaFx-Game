package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class TwistingNether extends Spell implements AOESpell {

	public TwistingNether() {
		super("Twisting Nether", 8, Rarity.EPIC);

	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		{
			ArrayList<Minion> p = new ArrayList<Minion>();
			for (Minion m : curField) {
				p.add(m);
			}
			while (!p.isEmpty())
				p.remove(0);
		}
		ArrayList<Minion> p = new ArrayList<Minion>();
		for (Minion m : oppField) {
			p.add(m);
		}
		while (!p.isEmpty())
			p.remove(0);
	}

}
