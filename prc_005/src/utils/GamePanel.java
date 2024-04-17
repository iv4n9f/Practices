package utils;

import java.awt.Color;

import javax.swing.JPanel;

class GamePanel {

    private final JPanel panel;

    public GamePanel(int width, int height, String tag) {
        panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        panel.setOpaque(false);
        addComponents(width, height, tag);
    }

    private void addComponents(int width, int height, String tag) {
        // Agregar componentes al panel de juego según el tag proporcionado
    }

    public JPanel getPanel() {
        return panel;
    }
}