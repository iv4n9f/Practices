package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.MenuUtility;
import utils.ScreenUtility;

public class Main {	
	 public static void main(String[] args) {
		 JFrame screen = ScreenUtility.getScreen();
		 JPanel menu = MenuUtility.getSideMenu(20);
		 screen.add(menu);
	 }
}
