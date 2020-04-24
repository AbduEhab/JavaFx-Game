package engine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Main extends Application implements EventHandler<ActionEvent> {

	private Card actionInatiator;
	private Card actionInatiated;
	private Hero selected;

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
	private BorderPane currHand;

	public void start(Stage primaryStage) {
		view = primaryStage;

		root = new BorderPane();

		game = new Scene(root, 1280, 720);

		BorderPane left = new BorderPane();
		left.setPrefSize(game.getWidth() * 20 / 100, game.getHeight() * 60 / 100);

		BorderPane right = new BorderPane();
		right.setPrefSize(game.getWidth() * 20 / 100, game.getHeight() * 60 / 100);

		BorderPane top = new BorderPane();
		top.setPrefSize(game.getWidth() * 60 / 100, game.getHeight() * 20 / 100);

		BorderPane bottom = new BorderPane();
		bottom.setPrefSize(game.getWidth() * 60 / 100, game.getHeight() * 20 / 100);

		GridPane currHand = new GridPane();
		currHand.setPrefSize(bottom.getWidth() * 10 / 100, bottom.getHeight() * 90 / 100);
		bottom.setCenter(currHand);
		currHand.add(new CardPane(new Minion("lol", 3, null, 21, 20, true, true, false), this), 0, 0);

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

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button) event.getTarget();
		b.setText("ada");

	}

	public BorderPane getRoot() {
		return root;
	}

	public Card getActionInatiator() {
		return actionInatiator;
	}

	public void setActionInatiator(Card actionInatiator) {
		this.actionInatiator = actionInatiator;
	}

	public Card getActionInatiated() {
		return actionInatiated;
	}

	public void setActionInatiated(Card actionInatiated) {
		this.actionInatiated = actionInatiated;
	}

	public Hero getSelected() {
		return selected;
	}

	public void setSelected(Hero selected) {
		this.selected = selected;
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

	public BorderPane getCurrHand() {
		return currHand;
	}

}