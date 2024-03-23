package utils;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Screen frame = new Screen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Screen() {
        
        ArrayList<JButton> buttonList = new ArrayList<>();
        String basePath = "/images/LauncherButton";
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, screenWidth, screenHeight);
        setUndecorated(true);

        ImageBackground backgroundImage = new ImageBackground();
        backgroundImage.setBorder(new EmptyBorder(0,0,0,0));

        setContentPane(backgroundImage);
        backgroundImage.setLayout(null);

        JPanel buttonPanel = new JPanel();
        int panelX = (screenWidth - 1580) / 2;
        int panelY = (int) (screenHeight * 0.065);
        buttonPanel.setBounds(panelX, panelY, 2072, 174);
        buttonPanel.setLayout(new GridLayout(1, 11));
        buttonPanel.setOpaque(false);
        backgroundImage.add(buttonPanel);
        
        for (int i=0; i < 14; i++) {
            JButton button = Button.getButton(basePath + String.valueOf(i) + ".png");
            buttonList.add(button);
        }
        
        for (int i = 0; i < buttonList.size(); i++) {
            JButton button = buttonList.get(i);
            if (i < 12) {
                buttonPanel.add(button);
            }
        }
        
        JButton changeVisibilityButton1 = Button.getButton("/images/Derecha.png");
        buttonPanel.add(changeVisibilityButton1);
        
        JButton changeVisibilityButton2 = Button.getButton("/images/Izquierda.png");
        
        changeVisibilityButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.removeAll();
                buttonPanel.add(changeVisibilityButton2);
                for (int i = 11; i < buttonList.size(); i++) {
                    JButton button = buttonList.get(i);
                    if (i >= 11) { 
                        buttonPanel.add(button);
                    }
                }
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });
        
        changeVisibilityButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.removeAll();
                for (int i = 0; i < buttonList.size(); i++) {
                    JButton button = buttonList.get(i);
                    if (i < 12) {
                        buttonPanel.add(button);
                    }
                }
                buttonPanel.add(changeVisibilityButton1);
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });
    }
}