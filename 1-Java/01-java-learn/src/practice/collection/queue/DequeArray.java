package practice.collection.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class DequeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		deq.offer(1);
		deq.offer(3);
		deq.offer(10);
		//it work normal as queue 
		System.out.println(deq);
		deq.offerFirst(20);  //it work similar to the offer it adds from the first
		System.out.println(deq);
		deq.offerLast(40);
		System.out.println(deq);  //it work add the element on the end side.
		System.out.println(deq.peekFirst()); //its show the first element of queue
		deq.pollFirst();
		System.out.println(deq);  //remove the first element
		System.out.println(deq.peekLast()); //its show the last element of queue
		deq.pollLast();
		System.out.println(deq);
	}

}
