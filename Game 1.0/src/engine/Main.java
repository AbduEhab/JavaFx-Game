package engine;

import java.io.IOException;

import exceptions.FullHandException;
import exceptions.InvalidTargetException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Paladin;
import model.heroes.Warlock;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Main extends Application {

	private CardPane actionInatiator;
	private CardPane actionInatiated;
	private HeroPane selected;
	private Object selectedField;

	private Game model;

	private BorderPane root;
	private Stage view;
	private Scene game;
	private Scene menu;
	private Scene gameover;
	private BorderPane left;
	private BorderPane right;
	private BorderPane top;
	private BorderPane bottom;
	private BorderPane center;
	private GridPane currHand;
	private GridPane currField;
	private GridPane oppField;

	public void start(Stage primaryStage) throws FullHandException, CloneNotSupportedException, IOException {
		view = primaryStage;

		model = new Game(new Warlock(), new Paladin());

		root = new BorderPane();

		game = new Scene(root, 1280, 720);

		BorderPane left = new BorderPane();
		left.setPrefSize(game.getWidth() * 12 / 100, game.getHeight() * 60 / 100);
		left.setStyle("-fx-border-color: blue");

		BorderPane right = new BorderPane();
		right.setPrefSize(game.getWidth() * 10 / 100, game.getHeight() * 60 / 100);
		right.setStyle("-fx-border-color: red");

		BorderPane top = new BorderPane();
		top.setPrefSize(game.getWidth() * 60 / 100, game.getHeight() * 20 / 100);
		top.setStyle("-fx-border-color: yellow");

		BorderPane bottom = new BorderPane();
		bottom.setPrefSize(game.getWidth() * 60 / 100, game.getHeight() * 20 / 100);

		GridPane currHand = new GridPane();

		currHand.setPadding(new Insets(20, 20, 5, 20));
		currHand.setHgap(7);
		for (int i = 0; i < model.getCurrentHero().getHand().size(); i++) {
			CardPane x = new CardPane(model.getCurrentHero().getHand().get(i), this, currHand);
			currHand.add(x, i, 0);
			x.setOnMouseEntered(e -> {

				x.setScaleX(1.12);
				x.setScaleY(1.12);
				if (e.getSource() == actionInatiator)
					x.setStyle("-fx-border-color: yellow");
				else
					x.setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
			});
			x.setOnMouseExited(e -> {
				if (!(e.getSource() == actionInatiator)) {
					x.setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
					x.setStyle("-fx-border-color: null");
					x.setScaleX(1);
					x.setScaleY(1);
				}
			});
		}
		currHand.setStyle("-fx-border-color: white");
		bottom.setCenter(currHand);

		center = new BorderPane();
		center.setPrefSize(game.getWidth() * 78 / 100, game.getHeight() * 60 / 100);

		currField = new GridPane();
		currField.setPadding(new Insets(60, 10, 3, 10));
		currField.setHgap(5);
		currField.setPrefSize(game.getWidth() * 78 / 100, game.getHeight() * 30 / 100);
		currField.setOnMouseClicked(e -> {
			if (actionInatiator != null) {
				selectedField = e.getSource();
				process();
			}
		});
		currField.setStyle("-fx-border-color: white");

		oppField = new GridPane();
		oppField.setPadding(new Insets(60, 10, 3, 10));
		oppField.setHgap(5);
		oppField.setPrefSize(game.getWidth() * 78 / 100, game.getHeight() * 30 / 100);
		oppField.setOnMouseClicked(e -> {
			if (actionInatiator != null) {
				selectedField = e.getSource();
				process();
			}
		});

		center.setBottom(currField);
		center.setTop(oppField);

		root.setCenter(center);
		root.setTop(top);
		root.setRight(right);
		root.setLeft(left);
		root.setBottom(bottom);

		game.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

		view.setScene(game);
		view.show();
	}

	private void display(String message) {
		new ErrorBox(message);

	}

	private void update() {
		System.out.println("u");

		currHand = null;
		currHand = new GridPane();
		currHand.setPadding(new Insets(20, 20, 5, 20));
		currHand.setHgap(7);
		for (int i = 0; i < model.getCurrentHero().getHand().size(); i++) {
			CardPane x = new CardPane(model.getCurrentHero().getHand().get(i), this, currHand);
			currHand.add(x, i, 0);
			x.setOnMouseEntered(e -> {

				x.setScaleX(1.12);
				x.setScaleY(1.12);
				if (e.getSource() == actionInatiator)
					x.setStyle("-fx-border-color: yellow");
				else
					x.setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
			});
			x.setOnMouseExited(e -> {
				if (!(e.getSource() == actionInatiator)) {
					x.setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
					x.setStyle("-fx-border-color: null");
					x.setScaleX(1);
					x.setScaleY(1);
				}
			});
		}

		currField = new GridPane();
		currField.setPadding(new Insets(60, 10, 3, 10));
		currField.setHgap(5);
		currField.setPrefSize(game.getWidth() * 78 / 100, game.getHeight() * 30 / 100);
		currField.setOnMouseClicked(e -> {
			if (actionInatiator != null) {
				selectedField = e.getSource();
				process();
			}
		});
		for (int i = 0; i < model.getCurrentHero().getField().size(); i++) {
			CardPane x = new CardPane(model.getCurrentHero().getField().get(i), this, currField);
			currHand.add(x, i, 0);
			x.setOnMouseEntered(e -> {

				x.setScaleX(1.12);
				x.setScaleY(1.12);
				if (e.getSource() == actionInatiator)
					x.setStyle("-fx-border-color: yellow");
				else
					x.setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
			});
			x.setOnMouseExited(e -> {
				if (!(e.getSource() == actionInatiator)) {
					x.setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
					x.setStyle("-fx-border-color: null");
					x.setScaleX(1);
					x.setScaleY(1);
				}
			});
		}
		currField.setStyle("-fx-border-color: white");
		center.setBottom(currField);

	}

	private void callActions() {
		if (actionInatiator == oppField) {

			display("Cant play from the enemy's field");
			return;
		}
		try {
			if (selected != null && actionInatiator == null) {

				selected.getHero().useHeroPower();

			} else if (actionInatiator.getCard() instanceof Spell) {

				if ((actionInatiator.getCard() instanceof AOESpell)) {
					((AOESpell) actionInatiator.getCard()).performAction(model.getOpponent().getField(),
							model.getCurrentHero().getField());
					return;
				}
				if ((actionInatiator.getCard() instanceof FieldSpell)) {
					((FieldSpell) actionInatiator.getCard())
							.performAction(selectedField == currField ? model.getCurrentHero().getField()
									: model.getOpponent().getField());
					return;
				}
				if ((actionInatiator.getCard() instanceof HeroTargetSpell)) {
					((HeroTargetSpell) actionInatiator.getCard()).performAction(selected.getHero());
					return;
				}
				if ((actionInatiator.getCard() instanceof MinionTargetSpell)) {
					((MinionTargetSpell) actionInatiator.getCard()).performAction((Minion) actionInatiated.getCard());
					return;
				}
				if ((actionInatiator.getCard() instanceof LeechingSpell)) {
					((LeechingSpell) actionInatiator.getCard()).performAction((Minion) actionInatiated.getCard());
					return;
				}

			} else if (actionInatiator.getCard() instanceof Minion) {

				if (selected != null) {
					((Minion) actionInatiator.getCard()).attack(selected.getHero());
					return;
				}
				if (actionInatiated != null) {
					((Minion) actionInatiator.getCard()).attack(((Minion) actionInatiated.getCard()));
					return;
				}
				if (selectedField != null && selectedField == currField) {
					model.getCurrentHero().playMinion(((Minion) actionInatiator.getCard()));
					return;
				} else if (selectedField != null && selectedField != currField)
					display("Cant play minion into enemy field");
			}
		} catch (Exception e) {
			display(e.getMessage());
		}

	}

	public void process() {
		System.out.println(selectedField);

		callActions();
		selected = null;
		selectedField = null;
		actionInatiator.setStyle("-fx-border-color: null");
		actionInatiator = null;
		actionInatiated = null;
		update();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public CardPane getActionInatiator() {
		return actionInatiator;
	}

	public void setActionInatiator(CardPane actionInatiator) {
		this.actionInatiator = actionInatiator;
	}

	public CardPane getActionInatiated() {
		return actionInatiated;
	}

	public void setActionInatiated(CardPane actionInatiated) {
		this.actionInatiated = actionInatiated;
	}

	public HeroPane getSelected() {
		return selected;
	}

	public void setSelected(HeroPane selected) {
		this.selected = selected;
	}

	public BorderPane getRoot() {
		return root;
	}

	public Stage getView() {
		return view;
	}

	public Scene getGame() {
		return game;
	}

	public Scene getMenu() {
		return menu;
	}

	public Scene getGameover() {
		return gameover;
	}

	public BorderPane getLeft() {
		return left;
	}

	public BorderPane getRight() {
		return right;
	}

	public BorderPane getTop() {
		return top;
	}

	public BorderPane getBottom() {
		return bottom;
	}

	public BorderPane getCenter() {
		return center;
	}

	public GridPane getCurrHand() {
		return currHand;
	}

}