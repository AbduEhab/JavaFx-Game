package engine;

import java.io.IOException;

import exceptions.FullHandException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.cards.Card;
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
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

public class Main extends Application implements GameListener {

	private CardPane actionInatiator;
	private CardPane actionInatiated;
	private HeroPane selector;
	private HeroPane selected;
	private Object selectedField;

	private Game model;
	private Hero h1;

	private HBox hGrid;
	private VBox vGrid;

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

	public void start(Stage primaryStage)
			throws FullHandException, CloneNotSupportedException, IOException, InterruptedException {
		view = primaryStage;

		mainScreen();

		view.show();

	}

	public void mainScreen() {
		root = new BorderPane();
		root.setId("cardpane");

		hGrid = new HBox(70);
		vGrid = new VBox(20);

		Button b1 = new Button("Warlock");
		b1.setPrefSize(190, 500);
		b1.setId("warlock");
		b1.setOnMouseClicked(e -> {
			if (h1 == null) {
				try {
					h1 = new Warlock();
				} catch (IOException | CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				b1.setStyle("-fx-border-color: yellow");
			} else if (h1 instanceof Warlock) {
				h1 = null;
				b1.setStyle("-fx-border-color: null");
			} else
				try {

					newGame(h1, new Warlock());
				} catch (FullHandException | CloneNotSupportedException | IOException e1) {
					e1.printStackTrace();
				}
		});

		Button b2 = new Button("Priest");
		b2.setPrefSize(190, 500);
		b2.setId("priest");
		b2.setOnMouseClicked(e -> {
			if (h1 == null) {
				try {
					h1 = new Priest();
				} catch (IOException | CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				b2.setStyle("-fx-border-color: yellow");
			} else if (h1 instanceof Priest) {
				h1 = null;
				b2.setStyle("-fx-border-color: null");
			} else
				try {
					newGame(h1, new Priest());
				} catch (FullHandException | CloneNotSupportedException | IOException e1) {
					e1.printStackTrace();
				}
		});

		Button b3 = new Button("Hunter");
		b3.setId("hunter");
		b3.setPrefSize(190, 500);
		b3.setOnMouseClicked(e -> {
			if (h1 == null) {
				try {
					h1 = new Hunter();
				} catch (IOException | CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				b3.setStyle("-fx-border-color: yellow");
			} else if (h1 instanceof Hunter) {
				h1 = null;
				b3.setStyle("-fx-border-color: null");
			} else
				try {
					newGame(h1, new Hunter());
				} catch (FullHandException | CloneNotSupportedException | IOException e1) {
					e1.printStackTrace();
				}
		});

		Button b4 = new Button("Mage");
		b4.setPrefSize(190, 500);
		b4.setId("mage");
		b4.setOnMouseClicked(e -> {
			if (h1 == null) {
				try {
					h1 = new Mage();
				} catch (IOException | CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				b4.setStyle("-fx-border-color: yellow");
			} else if (h1 instanceof Mage) {
				h1 = null;
				b4.setStyle("-fx-border-color: null");
			} else
				try {
					newGame(h1, new Mage());
				} catch (FullHandException | CloneNotSupportedException | IOException e1) {
					e1.printStackTrace();
				}
		});

		Button b5 = new Button("Paladin");
		b5.setPrefSize(190, 500);
		b5.setId("paladin");
		b5.setOnMouseClicked(e -> {
			if (h1 == null) {
				try {
					h1 = new Paladin();
				} catch (IOException | CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				b5.setStyle("-fx-border-color: yellow");
			} else if (h1 instanceof Paladin) {
				h1 = null;
				b5.setStyle("-fx-border-color: null");
			} else
				try {
					newGame(h1, new Paladin());
				} catch (FullHandException | CloneNotSupportedException | IOException e1) {
					e1.printStackTrace();
				}
		});

		Text name = new Text("- HearthStone Demo -");
		name.setId("white");

		vGrid.getChildren().addAll(name, hGrid);
		vGrid.setPrefSize(1280, 720);
		vGrid.setAlignment(Pos.CENTER);

		hGrid.getChildren().addAll(b1, b2, b3, b4, b5);
		hGrid.setAlignment(Pos.CENTER);

		root.setCenter(vGrid);

		game = new Scene(root, 1280, 720);

		game.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

		view.setResizable(false);
		view.setScene(game);

	}

	public void newGame(Hero h1, Hero h2) throws FullHandException, CloneNotSupportedException, IOException {
//		try {
//			AudioClip ac = new AudioClip(this.getClass().getResource("Shuffle.mp3").toString());
//			ac.play();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		model = new Game(h1, h2);
		model.setListener(this);

		root = new BorderPane();
		root.setId("Loading");

		game = new Scene(root, 1280, 720);
		game.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

		view.setScene(game);

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
//				AudioClip ac1 = new AudioClip(this.getClass().getResource("Turn_end.mp3").toString());
//				ac1.play();
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

		root.setId("cardpane");

		game.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

		view.setScene(game);
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
//				AudioClip ac1 = new AudioClip(this.getClass().getResource("Turn_end.mp3").toString());
//				ac1.play();
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
						try {
//							AudioClip ac = new AudioClip(this.getClass().getResource("Hero_power.mp3").toString());
//							ac.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						return;
					}
					if (selector.getHero() instanceof Mage || selector.getHero() instanceof Priest) {
						try {
//							AudioClip ac = new AudioClip(this.getClass().getResource("Hero_power.mp3").toString());
//							ac.play();
							((Mage) selector.getHero()).useHeroPower(selected.getHero());
						} catch (Exception e) {
							e.printStackTrace();
						}
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
							try {
//								AudioClip ac = new AudioClip(this.getClass().getResource("Spell_play.mp3").toString());
//								ac.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
							return;
						}

						if ((actionInatiator.getCard() instanceof FieldSpell)) {

							model.getCurrentHero().castSpell((FieldSpell) actionInatiator.getCard());
							try {
//								AudioClip ac = new AudioClip(this.getClass().getResource("Spell_play.mp3").toString());
//								ac.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
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
						try {
//							AudioClip ac = new AudioClip(this.getClass().getResource("Spell_play.mp3").toString());
//							ac.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						return;
					}
					if ((actionInatiator.getCard() instanceof MinionTargetSpell)) {

						model.getCurrentHero().castSpell((MinionTargetSpell) actionInatiator.getCard(),
								(Minion) actionInatiated.getCard());
						try {
//							AudioClip ac = new AudioClip(this.getClass().getResource("Spell_play.mp3").toString());
//							ac.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
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
								try {
//									AudioClip ac = new AudioClip(
//											this.getClass().getResource("Card_play.mp3").toString());
//									ac.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
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
						try {
							AudioClip ac = new AudioClip(this.getClass().getResource("Minion_attack.mp3").toString());
							ac.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
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

		root = new BorderPane();
		root.setId("cardpane");

		hGrid = new HBox(70);
		vGrid = new VBox(20);

		Button b1 = new Button("Warlock");
		b1.setPrefSize(190, 500);
//		b1.setId("warlock");
		b1.setOnMouseClicked(e -> mainScreen());

		Button b2 = new Button("Priest");
		b2.setPrefSize(190, 500);
//		b2.setId("priest");
		b2.setOnMouseClicked(e -> view.close());

		Text name = new Text(model.getCurrentHero().getName() + " Wins");
		name.setId("white");

		vGrid.getChildren().addAll(name, hGrid);
		vGrid.setPrefSize(1280, 720);
		vGrid.setAlignment(Pos.CENTER);

		hGrid.getChildren().addAll(b1, b2);
		hGrid.setAlignment(Pos.CENTER);

		root.setCenter(vGrid);

		game = new Scene(root, 1280, 720);

		game.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

		view.setResizable(false);
		view.setScene(game);
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