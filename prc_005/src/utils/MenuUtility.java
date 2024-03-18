package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MenuUtility {
    public static JPanel getSideMenu(int width, int height) {
        JPanel result = new JPanel(new BorderLayout());
        result.setPreferredSize(new Dimension(width, height));
        result.setBackground(new Color(14, 77, 144));
        result.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        return result;
    }
}
