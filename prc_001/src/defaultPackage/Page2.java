package defaultPackage;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Page2 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Page2() {
		setBackground(new Color(255, 255, 255));
		setBounds(10, 92, 1084, 665);
		
		JLabel lblNewLabel = new JLabel("Page 2");
		add(lblNewLabel);
	}

}
