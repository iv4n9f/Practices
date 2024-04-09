package utils;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonManager {
    private ArrayList<JButton> buttonList;
    private JPanel buttonPanel;

    public ButtonManager(ArrayList<JButton> buttonList, JPanel buttonPanel) {
        this.buttonList = buttonList;
        this.buttonPanel = buttonPanel;
    }

    public void addButtons(int screenWidth, int screenHeight, JPanel backgroundImage) {
        String basePath = "/images/LauncherButton";
        for (int i = 0; i < 14; i++) {
            String buttonName = "Button" + i;
            JButton button = Button.getButton(basePath + i + ".png", screenWidth, screenHeight);
            buttonList.add(button);
            button.addActionListener(e -> {
                Panel.addHomePanel(screenWidth, screenHeight, backgroundImage, buttonName);
            });
            buttonPanel.add(button);
        }
    }
}
