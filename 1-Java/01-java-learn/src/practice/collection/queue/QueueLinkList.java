package practice.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> ql = new LinkedList<>();
		ql.offer(20);
		ql.offer(40);
		ql.offer(30);
		ql.offer(460);
		ql.offer(30);
		ql.offer(80);
		System.out.println("The element which is ready to remove element "+ql.peek());
		 //its clearly show that 20 insert first so it remove first
		ql.poll(); // its remove the first element of the queue
		for(Integer data:ql)
		{
			System.out.println(data);
		}
		

	}

}
