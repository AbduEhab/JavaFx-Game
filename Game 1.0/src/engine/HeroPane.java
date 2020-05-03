package engine;

import javafx.scene.layout.GridPane;
import model.heroes.Hero;

public class HeroPane extends GridPane {
	private Hero hero;

	public HeroPane(Hero h, Main main) {// create the pane, add the name and manacost, set the action handler (similar
										// to the one in card pane) and set the effects)

	}

	public Hero getHero() {
		return hero;
	}

}
