package engine;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.cards.Card;
import model.cards.minions.Minion;

public class CardPane extends GridPane {

	private Label name;
	private Button selector;
	private TextField mana;
	private TextField devine;
	private TextField taunt;
	private TextField sleeping;

	public CardPane(Card c, Main main) {

		setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefSize(110, 144);
		name = new Label(c.getName());
		

		add(name, 0, 0, 5, 1);

		selector = new Button("Select");
		selector.setOnAction(e -> {
			if (main.getActionInatiator() == null) {
				main.setActionInatiator(c);
				((Button) e.getSource()).setText("selected");
			} else if (main.getActionInatiator() == c) {
				main.setActionInatiator(null);
				((Button) e.getSource()).setText("select");
			} else {
				main.setActionInatiated(c);
			}
		});
		add(selector, 0, 2, 5, 3);

		mana = new TextField(c.getManaCost() + "");
		add(mana, 5, 1);

		if (c instanceof Minion) {
			if (((Minion) c).isDivine()) {
				devine = new TextField("D");
				add(devine, 2, 1);
			}
			if (((Minion) c).isTaunt()) {
				taunt = new TextField("T");
				add(taunt, 3, 1);
			}
			if (((Minion) c).isSleeping()) {
				sleeping = new TextField("S");
				add(sleeping, 4, 1);
			}
		}

		setHgap(5);
		setVgap(10);
		setPadding(new Insets(3, 3, 5, 3));

//		name.setStyle("-fx-fill:  white");
	}

	public Label getName() {
		return name;
	}

	public Button getSelector() {
		return selector;
	}

	public TextField getMana() {
		return mana;
	}

	public TextField getDevine() {
		return devine;
	}

	public TextField getTaunt() {
		return taunt;
	}

	public TextField getSleeping() {
		return sleeping;
	}

}
