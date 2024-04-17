package utils;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonManager {
    private ArrayList<JButton> buttonList;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    public ButtonManager(ArrayList<JButton> buttonList, JPanel buttonPanel, JPanel mainPanel) {
        this.buttonList = buttonList;
        this.buttonPanel = buttonPanel;
        this.mainPanel = mainPanel;
    }

    public void addButtons() {
        String basePath = "/images/LauncherButton";
        int screenWidth = buttonPanel.getWidth();
        int screenHeight = buttonPanel.getHeight();

        for (int i = 0; i < 14; i++) {
            String buttonName = "Button" + i;
            JButton button = Button.createButton(basePath + i + ".png");
            buttonList.add(button);
            button.addActionListener(e -> {
                Panel.addHomePanel(screenWidth, screenHeight, mainPanel, buttonName);
            });
            buttonPanel.add(button);
        }
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}
