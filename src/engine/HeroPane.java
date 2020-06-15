package engine;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.heroes.Hero;

public class HeroPane extends GridPane {
	private Hero hero;
	private TextField name;
	private TextField mana;
	private TextField hp;

	public HeroPane(Hero h, Main m) {
		hero = h;

		if (h.isHeroPowerUsed())
			setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		setPadding(new Insets(5, 5, 5, 5));
		setVgap(5);
		setHgap(5);

		name = new TextField(h.getName());
		name.setFont(new Font("Comic Sans MS", 16));
		name.setDisable(true);
		add(name, 0, 0, 4, 1);

		mana = new TextField(h.getCurrentManaCrystals() + "");
		mana.setDisable(true);
		mana.setStyle("-fx-text-fill: darkcyan");
		add(mana, 0, 1);

		hp = new TextField(h.getCurrentHP() + "");
		hp.setDisable(true);
		if (30 / 2 <= h.getCurrentHP()) {
			hp.setStyle("-fx-border-color: green");
		} else if (30 / 4 <= h.getCurrentHP()) {
			hp.setStyle("-fx-border-color: yellow");
		} else
			hp.setStyle("-fx-border-color: red");
		add(hp, 0, 2);

		setOnMouseEntered(e -> {
			setScaleX(1.12);
			setScaleY(1.12);
			if (e.getSource() == m.getSelector())
				setStyle("-fx-border-color: yellow");
			else
				setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
		});
		setOnMouseExited(e -> {
			if (!(e.getSource() == m.getSelector())) {
				setStyle("-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0)");
				setStyle("-fx-border-color: null");
				setScaleX(1);
				setScaleY(1);
			}
		});

		setOnMouseClicked(e -> {
			if (m.getSelector() == null && m.getActionInatiator() == null) {
				m.setSelector(this);
				setScaleX(1.12);
				setScaleY(1.12);
				setStyle("-fx-border-color: yellow");
			} else if (m.getSelector() == this) {
				m.setSelector(null);
				setScaleX(1);
				setScaleY(1);
				setStyle("-fx-border-color: null");
			} else if (m.getActionInatiator() != null || m.getSelector() != null) {
				m.setSelected(this);
				m.process();
			}
		});

	}

	public TextField getName() {
		return name;
	}

	public TextField getMana() {
		return mana;
	}

	public TextField getHp() {
		return hp;
	}

	public Hero getHero() {
		return hero;
	}

}
