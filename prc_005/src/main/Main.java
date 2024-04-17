package main;

import javax.swing.SwingUtilities;

import utils.Screen;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Screen screen = new Screen();
            screen.initUI();
            screen.setVisible(true);
        });
    }
}
