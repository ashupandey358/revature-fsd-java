package com.revature.banknew.menu;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	protected String name;
	protected ArrayList<String> menuItems;
	protected int option;

	public Menu(String name) {
		super();
		this.name = name;
		menuItems = new ArrayList<String>();
	}

	public void addMenuItem(String menuItemsName) {
		menuItems.add(menuItemsName);
	}

	public void dispalyMenu() {
		System.out.println("*****************");
		System.out.println(name);
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println(i + 1 + "->  " + menuItems.get(i));

		}
		System.out.println("Entre your Choice :");
	}

	public void selectMenu() {
		Scanner choice = new Scanner(System.in);
		option = Integer.parseInt(choice.nextLine());
	}
	public abstract void handle();

	public void mainDisplay() {
		dispalyMenu();
		selectMenu();
		handle();
	}

}
