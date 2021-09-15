package com.bankapp.login;

abstract public class Login {
private String name;
protected boolean success=false;
public Login(String name) {
	super();
	this.name = name;
	success=false;
}
private void displayTitle() {
	System.out.println("\n====");
	System.out.println(name);
	System.out.println("====\n");
}
public void captureDataAndPerformAction() {
	while (!success) {
		displayTitle();
		captureData();
		action();
	}
}

public abstract void captureData();

public abstract void action();

}
