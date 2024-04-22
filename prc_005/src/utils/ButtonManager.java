package utils;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonManager {
    private ArrayList<JButton> buttonList;
    private JPanel buttonPanel;

    public ButtonManager(ArrayList<JButton> buttonList, JPanel buttonPanel) {
        this.buttonList = buttonList;
        this.buttonPanel = buttonPanel;
    }

    public void addButtons(int screenWidth, int screenHeight, JPanel backgroundImage, List<List<String>> info) {
        String basePath = "/images/LauncherButton";
        int buttonIndex = 0;
        for (List<String> gradoInfo : info) {
            String imagePath = basePath + buttonIndex + ".png";
            
            JButton button = Button.getButton(imagePath, screenWidth, screenHeight);
            buttonList.add(button);
            
            button.addActionListener(e -> {
            	List<String> subArray = gradoInfo.subList(1, gradoInfo.size());
                Panel.addHomePanel(screenWidth, screenHeight, backgroundImage, subArray);
            });

            buttonPanel.add(button);
            buttonIndex++;
        }

        FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(-40);
        flowLayout.setVgap(-5);
        flowLayout.setAlignOnBaseline(true);
    }
}
