package defaultPackage;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class Page1 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Page1() {
		setBackground(new Color(255, 255, 255));
		setBounds(10, 92, 1084, 665);
		
		JLabel lblNewLabel = new JLabel("Page 1");
		add(lblNewLabel);
	}

}
