package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carrousel {

    private static int value = 0;

    public static JPanel getCarousel(int width, int height, String text) {
        JPanel result = new JPanel(new GridBagLayout());
        result.setOpaque(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        result.add(mainPanel, gbc);

        JButton btnLeft = Button.createButton("/images/Izquierda.png");
        JButton btnRight = Button.createButton("/images/Derecha.png");

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, -40, 0, 0);
        mainPanel.add(btnLeft, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 0);
        mainPanel.add(btnRight, gbc);

        JLabel mainImage = new JLabel();
        mainImage.setHorizontalAlignment(JLabel.CENTER);
        mainImage.setVerticalAlignment(JLabel.CENTER);
        mainImage.setIcon(getMainImage(text, value));

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(mainImage, gbc);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.WHITE);
        subPanel.setPreferredSize(new Dimension(width, 50));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 0, 0);
        subPanel.setOpaque(false);
        mainPanel.add(subPanel, gbc);
        updateImagesButton(subPanel);

        JPanel backgroundImagesPanel = new JPanel(new BorderLayout());
        backgroundImagesPanel.setOpaque(false);

        JLabel backgroundImageLabelLeft = new JLabel();
        backgroundImageLabelLeft.setIcon(new ImageIcon(Carrousel.class.getResource("/images/ImageBackground.png")));
        backgroundImagesPanel.add(backgroundImageLabelLeft, BorderLayout.WEST);

        JLabel backgroundImageLabelRight = new JLabel();
        backgroundImageLabelRight.setIcon(new ImageIcon(Carrousel.class.getResource("/images/ImageBackground.png")));
        backgroundImagesPanel.add(backgroundImageLabelRight, BorderLayout.EAST);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, -20, 0, -20);
        mainPanel.add(backgroundImagesPanel, gbc);

        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = (value - 1 + 5) % 5;
                mainImage.setIcon(getMainImage(text, value));
                updateImagesButton(subPanel);
            }
        });

        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = (value + 1) % 5;
                mainImage.setIcon(getMainImage(text, value));
                updateImagesButton(subPanel);
            }
        });

        return result;
    }

    public static ImageIcon getMainImage(String text, int number) {
        String basePath = "/images/" + text;
        return new ImageIcon(Carrousel.class.getResource(basePath + number + ".png"));
    }

    public static void updateImagesButton(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
        for (int i = 0; i < 5; i++) {
            JButton button = Button.createButton(i == value ? "/images/PuntoCarruselFilled.png" : "/images/PuntoCarruselEmpty.png");
            panel.add(button);
        }
        panel.repaint();
        panel.revalidate();
    }
}
