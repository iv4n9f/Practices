package utils;

import javax.swing.JPanel;

public class PanelManager {

    private JPanel actualPanel = null;
    private final JPanel backgroundImage;
    private final int screenWidth;
    private final int screenHeight;

    public PanelManager(JPanel backgroundImage, int screenWidth, int screenHeight) {
        this.backgroundImage = backgroundImage;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void addHomePanel() {
        if (actualPanel != null) {
            backgroundImage.remove(actualPanel);
        }
        HomePanel homePanel = new HomePanel(screenWidth, screenHeight, backgroundImage);
        homePanel.addButtons();
        actualPanel = homePanel.getPanel();
        backgroundImage.add(actualPanel);
        backgroundImage.revalidate();
        backgroundImage.repaint();
    }

    public void addGamePanel(String buttonName) {
        String tag;
        if (actualPanel != null) {
            backgroundImage.remove(actualPanel);
        }
        switch (buttonName) {
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
        GamePanel gamePanel = new GamePanel(screenWidth, screenHeight, tag);
        actualPanel = gamePanel.getPanel();
        backgroundImage.add(actualPanel);
        backgroundImage.revalidate();
        backgroundImage.repaint();
    }
}
