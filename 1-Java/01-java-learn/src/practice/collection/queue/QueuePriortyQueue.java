package practice.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class QueuePriortyQueue {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Queue<Integer> qp = new PriorityQueue<>(Comparator.reverseOrder()); //it give the maximum number
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			int q = sc.nextInt();
			qp.offer(q);
		}
	
	    for(Integer data:qp)
	    {
	    	System.out.println(data);
	    }

	}

}
