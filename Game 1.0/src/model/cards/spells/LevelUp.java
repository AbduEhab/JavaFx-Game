package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class LevelUp extends Spell implements FieldSpell {

	public LevelUp() {
		super("Level Up!", 6, Rarity.EPIC);
		
	}

	@Override
	public void performAction(ArrayList<Minion> field) {
		// TODO Auto-generated method stub
		
	}

}
