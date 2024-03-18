package main;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import utils.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> rrss = new ArrayList<String>();
        rrss.add("www.universae.com");
        rrss.add("Hola Mundo");
        rrss.add("Adios Mundo");

        JFrame screen = ScreenUtility.getScreen();
        JPanel sideMenu = MenuUtility.getSideMenu(250, screen.getHeight());
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));
        JLabel logoImage = ImageLabel.getImageLabel(200, 100, "src/res/logo.png");
        sideMenu.add(logoImage);
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        sideMenu.add(separator);
        sideMenu.add(Box.createVerticalStrut(5));
        for (String value : rrss) {
            sideMenu.add(SocialLink.getSocialLink(value));
        }
        screen.add(sideMenu, BorderLayout.WEST);
        screen.setVisible(true);
    }
}
