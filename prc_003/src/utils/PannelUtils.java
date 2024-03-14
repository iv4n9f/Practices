package utils;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class PannelUtils {

    public static JFrame getPannelUtils(int width, int height, ArrayList<String> tabs, ArrayList<String> content) {
        JFrame result = new JFrame();
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        result.setContentPane(contentPanel);
        contentPanel.setLayout(null);
        JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
        tabbedPanel.setBounds(0, 0, width, height);
        contentPanel.add(tabbedPanel);
        contentPanel.setVisible(true);
        result.setVisible(true);
        if (tabs.size() == content.size()) {
            for (int i = 0; i < tabs.size(); i++) {
                String tabTitle = tabs.get(i);
                String tabContent = content.get(i);
                JPanel tabContentPanel = new JPanel();
                tabContentPanel.add(new JLabel(tabContent));
                tabbedPanel.addTab(tabTitle, null, tabContentPanel, null);
            }
        } else {
            System.out.println("El número de tabs y contenido no coincide.");
        }
        result.setBounds(0,0,width +5 , height +5);
        return result;
    }
}