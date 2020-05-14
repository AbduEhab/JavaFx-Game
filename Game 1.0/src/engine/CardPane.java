package engine;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.cards.Card;
import model.cards.minions.Minion;

public class CardPane extends GridPane {

	@SuppressWarnings("unused")
	private GridPane root;
	private Card card;
	private TextField name;
	private TextField mana;
	private TextField devine;
	private TextField taunt;
	private TextField sleeping;
	private TextField attack;
	private TextField hp;

	public CardPane(Card c, Main main, GridPane root) {
		card = c;
		this.root = root;

		if (c instanceof Minion && ((Minion) c).isAttacked())
			setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefHeight(root.getHeight());

		setPrefSize(128, 144);
		name = new TextField(c.getName());
//		name.setFill(Color.CORAL);
		name.setFont(new Font("Arial", 15));
		name.setDisable(true);

		switch (c.getRarity()) {
		case RARE:
			name.setStyle("-fx-border-color:  blue");
			break;
		case COMMON:
			name.setStyle("-fx-border-color:  green");
			break;
		case EPIC:
			name.setStyle("-fx-border-color:  purple");
			break;
		case LEGENDARY:
			name.setStyle("-fx-border-color:  gold");
		case BASIC:
			name.setStyle("-fx-border-color:  white");
			break;
		}

		this.add(name, 0, 0, 5, 1);

		setOnMouseClicked(e -> {
			if (main.getActionInatiator() == null && main.getSelector() == null) {
				main.setActionInatiator(this);
				setStyle("-fx-border-color: yellow");
			} else if (main.getActionInatiator() == this) {
				main.setActionInatiator(null);
				setStyle("-fx-border-color: null");
			} else {
				main.setActionInatiated(this);
				main.process();
			}
		});

		mana = new TextField(c.getManaCost() + "");
		mana.setDisable(true);
		mana.setStyle("-fx-text-fill: blue");
		mana.setStyle("-fx-border-color: cyan");
		add(mana, 4, 1);

		attack = new TextField();
		hp = new TextField();
		if (c instanceof Minion) {

			if (((Minion) c).isDivine()) {
				devine = new TextField("D");
				devine.setDisable(true);
				add(devine, 3, 2);
			}
			if (((Minion) c).isTaunt()) {
				taunt = new TextField("T");
				taunt.setDisable(true);
				add(taunt, 4, 2);
			}
			if (((Minion) c).isSleeping()) {
				sleeping = new TextField("S");
				sleeping.setDisable(true);
				add(sleeping, 1, 2);
			}
			attack.setText(((Minion) c).getAttack() + "");
			hp.setText(((Minion) c).getCurrentHP() + "");
			hp.setDisable(true);
			attack.setDisable(true);
			attack.setStyle("-fx-text-fill: red");
			if (((Minion) c).getMaxHP() / 2 <= ((Minion) c).getCurrentHP()) {
				hp.setStyle("-fx-border-color: green");
			} else if (((Minion) c).getMaxHP() / 4 <= ((Minion) c).getCurrentHP()) {
				hp.setStyle("-fx-border-color: yellow");
			} else
				hp.setStyle("-fx-border-color: red");

			add(attack, 3, 1);
			add(hp, 1, 1);

		}

		setHgap(2);
		setVgap(10);
//		this.setId("cardpane");

	}

	public Card getCard() {
		return card;
	}

	public TextField getName() {
		return name;
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

	public TextField getAttack() {
		return attack;
	}

	public TextField getHp() {
		return hp;
	}

}
