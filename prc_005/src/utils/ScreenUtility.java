package utils;

import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class ScreenUtility {
    public static JFrame getScreen() {
        JFrame result = new JFrame();
        result.setUndecorated(true);
        result.setVisible(true);
        result.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        return result;
    }
}

