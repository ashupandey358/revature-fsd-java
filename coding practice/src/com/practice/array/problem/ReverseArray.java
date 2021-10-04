package com.practice.array.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String a[] = new String[n];
		ArrayList<String> array = new ArrayList<String>();
		for(int i=0;i<n;i++)
		{
			a[i]=sc.next();
		}
		for(int i=0;i<n;i++)
		{
			array.add(a[i]);
		}
		Collections.reverse(array);
		array.forEach(System.out::println);
		
	}

}
