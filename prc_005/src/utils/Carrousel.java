package utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carrousel {

    private static int value = 0;
    private static ArrayList<Button> buttonPanel = new ArrayList();

    public static JPanel getCarousel(int width, int height, String text) {
    	
        JPanel result = new JPanel(new GridBagLayout());
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JButton btnLeft = Button.getButton("/images/Izquierda.png", 15, height);
        JButton btnRight = Button.getButton("/images/Derecha.png", 15, height);
        JLabel mainImage = new JLabel();
        JPanel subPanel = new JPanel();
        JPanel backgroundImagesPanel = new JPanel(new BorderLayout());
        JLabel backgroundImageLabelLeft = new JLabel();
        JLabel backgroundImageLabelRight = new JLabel();
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.8;
        gbc.weighty = 0.8;
        result.add(mainPanel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, -40, 0, 0);
        mainPanel.add(btnLeft, gbc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 0);
        mainPanel.add(btnRight, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(mainImage, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(subPanel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, -10, 0, -10);
        mainPanel.add(backgroundImagesPanel, gbc);
        
        result.setOpaque(false);
        mainPanel.setOpaque(false);

        mainImage.setHorizontalAlignment(JLabel.CENTER);
        mainImage.setVerticalAlignment(JLabel.CENTER);
        mainImage.setIcon(getMainImage((int)(width/3), (int)(height/3.10), text, value, mainPanel));
        subPanel.setBackground(Color.WHITE);
        subPanel.setPreferredSize(new Dimension(width, 50));
        subPanel.setOpaque(false);
        ImagesButton(subPanel, value);     
        backgroundImagesPanel.setOpaque(false);
        backgroundImageLabelLeft.setIcon(resizeImageIcon("/images/ImageBackground.png", (int)(width/3), (int)(height/3.20)));
        backgroundImagesPanel.add(backgroundImageLabelLeft, BorderLayout.WEST);
        backgroundImageLabelRight.setIcon(resizeImageIcon("/images/ImageBackground.png", (int)(width/3), (int)(height/3.20)));
        backgroundImagesPanel.add(backgroundImageLabelRight, BorderLayout.EAST);


        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.remove(mainImage);
                if (value > 0) {
                    value = value - 1;
                } else if (value <= 0) {
                    value = 4;
                }
                ImagesButton(subPanel, value);
                mainImage.setIcon(getMainImage((int)(width/3), (int)(height/3.10), text, value, mainPanel));
                result.repaint();
                result.revalidate();
            }
        });

        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.remove(mainImage);
                if (value < 4) {
                    value = value + 1;
                } else if (value >= 4) {
                    value = 0;
                }
                ImagesButton(subPanel, value);
                mainImage.setIcon(getMainImage((int)(width/3), (int)(height/3.10),text, value, mainPanel));
                result.repaint();
                result.revalidate();
            }
        });

        return result;
    }

    public static ImageIcon getMainImage(int width, int height, String text, int number, JPanel panel) {
        String basePath = "/images/" + text;
        ImageIcon mainImageIcon = new ImageIcon(Carrousel.class.getResource(basePath + String.valueOf(number) + ".png"));
        Image originalImage = mainImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon mainImage = new ImageIcon(resizedImage);
        return mainImage;
    }
    
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(Carrousel.class.getResource(imagePath));
        Image originalImage = imageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }


    public static void ImagesButton(JPanel panel, int value) {
        panel.removeAll();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
        for (int i = 0; i < 5; i++) {
            JButton button;
            if (i == value) {
                button = Button.getButton("/images/PuntoCarruselFilled.png", 8, 8);
            } else {
                button = Button.getButton("/images/PuntoCarruselEmpty.png", 8, 8);
            }
            panel.add(button);
        }
        panel.repaint();
        panel.revalidate();
    }
}
