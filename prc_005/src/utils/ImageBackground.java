package utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageBackground extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ImageBackground() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    
		this.setSize(screenWidth,screenHeight);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/background.png"));
		g.drawImage(backgroundImage.getImage(),0,0,size.width,size.height,null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
