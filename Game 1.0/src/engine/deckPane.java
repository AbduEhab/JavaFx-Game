package engine;

import java.awt.Button;

import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.heroes.*;
public class deckPane extends GridPane{
private Hero cuur;
private Hero opp;
private TextField curd;
private TextField opd;
private Button b;
private Main m;
public deckPane(Hero c,Hero o, Main n) {
	m=n;
	cuur=c;
	opp=o;
	b=new Button("End turn");
	b.setBackground(java.awt.Color.MAGENTA);
//	b.setEventDispatcher(value);
	curd=new TextField("20");
	opd=new TextField("20");
	setPrefHeight((m.getRight().getHeight())/2);
	this.getChildren().add(b,0,2,1,1);
	this.add(curd, 0, 1,1,1);
	this.add(opd, 0, 3,1,1);
	curd.setDisable(true);
	opd.setDisable(true);
	this.setVisible(true);
}
public TextField getCurd() {
	return curd;
}
public void setCurd(TextField curd) {
	this.curd = curd;
}
public TextField getOpd() {
	return opd;
}
public void setOpd(TextField opd) {
	this.opd = opd;
}
public Hero getCuur() {
	return cuur;
}
public void setCuur(Hero cuur) {
	this.cuur = cuur;
}
public Hero getOpp() {
	return opp;
}
public void setOpp(Hero opp) {
	this.opp = opp;
}

public Main getM() {
	return m;
}
public void setcurd(int x) {if (x<=0) curd.setText("0");
else if(x>=20)curd.setText("20");
else curd.setText(x+"");}
public void setopd(int x) {if (x<=0) opd.setText("0");
else if(x>=20)opd.setText("20");
else opd.setText(x+"");}
}
