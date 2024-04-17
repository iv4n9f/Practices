package utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {
    private static final long serialVersionUID = 1L;

    public static JButton getButton(String imagePath, int screenWidth, int screenHeight) {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(Button.class.getResource(imagePath)));

        // Establecer el tamaño del botón
        int buttonWidth = screenWidth / 40; // Ajusta el ancho según sea necesario
        int buttonHeight = screenHeight / 30; // Ajusta la altura según sea necesario
        button.setSize(buttonWidth, buttonHeight);

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
}
