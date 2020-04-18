package engine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer extends JFrame {

	private JPanel left;
	private JPanel right;
	private JPanel top;
	private JPanel bottom;
	private JPanel center;

	private JPanel currField;
	private JPanel oppField;
	private JPanel currHand;
	private JPanel currMana;
	private JPanel currHero;
	private JPanel centerLeft;
	private JPanel centerRight;
	private JPanel oppHand;;
	private JPanel oppMana;
	private JPanel oppHero;
	private JPanel currCanterRightEdge;
	private JPanel currCenterLeftEdge;
	private JPanel currCenterTopEdge;
	private JPanel currDeck;
	private JPanel oppDeck;

	public Renderer() {

		this.setTitle("Current Game");
		this.setBounds(200, 200, 1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		left = new JPanel();
		right = new JPanel();
		top = new JPanel();
		bottom = new JPanel();
		center = new JPanel();
		currField = new JPanel();
		oppField = new JPanel();
		currHand = new JPanel();
		currMana = new JPanel();
		currHero = new JPanel();
		centerLeft = new JPanel();
		centerRight = new JPanel();
		oppHand = new JPanel();
		oppMana = new JPanel();
		oppHero = new JPanel();
		currCanterRightEdge = new JPanel();
		currCenterLeftEdge = new JPanel();
		currDeck = new JPanel();
		oppDeck = new JPanel();
		currCenterTopEdge = new JPanel();

		add(left, BorderLayout.WEST);
		left.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));

		add(right, BorderLayout.EAST);
		right.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));

		add(top, BorderLayout.NORTH);
		top.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 15 / 100));

		add(bottom, BorderLayout.SOUTH);
		bottom.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 15 / 100));

		add(center, BorderLayout.CENTER);
		center.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 70 / 100));

		center.add(currField, BorderLayout.SOUTH);
		currField.setLayout(new GridLayout(1, 0));
		currField.setPreferredSize(new Dimension(center.getWidth(), center.getHeight() / 2));

		center.add(oppField, BorderLayout.NORTH);
		oppField.setLayout(new GridLayout(1, 0));
		center.setPreferredSize(new Dimension(center.getWidth(), center.getHeight() / 2));

		left.add(oppHero, BorderLayout.NORTH);
		oppHero.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, top.getHeight()));

		left.add(currHero, BorderLayout.SOUTH);
		currHero.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, bottom.getHeight()));

		left.add(centerLeft, BorderLayout.CENTER);
		centerLeft.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, center.getHeight()));

		right.add(oppMana, BorderLayout.NORTH);
		oppMana.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, top.getHeight()));

		right.add(currMana, BorderLayout.SOUTH);
		currMana.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, bottom.getHeight()));

		right.add(centerRight, BorderLayout.CENTER);
		centerRight.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, center.getHeight()));

//		top.add(oppDeck);
//		oppDeck.setPreferredSize(new Dimension(top.getWidth(), top.getHeight()));

		bottom.add(currHand, BorderLayout.CENTER);
		currHand.setLayout(new GridLayout(1, 0));
		currHand.setPreferredSize(new Dimension(this.getWidth() * 60 / 100, this.getHeight() * 10 / 100));

		bottom.add(currCenterTopEdge, BorderLayout.NORTH);
		currCenterTopEdge.setPreferredSize(new Dimension(this.getWidth() * 50 / 100, this.getHeight() * 5 / 100));

		bottom.add(currCanterRightEdge, BorderLayout.EAST);
		currCanterRightEdge.setPreferredSize(new Dimension(bottom.getWidth(), bottom.getHeight()));

		bottom.add(currCenterLeftEdge, BorderLayout.WEST);
		currCenterLeftEdge.setPreferredSize(new Dimension(bottom.getWidth(), bottom.getHeight()));

		
		setVisible(true);

	}

	public JPanel getLeft() {
		return left;
	}

	public JPanel getRight() {
		return right;
	}

	public JPanel getTop() {
		return top;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public JPanel getCenter() {
		return center;
	}

	public JPanel getCurrField() {
		return currField;
	}

	public JPanel getOppField() {
		return oppField;
	}

	public JPanel getCurrhand() {
		return currHand;
	}

	public JPanel getCurrSideMana() {
		return currMana;
	}

	public JPanel getCurrSideHero() {
		return currHero;
	}

	public JPanel getCenterLeft() {
		return centerLeft;
	}

	public JPanel getCenterRight() {
		return centerRight;
	}

	public JPanel getOppHand() {
		return oppHand;
	}

	public JPanel getOppSideMana() {
		return oppMana;
	}

	public JPanel getOppSideHero() {
		return oppHero;
	}

	public JPanel getCurrSideRightEdge() {
		return currCanterRightEdge;
	}

	public JPanel getCurrSideLeftEdge() {
		return currCenterLeftEdge;
	}

	public JPanel getCurrSideTopEdge() {
		return currCenterTopEdge;
	}

	public JPanel getCurrDeck() {
		return currDeck;
	}

	public JPanel getOppDeck() {
		return oppDeck;
	}

}
