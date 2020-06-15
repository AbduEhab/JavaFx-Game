package engine;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorBox {

	public ErrorBox(String s) {
		Stage w = new Stage();
		w.setTitle("Error");
		w.initModality(Modality.APPLICATION_MODAL);

		Label l = new Label("- " + s + " -");
		Button b = new Button("Ok");
		b.setOnAction(e -> w.close());

		VBox v = new VBox(15);
		v.getChildren().addAll(l, b);
		v.setAlignment(Pos.CENTER);

		Scene sc = new Scene(v, 300, 150);
		w.setScene(sc);
		w.showAndWait();
	}
}
