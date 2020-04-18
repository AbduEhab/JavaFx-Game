package engine;

import java.awt.BorderLayout;
import java.awt.Color;
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

	private JPanel fieldSplit;
	private JPanel currField;
	private JPanel currFieldTopGap;
	private JPanel currFieldBottomGap;
	private JPanel oppField;
	private JPanel oppFieldTopGap;
	private JPanel oppFieldBottomGap;
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

		setTitle("Current Game");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		left = new JPanel();
		right = new JPanel();
		top = new JPanel();
		bottom = new JPanel();
		center = new JPanel();
		fieldSplit = new JPanel();
		currFieldTopGap = new JPanel();
		currFieldBottomGap = new JPanel();
		oppFieldTopGap = new JPanel();
		oppFieldBottomGap = new JPanel();
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

		left.setLayout(new BorderLayout());
		center.setLayout(new BorderLayout());
		right.setLayout(new BorderLayout());
		top.setLayout(new BorderLayout());
		bottom.setLayout(new BorderLayout());

		add(left, BorderLayout.WEST);
		left.setPreferredSize(new Dimension(this.getWidth() * 15 / 100, this.getHeight()));

		add(right, BorderLayout.EAST);
		right.setPreferredSize(new Dimension(this.getWidth() * 15 / 100, this.getHeight()));

		add(top, BorderLayout.NORTH);
		top.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 15 / 100));

		add(bottom, BorderLayout.SOUTH);
		bottom.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 15 / 100));

		add(center, BorderLayout.CENTER);
		center.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 70 / 100));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		center.add(currField, BorderLayout.SOUTH);
		;
		currField.setBackground(Color.yellow);
		currField.setLayout(new GridLayout(1, 0));
		currField.setPreferredSize(new Dimension(center.getWidth(), center.getHeight() / 3));

		center.add(fieldSplit, BorderLayout.CENTER);
		oppField.setBackground(Color.green);
		center.setPreferredSize(new Dimension(center.getWidth(), center.getHeight() / 3));

		center.add(oppField, BorderLayout.NORTH);
		oppField.setBackground(Color.magenta);
		oppField.setLayout(new GridLayout(1, 0));
		center.setPreferredSize(new Dimension(center.getWidth(), center.getHeight() / 3));
//////////////////////////////////////////////////////////////////////////////////////////////////////
		left.add(oppHero, BorderLayout.NORTH);
		oppHero.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, top.getHeight()));

		left.add(currHero, BorderLayout.SOUTH);
		currHero.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, bottom.getHeight()));

		left.add(centerLeft, BorderLayout.CENTER);
		centerLeft.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, center.getHeight()));
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		right.add(oppMana, BorderLayout.NORTH);
		oppMana.setBackground(Color.orange);
		oppMana.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, top.getHeight()));

		right.add(currMana, BorderLayout.SOUTH);
		currMana.setBackground(Color.orange);
		currMana.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, bottom.getHeight()));

		right.add(centerRight, BorderLayout.CENTER);
		centerRight.setBackground(Color.pink);
		centerRight.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, center.getHeight()));
///////////////////////////////////////////////////////////////////////////////////////////////////////////
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
