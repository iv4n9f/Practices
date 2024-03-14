package main;

import java.util.ArrayList;

import utils.PannelUtils;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> tabs = new ArrayList<String>();
		ArrayList<String> content = new ArrayList<String>();
		tabs.add("Tab 1");
		content.add("Hola Mundo");
		tabs.add("Tab 2");
		content.add("Adios Mundo");
		PannelUtils.getPannelUtils(1000, 500, tabs, content);
	}

}