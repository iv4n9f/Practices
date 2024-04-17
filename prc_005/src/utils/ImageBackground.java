package utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageBackground extends JPanel {
    private Image backgroundImage;

    public ImageBackground() {
        loadImage();
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    private void loadImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/background.png"));
        backgroundImage = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
    }

    private void drawBackground(Graphics g) {
        Dimension size = getSize();
        g.drawImage(backgroundImage, 0, 0, size.width, size.height, this);
    }
}
