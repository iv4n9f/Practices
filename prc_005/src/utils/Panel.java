package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    
    
    public static JPanel getHomePanel(int width, int height, String text) {
        JPanel result = new JPanel(new GridLayout(2, 3));
        
        String basePath = "/images/HomeButton";
        for (int i = 0; i < 6; i++) {
            String buttonName = "Button" + String.valueOf(i);
            JButton button = Button.getButton(basePath + String.valueOf(i) + ".png", width, height);
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
            
            button.addActionListener(e -> {
                addGamePanel(generalScreenWidth,generalScreenHeight,generalBackgroundImage, buttonName);
            });
            result.add(button);
        }
        
        result.setBackground(Color.WHITE);
        result.setVisible(true);
        result.setOpaque(false);
        return result;
        
    }
    
    public static JPanel getGamePanel(int width, int height, String text) {
        JPanel result = new JPanel(null);
        result.setBackground(Color.WHITE);
        result.setVisible(true);
        result.setOpaque(false);
        
        JPanel carrousel = Carrousel.getCarousel(width, height, text);
        carrousel.setBounds(width/10, height/16, width/2,height/3);
        result.add(carrousel);
        
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textPanel.setBackground(Color.WHITE);
        textPanel.setOpaque(false);
        textPanel.setBounds(width / 10, (int)(height / 2.25), (int)(width * 0.30), height - (height / 3));
        result.add(textPanel);
        
        String title = "Mantenimiento de los equipos y herramientas de extinción de incendios forestales.";
        JLabel gameTitleLabel = new JLabel(title);
        gameTitleLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        gameTitleLabel.setForeground(Color.WHITE); // Set foreground color to white
        textPanel.add(gameTitleLabel);

        String description = "En un campo de prácticas sumido en el desorden y la confusión tienes que encontrar y colocar las partes de los EPIs utilizados en la extinción de incendios forestales.";
        JLabel gameDescriptionLabel = new JLabel(description);
        gameDescriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        gameDescriptionLabel.setForeground(Color.WHITE); // Set foreground color to white
        textPanel.add(gameDescriptionLabel);

        String duration = "Duración aproximada: 10 minutos";
        JLabel gameDurationLabel = new JLabel(duration);
        gameDurationLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        gameDurationLabel.setForeground(Color.WHITE); // Set foreground color to white
        textPanel.add(gameDurationLabel);

        String difficulty = "Nivel de dificultad: Fácil.";
        JLabel gameDifficultyLabel = new JLabel(difficulty);
        gameDifficultyLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        gameDifficultyLabel.setForeground(Color.WHITE); // Set foreground color to white
        textPanel.add(gameDifficultyLabel);

        String restOfText = "\r\n"
        	+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras accumsan viverra hendrerit. Curabitur risus nisi, eleifend at rhoncus ac, imperdiet vitae justo. Curabitur risus ex, vulputate ut augue sit amet, sagittis aliquam ex. Aliquam lacinia elit eget euismod volutpat. Quisque nulla nisi, tempor id nunc dictum, malesuada venenatis erat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec ornare eros ac quam feugiat, sit amet varius massa accumsan. Sed interdum mollis lobortis. Praesent ultricies tortor sit amet dui mollis tincidunt. Quisque auctor, mi sit amet lacinia gravida, tellus leo cursus nibh, in ornare enim ipsum.";
        JLabel restTextLabel = new JLabel(restOfText);
        restTextLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
        restTextLabel.setForeground(Color.WHITE); // Set foreground color to white
        textPanel.add(restTextLabel);
        
        JButton startButton = Button.getButton("/images/Comenzar.png", 30, 10);
        startButton.setBounds((int)(width / 2.5), height / 2, (int) (width * 0.30), (int) (height / 4));
        startButton.addActionListener(e -> {
        });
        result.add(startButton);
                
        return result;
    }
    
    public static void addHomePanel(int screenWidth, int screenHeight, JPanel backgroundImage, String text) {
        
        generalScreenWidth = screenWidth;
        generalScreenHeight = screenHeight;
        generalBackgroundImage = backgroundImage;   
        
        
        if (actualPanel != null) {
            backgroundImage.remove(actualPanel);
        }
        JPanel homePanel = getHomePanel(screenWidth, screenHeight, text);
        homePanel.setBounds(screenWidth / 4, screenHeight / 4, (int)(screenWidth * 0.70), (int)(screenHeight * 0.7));
        
        backgroundImage.add(homePanel);
        backgroundImage.revalidate();
        backgroundImage.repaint();
        actualPanel = homePanel;
    }
    
    public static void addGamePanel(int screenWidth, int screenHeight, JPanel backgroundImage, String text) {
        String tag = null;
        if (actualPanel != null) {
            backgroundImage.remove(actualPanel);
        }
        switch (text){
            case "Button0":
                tag = "Embarque";
                break;
            case "Button1":
                tag = "Hemorragia";
                break;
            case "Button2":
                tag = "Extincion";
                break;
            case "Button3":
                tag = "EPIS";
                break;
            case "Button4":
                tag = "Helicoptero";
                break;
            default:
                tag = "Ascensor";
                break;
        }
        JPanel gamePanel = getGamePanel(screenWidth, screenHeight, tag);
        gamePanel.setBounds(screenWidth / 4, screenHeight / 4, (int)(screenWidth * 0.70), (int)(screenHeight * 7.8));
        backgroundImage.add(gamePanel);
        backgroundImage.revalidate();
        backgroundImage.repaint();
        actualPanel = gamePanel;
    }
}