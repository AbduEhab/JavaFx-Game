package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import exceptions.FullHandException;
import model.cards.Card;
import model.heroes.Hero;
import model.heroes.Paladin;
import model.heroes.Warlock;

public class Updater implements GameListener, ActionListener {

	Game game;
	Renderer view;

	public Updater(Hero p1, Hero p2) throws FullHandException, CloneNotSupportedException {
		view = new Renderer();
		game = new Game(p2, p1);
		game.setListener(this);
		update();
	}

	public void update() {	//
		for (Card m : game.getCurrentHero().getHand()) {
			view.getCurrhand().add(new JButton());
//			view.getCurrhand().add(new CardPanel(m));

		}
		for (Card m : game.getCurrentHero().getHand()) {
			view.getCurrField().add(new JButton());
		}
		
		for (Card m : game.getOpponent().getHand()) {
			view.getOppField().add(new JButton());
		}
		
		view.revalidate();
		view.repaint();
	}

	public void onGameOver() {

	}

	public void actionPerformed(ActionEvent e) {

		update();
	}

	public static void main(String[] args) throws IOException, CloneNotSupportedException, FullHandException {

		new Updater(new Warlock(), new Paladin());

	}// main for testing - Program main will be in a different file

}