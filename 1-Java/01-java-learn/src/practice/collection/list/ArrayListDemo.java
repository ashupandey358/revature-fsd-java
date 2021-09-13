package practice.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<Integer> arraylist = new ArrayList<Integer>();
		arraylist.add(20);
		arraylist.add(30);
		arraylist.add(40);
		arraylist.add(50);
		arraylist.add(60);

		// for data at particular point.

		System.out.println(arraylist.get(arraylist.size() - 1));

	}

}
