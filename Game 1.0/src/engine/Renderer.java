package engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JFrame {

	private JPanel left;
	private JPanel right;
	private JPanel top;
	private JPanel bottom;
	private JPanel center;

	private FieldPlane field;

	private JPanel fieldSplit;
	private JPanel currFieldTopGap;
	private JPanel currFieldBottomGap;
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
		setSize(new Dimension(1280, 720));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);

		left = new JPanel();
		right = new JPanel();
		top = new JPanel();
		bottom = new JPanel();
		center = new JPanel();
		
		field = new FieldPlane();
		
		fieldSplit = new JPanel();
		currFieldTopGap = new JPanel();
		currFieldBottomGap = new JPanel();
		oppFieldTopGap = new JPanel();
		oppFieldBottomGap = new JPanel();
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

		add(top, BorderLayout.NORTH);
		top.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 20 / 100));
		top.setBackground(Color.blue);

		add(bottom, BorderLayout.SOUTH);
		bottom.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 20 / 100));
		bottom.setBackground(Color.red);

		add(center, BorderLayout.CENTER);
		center.setPreferredSize(new Dimension(this.getWidth() * 70 / 100, this.getHeight() * 60 / 100));

		add(left, BorderLayout.WEST);
		left.setPreferredSize(new Dimension(this.getWidth() * 15 / 100, center.getHeight()));
		left.setBackground(Color.orange);

		add(right, BorderLayout.EAST);
		right.setPreferredSize(new Dimension(this.getWidth() * 15 / 100, center.getHeight()));
		right.setBackground(Color.PINK);

/////////////////////////////////////////////////////////////////////////////////////////////////////////

		center.add(field, BorderLayout.CENTER);

////////////////////////////////////////////////////////////////////////////////////////////////////////
//		left.add(oppHero, BorderLayout.NORTH);
//		oppHero.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, top.getHeight()));
//
//		left.add(currHero, BorderLayout.SOUTH);
//		currHero.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, bottom.getHeight()));
//
//		left.add(centerLeft, BorderLayout.CENTER);
//		centerLeft.setPreferredSize(new Dimension(left.getWidth() * 15 / 100, center.getHeight()));
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		right.add(oppMana, BorderLayout.NORTH);
//		oppMana.setBackground(Color.orange);
//		oppMana.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, top.getHeight()));
//
//		right.add(currMana, BorderLayout.SOUTH);
//		currMana.setBackground(Color.orange);
//		currMana.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, bottom.getHeight()));
//
//		right.add(centerRight, BorderLayout.CENTER);
//		centerRight.setBackground(Color.pink);
//		centerRight.setPreferredSize(new Dimension(right.getWidth() * 15 / 100, center.getHeight()));
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		top.add(oppDeck);
//		oppDeck.setPreferredSize(new Dimension(top.getWidth(), top.getHeight()));

//		bottom.add(currHand, BorderLayout.CENTER);
//		currHand.setLayout(new GridLayout(1, 0));
//		currHand.setPreferredSize(new Dimension(this.getWidth() * 60 / 100, this.getHeight() * 10 / 100));
//
//		bottom.add(currCenterTopEdge, BorderLayout.NORTH);
//		currCenterTopEdge.setPreferredSize(new Dimension(this.getWidth() * 50 / 100, this.getHeight() * 5 / 100));
//
//		bottom.add(currCanterRightEdge, BorderLayout.EAST);
//		currCanterRightEdge.setPreferredSize(new Dimension(bottom.getWidth(), bottom.getHeight()));
//
//		bottom.add(currCenterLeftEdge, BorderLayout.WEST);
//		currCenterLeftEdge.setPreferredSize(new Dimension(bottom.getWidth(), bottom.getHeight()));

	}

	public FieldPlane getField() {
		return field;
	}

}
