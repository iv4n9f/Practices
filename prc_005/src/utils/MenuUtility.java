package utils;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MenuUtility {
    public static JPanel getSideMenu(int width) {
        JPanel result = new JPanel(new BorderLayout());
        result.setBounds(0,0,100,100);
        result.setVisible(true);        
        return result;
    }
}
