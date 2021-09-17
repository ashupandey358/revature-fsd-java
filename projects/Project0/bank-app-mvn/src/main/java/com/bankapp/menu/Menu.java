package com.bankapp.menu;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	protected String name;
	protected ArrayList<String> menuIteams;
	protected int choice;
	
	public Menu(String name) {
		super();
		this.name = name;
		menuIteams=new ArrayList<String>();
	}
	public void addMenuIteams(String menuIteamsName) {
		menuIteams.add(menuIteamsName);
	}
	public void displayMenu()
	{
		System.out.println("***************");
		System.out.println("---------------");
		System.out.println(name);
		for(int i=0;i<menuIteams.size();i++)
		{
			System.out.println(i+1 + "]. " +menuIteams.get(i));
		}
		System.out.println("Entre your Choice :");
	}
	public void captureSelection()
	{
		Scanner sc = new Scanner(System.in);
		choice = Integer.parseInt(sc.nextLine());
	}
	public void displaySelectionhandle()
	{
		displayMenu();
		captureSelection();
		handle();
	}
	public abstract void handle();
}
