package practice.collection.set;

import java.util.HashSet;
import java.util.Set;
//hashset not maintain order.
public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> sh = new HashSet<>();
		sh.add(10);
		sh.add(30);
		sh.add(40);
		sh.add(30);
		sh.add(10);
		sh.add(60);
		sh.add(80);
		sh.add(20);
		System.out.println(sh); //it does not show duplicate value
		System.out.println(sh.isEmpty()); //it show set is empty or not if set is empty its return true.
		System.out.println(sh.contains(100)); //it gives false if the value is not in the set
		sh.remove(40); //it is used to remove the object.
		System.out.println(sh);

	}

}
