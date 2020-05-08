package engine;

import exceptions.FullHandException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DeckPane extends BorderPane {

	public DeckPane(Main main, int i) {

		setPadding(new Insets(6, 4, 6, 4));

		BorderPane deck = new BorderPane();

		Text opptext = new Text(i + "");
		opptext.setDisable(true);
		opptext.setFont(new Font("Comic Sans MS", 19));

		deck.setCenter(opptext);
		deck.setPrefHeight(main.getGame().getHeight() * 28 / 100);
		deck.setStyle("-fx-background-color: darkgrey");

		setTop(deck);

	}

}
