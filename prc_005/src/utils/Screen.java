package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame {
    
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private JPanel buttonPanel;
    private ButtonManager buttonManager;
    private ImageBackground backgroundImage = new ImageBackground();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    
    public Screen() {
        this.initUI();
        this.buttonManager = new ButtonManager(buttonList, buttonPanel, backgroundImage);
        this.buttonManager.addButtons();
    }


    public void initUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, screenWidth, screenHeight);
        this.setUndecorated(true);

        backgroundImage.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setContentPane(backgroundImage);
        backgroundImage.setLayout(null);

        buttonPanel = new JPanel();
        int panelWidth = screenWidth - (screenWidth / 15);
        int panelHeight = screenHeight - (screenHeight / 2);
        int panelX = (screenWidth / 10);
        int panelY = (int) (screenHeight * 0.08);
        buttonPanel.setBounds(panelX, panelY, panelWidth, panelHeight);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonPanel.setOpaque(false);
        backgroundImage.add(buttonPanel);
    }
}
