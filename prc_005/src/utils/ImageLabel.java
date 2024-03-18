package utils;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel {
    public static JLabel getImageLabel(int width, int height, String path) {
        JLabel result = new JLabel();
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        result.setIcon(scaledIcon);
        result.setPreferredSize(new Dimension(width, height));
        return result;
    }
}
