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
        result.setOpaque(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        result.add(mainPanel, gbc);

        JButton btnLeft = Button.getButton("/images/Izquierda.png", 20, height);
        JButton btnRight = Button.getButton("/images/Derecha.png", 20, height);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, -40, 0, 0); // Ajusta las insets para agregar más espacio entre el panel y el botón izquierdo
        mainPanel.add(btnLeft, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 0); // Ajusta las insets para agregar más espacio entre el panel y el botón derecho
        mainPanel.add(btnRight, gbc);

        JLabel mainImage = new JLabel();
        mainImage.setHorizontalAlignment(JLabel.CENTER);
        mainImage.setVerticalAlignment(JLabel.CENTER);
        mainImage.setIcon(getMainImage(text, value, mainPanel));

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
        ImagesButton(subPanel, value);
        
        

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
                result.remove(mainImage);
                if (value > 0) {
                    value = value - 1;
                } else if (value <= 0) {
                    value = 4;
                }
                ImagesButton(subPanel, value);
                mainImage.setIcon(getMainImage(text, value, mainPanel));
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
                mainImage.setIcon(getMainImage(text, value, mainPanel));
                result.repaint();
                result.revalidate();
            }
        });

        return result;
    }

    public static ImageIcon getMainImage(String text, int number, JPanel panel) {
        String basePath = "/images/" + text;
        ImageIcon mainImage = new ImageIcon(Carrousel.class.getResource(basePath + String.valueOf(number) + ".png"));
        return mainImage;
    }
    
    public static void ImagesButton (JPanel panel, int value) {
    	panel.removeAll();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
    	for (int i = 0 ; i < 5 ; i ++) {
    		JButton button;
    		if (i == value) {
    			button = Button.getButton("/images/PuntoCarruselFilled.png", 10, 10);
    		}	else {
    			button = Button.getButton("/images/PuntoCarruselEmpty.png", 10, 10);
    		}    		
    		panel.add(button);
    	}
    	panel.repaint();
    	panel.revalidate();
    }
}
