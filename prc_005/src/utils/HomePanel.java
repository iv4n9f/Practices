package utils;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

class HomePanel {

    private final JPanel panel;
    private final int screenWidth;
    private final int screenHeight;
    private final JPanel backgroundImage;

    public HomePanel(int screenWidth, int screenHeight, JPanel backgroundImage) {
        this.panel = new JPanel(new GridLayout(2, 3));
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.backgroundImage = backgroundImage;
    }

    public void addButtons(ButtonManager buttonManager) {
        buttonManager.addButtons(screenWidth, screenHeight, backgroundImage);
        panel.add(buttonManager.getButtonPanel());
        panel.setBackground(Color.WHITE);
        panel.setOpaque(false);
    }

    public JPanel getPanel() {
        return panel;
    }
}
