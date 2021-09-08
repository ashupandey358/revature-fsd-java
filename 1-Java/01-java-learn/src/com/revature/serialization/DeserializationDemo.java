package com.revature.serialization;
import com.revature.app.collection.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializationDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		FileInputStream fileOutput=new FileInputStream("d:\\person.ser");
		ObjectInputStream objectInput=new ObjectInputStream(fileOutput);
		List<Person> personList=(ArrayList) objectInput.readObject();
		personList.forEach(System.out::println);
		objectInput.close();
		fileOutput.close();
		}catch(IOException e)
		{
			System.out.println("Please insert your file");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class is not Found");
		}

	}

}
