package engine;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import exceptions.FullHandException;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
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

	public void update() {
//		for (Minion m : game.getCurrentHero().getHand()) {
//			view.getCurrHand().add(new JButton());
//			view.getCurrHand().add(new CardPanel(m));
//
//		}
		view.getField().getCurrField()
				.add(new CardPanel(new Minion("lol", 2, Rarity.RARE, 3, 10, false, true, true), this));
		for (Minion m : game.getCurrentHero().getField()) {

			view.getField().getCurrField().add(new CardPanel(m, this));
		}

		for (int i = 0; i < 5; i++) {
			view.getField().getOppField().add(new JButton());
		}

		view.revalidate();
		view.repaint();
	}

	public void onGameOver() {

	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) (e.getSource());
		System.out.println(b.getText());
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "dafuck.", "Inane error", JOptionPane.ERROR_MESSAGE);
		view.revalidate();
		view.repaint();
	}

	public static void main(String[] args) throws IOException, CloneNotSupportedException, FullHandException {

		new Updater(new Warlock(), new Paladin());

	}// main for testing - Program main will be in a different file

}