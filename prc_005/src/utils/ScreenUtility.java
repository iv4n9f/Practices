package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenUtility {
    public static JFrame getScreen(String backgroundImagePath) {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        JFrame result = new JFrame();
    	result.setUndecorated(true);
        result.setSize(screenWidth, screenHeight);
        result.setLayout(null);
        
    	
        JPanel backgroundPanel = new JPanel(null);
        
        backgroundPanel.setPreferredSize (screenSize);
               
        JLabel backgroundImage = ImageLabel.getImageLabel(screenWidth, screenHeight, backgroundImagePath);
        backgroundImage.setOpaque(true);
		
        backgroundPanel.add(backgroundImage);
        result.add(backgroundPanel);
        
		backgroundPanel.setBorder(null);
		backgroundPanel.setPreferredSize(screenSize);
		
		backgroundImage.setVisible(true);
		backgroundPanel.setVisible(true);
		result.setVisible(true);
		
    	return result;
    	
    }
}
