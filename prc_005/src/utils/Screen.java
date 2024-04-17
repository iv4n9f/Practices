package utils;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private JPanel buttonPanel;
    private ButtonManager buttonManager;
    private ImageBackground backgroundImage = new ImageBackground();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

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
        initializeUI();
        buttonManager = new ButtonManager(buttonList, buttonPanel);
        buttonManager.addButtons(screenWidth, screenHeight, backgroundImage);
    }

    private void initializeUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, screenWidth, screenHeight);
        setUndecorated(true);

        backgroundImage.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(backgroundImage);
        backgroundImage.setLayout(null);

        buttonPanel = new JPanel();
        int panelWidth = screenWidth - (screenWidth / 15);
        int panelHeight = screenHeight - ( screenHeight / 2 ) ;
        int panelX = (0 + (screenWidth / 10 ));
        int panelY = (int) (screenHeight * 0.08);
        buttonPanel.setBounds(panelX, panelY, panelWidth, panelHeight);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonPanel.setOpaque(false);
        backgroundImage.add(buttonPanel);
        
    }
}
