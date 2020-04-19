package engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.cards.Card;
import model.cards.minions.Minion;

public class CardPanel extends JPanel {

	private JPanel top;
	private JButton selector;
	private JTextArea cardName;
	private JTextArea manaCost;

	private int height = 720 * 10 / 100;
	private int width = (1280 - (1280 * 40 / 100)) * 10 / 100;

	public CardPanel(Card m, Updater u) {

		cardName = new JTextArea();
		manaCost = new JTextArea();
		selector = new JButton();
		top = new JPanel();

		setBackground(Color.cyan);

		this.setPreferredSize(new Dimension(width, height));

		this.add(top, BorderLayout.NORTH);
		top.setSize(new Dimension(width, height * 20 / 100));

		this.add(selector, BorderLayout.CENTER);
		selector.setSize(new Dimension(width, height * 70 / 100));
//		selector.setIcon(new ImageIcon("images/2.JPG"));
		selector.addActionListener(u);

		top.add(cardName, BorderLayout.WEST);
		cardName.setEditable(false);
		cardName.setText(m.getName());
		cardName.setSize(new Dimension(width * 80 / 100, top.getHeight()));

		top.add(manaCost, BorderLayout.EAST);
		manaCost.setEditable(false);
		manaCost.setText(m.getManaCost() + "");
		manaCost.setSize(new Dimension(width * 20 / 100, top.getHeight()));

	}

	public JPanel getCard() {
		return this;
	}

	public JPanel getTop() {
		return top;
	}

	public JButton getSelector() {
		return selector;
	}

	public JTextArea getCardName() {
		return cardName;
	}

	public JTextArea getManaCost() {
		return manaCost;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
