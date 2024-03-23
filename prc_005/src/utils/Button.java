package utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {
    private static final long serialVersionUID = 1L;

    public static JButton getButton(String imagePath) {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(Button.class.getResource(imagePath)));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
}
