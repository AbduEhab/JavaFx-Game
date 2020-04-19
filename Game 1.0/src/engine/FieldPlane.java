package engine;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FieldPlane extends JPanel {

	private JPanel currField;
	private JPanel oppField;

	public FieldPlane() {

		currField = new JPanel();
		oppField = new JPanel();
		
		setLayout(new BorderLayout());

		add(oppField, BorderLayout.NORTH);
//		oppField.setPreferredSize(new Dimension(600,200));
		add(currField, BorderLayout.SOUTH);
//		currField.setPreferredSize(new Dimension(getWidth(),getHeight()/2));

	}

	public JPanel getCurrField() {
		return currField;
	}

	public JPanel getOppField() {
		return oppField;
	}

}
