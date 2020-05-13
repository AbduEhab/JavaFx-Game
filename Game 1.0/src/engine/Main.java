package engine;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Main extends Application implements GameListener {

	private CardPane actionInatiator;
	private CardPane actionInatiated;
	private HeroPane selector;
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

		model = new Game(new Warlock(), new Mage());
		model.setListener(this);

		root = new BorderPane();

		game = new Scene(root, 1280, 720);

		left = new BorderPane();
		left.setPrefSize(game.getWidth() * 15 / 100, game.getHeight() * 60 / 100);
		left.setTop(new HeroPane(model.getOpponent(), this));
		left.setBottom(new HeroPane(model.getCurrentHero(), this));
		left.setStyle("-fx-border-color: blue");
		left.setPadding(new Insets(13, 5, 13, 5));

		right = new BorderPane();
		right.setPrefSize(game.getWidth() * 10 / 100, game.getHeight() * 60 / 100);
		Button endTurn = new Button("End Turn");
		endTurn.setPrefWidth(getGame().getWidth() * 10 / 100 - 10);
		endTurn.setOnMouseClicked(e -> {
			try {
				model.endTurn();
			} catch (Exception e1) {
				display(e1.getMessage());
			}
		});
		right.setCenter(endTurn);
		right.setTop(new DeckPane(this, model.getOpponent().getDeck().size()));
		right.setBottom(new DeckPane(this, model.getCurrentHero().getDeck().size()));
		right.setStyle("-fx-border-color: red");

		top = new BorderPane();
		top.setPrefSize(game.getWidth() * 60 / 100, game.getHeight() * 20 / 100);
		top.setStyle("-fx-border-color: yellow");

		bottom = new BorderPane();
		bottom.setPrefSize(game.getWidth() * 60 / 100, game.getHeight() * 20 / 100);

		currHand = new GridPane();

		currHand.setPadding(new Insets(20, 20, 20, 20));
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
		center.setPrefSize(game.getWidth() * 75 / 100, game.getHeight() * 60 / 100);

		currField = new GridPane();
		currField.setPadding(new Insets(30, 10, 20, 10));
		currField.setHgap(5);
		currField.setPrefSize(game.getWidth() * 78 / 100, game.getHeight() * 30 / 100);
		currField.setOnMouseClicked(e -> {
			if (selector != null || actionInatiator != null
					&& !model.getCurrentHero().getField().contains(actionInatiator.getCard())) {
				selectedField = e.getSource();
				process();
			}
		});
		currField.setStyle("-fx-border-color: white");

		oppField = new GridPane();
		oppField.setPadding(new Insets(20, 10, 30, 10));
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

	public void display(String message) {

		new ErrorBox(message);

	}

	public static void clear(GridPane g) {

		g.getChildren().clear();
//		TimeUnit.SECONDS.sleep(1l);

//		while (!g.getChildren().isEmpty()) {
//
//			g.getChildren().remove(0);
//
//		}

	}

	public static void clear(BorderPane g) {

		g.getChildren().clear();
//		TimeUnit.SECONDS.sleep(1l);

//		while (!g.getChildren().isEmpty()) {
//
//			g.getChildren().remove(0);
//
//		}

	}

	public void update() {

		selector = null;
		selectedField = null;
		selected = null;
		actionInatiator = null;
		actionInatiated = null;

		clear(currHand);
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

		clear(currField);

		for (int i = 0; i < model.getCurrentHero().getField().size(); i++) {
			CardPane x = new CardPane(model.getCurrentHero().getField().get(i), this, currField);
			currField.add(x, i, 0);
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

		clear(oppField);

		for (int i = 0; i < model.getOpponent().getField().size(); i++) {
			CardPane x = new CardPane(model.getOpponent().getField().get(i), this, oppField);
			oppField.add(x, i, 0);
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
		left.setTop(new HeroPane(model.getOpponent(), this));
		left.setBottom(new HeroPane(model.getCurrentHero(), this));

		clear(right);
		Button endTurn = new Button("End Turn");
		endTurn.setPrefWidth(getGame().getWidth() * 10 / 100 - 10);
		endTurn.setOnMouseClicked(e -> {
			try {
				model.endTurn();
			} catch (Exception e1) {
				display(e1.getMessage());
			}
		});
		right.setCenter(endTurn);
		right.setTop(new DeckPane(this, model.getOpponent().getDeck().size()));
		right.setBottom(new DeckPane(this, model.getCurrentHero().getDeck().size()));

	}

	private Minion toMinion(Card c) {
		return (Minion) c;
	}

	private void callActions() {
		try {

			if (selector != null) {
				if (selected != null) {
					if (selector.getHero() instanceof Hunter || selector.getHero() instanceof Warlock
							|| selector.getHero() instanceof Paladin) {
						selector.getHero().useHeroPower();
						return;
					}
					if (selector.getHero() instanceof Mage || selector.getHero() instanceof Priest) {

						((Mage) selector.getHero()).useHeroPower(selected.getHero());
						return;

					}
					return;
				} else {
					if (actionInatiated.getCard() instanceof Minion) {
						if (selector.getHero() instanceof Mage) {
							if (model.getOpponent().getField().contains(actionInatiated.getCard())) {
								((Mage) selector.getHero()).useHeroPower((Minion) actionInatiated.getCard());
								return;
							}
						} else if (selector.getHero() instanceof Priest) {
							((Priest) selector.getHero()).useHeroPower((Minion) actionInatiated.getCard());
							display("Canot attack friendly minion");
							return;
						} else
							display("Cant attack minion with this card");
					} else
						display("Cant attack This Target");

				}
			}
			//////////////////////////////////////////////////////////////////
			if (actionInatiator != null) {

				if (actionInatiator.getCard() instanceof Spell) {

					if (selected != null) {

						if (!(actionInatiator.getCard() instanceof HeroTargetSpell)) {
							display("You can't attack a Hero with this spell");
							return;
						}
						if (selected.getHero() == model.getCurrentHero()) {
							display("You can't play spell on your own hero your own hero");
							return;
						}
						model.getCurrentHero().castSpell((HeroTargetSpell) actionInatiator.getCard(),
								selected.getHero());
						return;

					}
					if (selectedField != null) {
						if ((actionInatiator.getCard() instanceof AOESpell)) {

							model.getCurrentHero().castSpell((AOESpell) actionInatiator.getCard(),
									model.getOpponent().getField());
							return;
						}

						if ((actionInatiator.getCard() instanceof FieldSpell)) {

							model.getCurrentHero().castSpell((FieldSpell) actionInatiator.getCard());
							return;
						}

					}
					if ((model.getCurrentHero().getField().contains(actionInatiated.getCard())
							|| model.getCurrentHero().getHand().contains(actionInatiated.getCard()))) {
						display("Cant play spell on friendly minion cards");
						return;

					}
					if ((actionInatiator.getCard() instanceof LeechingSpell)) {

						model.getCurrentHero().castSpell((LeechingSpell) actionInatiator.getCard(),
								(Minion) actionInatiated.getCard());
						return;
					}
					if ((actionInatiator.getCard() instanceof MinionTargetSpell)) {

						model.getCurrentHero().castSpell((MinionTargetSpell) actionInatiator.getCard(),
								(Minion) actionInatiated.getCard());
						return;
					}

					display("Spells should not be played on spells");
					return;
				}

				///////////////////////////////////////////////////////////////
				else {

					if (selected != null) {

						model.getCurrentHero().attackWithMinion(toMinion(actionInatiator.getCard()),
								selected.getHero());
						return;

					}
					if (selectedField != null) {
						if (selectedField == currField) {
							if (!model.getCurrentHero().getField().contains(actionInatiator.getCard())) {
								model.getCurrentHero().playMinion(toMinion(actionInatiator.getCard()));
								return;
							}
						} else {
							display("Cant play minion Here");
							return;
						}
					}
					if (!model.getCurrentHero().getField().contains(actionInatiated.getCard())) {

						model.getCurrentHero().attackWithMinion(toMinion(actionInatiator.getCard()),
								toMinion(actionInatiated.getCard()));
						return;

					}

					display("Can't attack your own minion");

				}

			}
		} catch (

		Exception e) {
			display(e.getMessage());
			e.printStackTrace();
		}
	}

	public void process() {

		if (actionInatiator != null) {
			actionInatiator.setScaleX(1);
			actionInatiator.setScaleY(1);
			actionInatiator.setStyle("-fx-border-color: null");
		}

		callActions();

		update();

	}

	public void onGameOver() {

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

	public HeroPane getSelector() {
		return selector;
	}

	public void setSelector(HeroPane selector) {
		this.selector = selector;
	}

	public HeroPane getSelected() {
		return selected;
	}

	public void setSelected(HeroPane selected) {
		this.selected = selected;
	}

	public Object getSelectedField() {
		return selectedField;
	}

	public void setSelectedField(Object selectedField) {
		this.selectedField = selectedField;
	}

	public Game getModel() {
		return model;
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

	public GridPane getCurrField() {
		return currField;
	}

	public GridPane getOppField() {
		return oppField;
	}
}