package utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {

    public static JButton createButton(String imagePath) {
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon(Button.class.getResource(imagePath));
        button.setIcon(icon);
        customizeButton(button);
        return button;
    }

    private static void customizeButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
