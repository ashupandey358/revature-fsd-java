package com.revature.app.garbagecollection;

public class GarbageCollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person("jhon", 15);
		person = null;
		
		Person person1 = new Person("jhon", 15);
		Person person2 = new Person("Smith", 25);
		person1=person2;
		for(int i=0;i<10;i++)
		{
			Person person3 = new Person("ashu", 35);
		}
		System.gc();
	
	
	}

}
