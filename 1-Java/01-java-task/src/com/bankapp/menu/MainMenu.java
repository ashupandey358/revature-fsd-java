package com.bankapp.menu;
import java.util.Scanner;

public class MainMenu extends Menu {

	public MainMenu(String name) {
		super(name);
		addMenuIteams("New User");
		addMenuIteams("customer login");
		addMenuIteams("Employee Login");
		addMenuIteams("Exit");
	}

	@Override
	public void handle() {
		Scanner scanner = new Scanner(System.in);
		switch(choice) {
		case 1:
			System.out.println("\n===");
			System.out.println("Register new customer");
			System.out.println("====\n");
			System.out.print("First Name: ");
			String firstName = scanner.nextLine();
			
			System.out.print("Last Name: ");
			String lastName = scanner.nextLine();

			System.out.print("Email: ");
			String email = scanner.nextLine();

			System.out.print("Password: ");
			String password = scanner.nextLine();
			Customer(firstName,)
		}
	}

}
