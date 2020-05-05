package engine;

import java.awt.Rectangle;

import com.sun.org.apache.xerces.internal.dom.ChildNode;

import javafx.scene.Scene;
import javafx.scene.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;
import sun.awt.image.PixelConverter.Bgrx;

public class HeroPane extends GridPane {
	private Hero hero;
	private TextField name;
	private TextField mana;
	private TextField hp;
	private TextField heropower;

	public TextField getName() {
		return name;
	}

	public TextField getHeropower() {
		return heropower;
	}

	public TextField getMana() {
		return mana;
	}

	public void setMana(TextField mana) {
		this.mana = mana;
	}

	public TextField getHp() {
		return hp;
	}

	public void setHp(TextField hp) {
		this.hp = hp;
	}

//	public HeroPane(Hero h, Main m, GridPane b) {// create the pane, add the name and manacost, set the action handler
//													// (similar}
//		// to the one in card pane) and set the effects
//		basic = b;
//		hero = h;
//		setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
//		setPrefHeight(basic.getHeight());
//		name = new TextField(h.getName());
//		name.setFont(new Font("arial", 17));
//		name.setDisable(true);
//		switch (h.getName().charAt(0)) {
//		case 'R':
//			name.setStyle("-fx-border-color:  red");
//			break;
//		case 'U':
//			name.setStyle("-fx-border-color:  green");
//			break;
//		case 'J':
//			name.setStyle("-fx-border-color:  purple");
//			break;
//		case 'A':
//			name.setStyle("-fx-border-color:  gold");
//		case 'G':
//			name.setStyle("-fx-border-color:  white");
//			break;
//		}
//		this.add(name, 2, 0, 3, 1);
//		mana = new TextField("manacrystal" + 30 + "/" + h.getCurrentManaCrystals());
//		mana.setVisible(true);
//		mana.setStyle("-fx-text-fill: darkcyan");
//		add(mana, 5, 0);
//		hp = new TextField(h.getCurrentHP() + "");
//		hp.setVisible(true);
//		add(hp, 5, 1);
//		heropower = new TextField("");
//		switch (h.getName().charAt(0)) {
//		case 'R':
//			heropower.setText("inflict 2 point damage on oppnents hero");
//			break;
//		case 'U':
//			heropower.setText("creat new Silver Hand Recruit");
//			break;
//		case 'J':
//			heropower.setText("Inflict one damage point to a specific target(hero or minion)");
//			break;
//		case 'A':
//			      heropower.setText("Restore two health points to a specific target (a hero or a minion)");
//		case 'G':
//			heropower.setText("Draw an extra card and inflict two damage points to the hero");
//			break;
//		}
//	add(heropower,3,1,3,2);}

	public HeroPane(Hero h, Main m) {
		hero = h;
		setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		setPrefHeight((int)(m.getLeft().getHeight()/2));
		name = new TextField(h.getName());
		name.setFont(new Font("arial", 17));
		name.setDisable(true);
		switch (h.getName().charAt(0)) {
		case 'R':
			name.setStyle("-fx-border-color:  red");
			break;
		case 'U':
			name.setStyle("-fx-border-color:  green");
			break;
		case 'J':
			name.setStyle("-fx-border-color:  purple");
			break;
		case 'A':
			name.setStyle("-fx-border-color:  gold");
		case 'G':
			name.setStyle("-fx-border-color:  white");
			break;
		}
		this.add(name, 2, 0, 3, 1);
		mana = new TextField("manacrystal" + 30 + "/" + h.getCurrentManaCrystals());
		mana.setVisible(true);
		mana.setStyle("-fx-text-fill: darkcyan");
		add(mana, 5, 0);
		hp = new TextField(h.getCurrentHP() + "");
		hp.setVisible(true);
		add(hp, 5, 1);
		heropower = new TextField("");
		switch (h.getName().charAt(0)) {
		case 'R':
			heropower.setText("inflict 2 point damage on oppnents hero");
			break;
		case 'U':
			heropower.setText("creat new Silver Hand Recruit");
			break;
		case 'J':
			heropower.setText("Inflict one damage point to a specific target(hero or minion)");
			break;
		case 'A':
			      heropower.setText("Restore two health points to a specific target (a hero or a minion)");
		case 'G':
			heropower.setText("Draw an extra card and inflict two damage points to the hero");
			break;
		}
	add(heropower,3,1,3,2);}

	public Hero getHero() {
		return hero;
	}

	public static void main(String[] args) {
//	HeroPane j=new HeroPane(new Hunter()); 
//JFrame j =new JFrame();
//j.setVisible(true);
//j.setBackground(java.awt.Color.BLACK);
//j.setBounds(0, 0, 200, 200);
//}

	}
}
