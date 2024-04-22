package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel {
    
    public static JPanel actualPanel = null;
    public static String text;
    public static int generalScreenWidth = 0;
    public static int generalScreenHeight = 0;
    public static JPanel generalBackgroundImage = null ; 
    public static String buttonName;
    
    
    public static JPanel getHomePanel(int width, int height, List<String> detalle) {
        JPanel result = new JPanel(new GridLayout(2, 3));
        
        String basePath = "/images/HomeButton";
        int index = 0;
        for (int i = 0; i < detalle.size(); i += 4) {
        	
        	String imagen = detalle.get(i + 1);
        	String path = basePath + index + ".png";
        	

            JButton button = Button.getButton(path, width, height);
            Dimension normalSize = new Dimension(width, height);
            button.setPreferredSize(normalSize);

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Dimension biggerSize = new Dimension((int) (width * 1.2), (int) (height * 1.2));
                    button.setPreferredSize(biggerSize);
                    button.revalidate();
                    button.repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setPreferredSize(normalSize);
                    button.revalidate();
                    button.repaint();
                }
            });

            String title = detalle.get(i);
        	String description = detalle.get(i+3);
        	String game = detalle.get(i+2);
            button.addActionListener(e -> {
                addGamePanel(generalScreenWidth, generalScreenHeight, generalBackgroundImage, imagen,  title,  description, game);
            });
            result.add(button);
            index += 1 ; 
        }

        result.setBackground(Color.WHITE);
        result.setVisible(true);
        result.setOpaque(false);
        return result;
    }



    
    public static JPanel getGamePanel(int width, int height, String imagen, String title, String description, String game) {
    	
        JPanel result = new JPanel(null);
        JPanel carrousel = Carrousel.getCarousel(width, height, imagen);
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel gameTitleLabel = new JLabel(title);
        JLabel gameDescriptionLabel = new JLabel(description);
        JButton startButton = Button.getButton("/images/Comenzar.png", 30, 10);
        

        
        result.setBackground(Color.WHITE);
        result.setVisible(true);
        result.setOpaque(false);
        result.add(carrousel);
        result.add(textPanel);
        
        textPanel.add(gameTitleLabel);
        textPanel.add(gameDescriptionLabel);


        textPanel.setOpaque(false);
        gameTitleLabel.setForeground(Color.WHITE);
        gameDescriptionLabel.setForeground(Color.WHITE);
     
        carrousel.setBounds(width/10, height/16, width/2,height/3);    
        textPanel.setBounds(width / 10, (int)(height / 2.25), (int)(width * 0.30), height - (height / 3));      
        gameTitleLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        gameDescriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 14));

        startButton.setBounds((int)(width / 2.5), height / 2, (int) (width * 0.30), (int) (height / 4));
        startButton.addActionListener(e -> {
        });
        result.add(startButton);
        
        startButton.addActionListener(e -> {
            //
        });
                
        return result;
    }
    
    public static void addHomePanel(int screenWidth, int screenHeight, JPanel backgroundImage, List<String> detalles) {
        generalScreenWidth = screenWidth;
        generalScreenHeight = screenHeight;
        generalBackgroundImage = backgroundImage;

        if (actualPanel != null) {
            backgroundImage.remove(actualPanel);
        }
        
        JPanel homePanel = getHomePanel(screenWidth, screenHeight, detalles);
        homePanel.setBounds(screenWidth / 4, screenHeight / 4, (int)(screenWidth * 0.70), (int)(screenHeight * 0.7));
        
        backgroundImage.add(homePanel);
        backgroundImage.revalidate();
        backgroundImage.repaint();
        actualPanel = homePanel;
    }

    
    public static void addGamePanel(int screenWidth, int screenHeight, JPanel backgroundImage, String imagen, String title, String description, String game ) {
        if (actualPanel != null) {
            backgroundImage.remove(actualPanel);
        }        
        JPanel gamePanel = getGamePanel(screenWidth, screenHeight, imagen, title, description, game);
        gamePanel.setBounds(screenWidth / 4, screenHeight / 4, (int)(screenWidth * 0.70), (int)(screenHeight * 7.8));
        backgroundImage.add(gamePanel);
        backgroundImage.revalidate();
        backgroundImage.repaint();
        actualPanel = gamePanel;
    }
}