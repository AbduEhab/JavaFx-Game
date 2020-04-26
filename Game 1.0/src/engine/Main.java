package engine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Main extends Application implements EventHandler<ActionEvent> {

	private CardPane actionInatiator;
	private CardPane actionInatiated;
	private HeroPane selected;
	private Object selectedField;

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

	public void start(Stage primaryStage) {
		view = primaryStage;

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
		currHand.setPrefSize(game.getWidth(), bottom.getHeight() * 90 / 100);
		currHand.setPadding(new Insets(20, 20, 5, 20));
		currHand.setHgap(7);
		for (int i = 0; i < 10; i++) {
			CardPane x = new CardPane(new Minion("lol", 3, Rarity.RARE, 21, 20, true, true, false), this, currHand);
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
		currField.setOnMouseDragEntered(e->System.out.println('q'));
		currField.setStyle("-fx-background-color: white");

		oppField = new GridPane();
		oppField.setPadding(new Insets(60, 10, 3, 10));
		oppField.setHgap(5);
		oppField.setPrefSize(game.getWidth() * 78 / 100, game.getHeight() * 30 / 100);

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

	public static void main(String[] args) {
		launch(args);
	}

	public void process() {
		if (actionInatiator.getCard() instanceof Minion) {

		}

	}

	public void handle(ActionEvent event) {
		Button b = (Button) event.getTarget();
		b.setText("ada");

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