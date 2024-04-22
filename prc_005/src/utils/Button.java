package utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {

    public static JButton getButton(String imagePath, int screenWidth, int screenHeight) {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(Button.class.getResource(imagePath)));

        int buttonWidth = screenWidth / 40;
        int buttonHeight = screenHeight / 30;
        
        button.setSize(buttonWidth, buttonHeight);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        
        return button;
    }
}