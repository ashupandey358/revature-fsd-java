package practice.collection.list;

import java.util.Stack;

public class StackDemo {
      public static void main(String[] args) {
    	  Stack<String> stack = new Stack<>();
    		stack.push("Ashu Pandey");
    		stack.push("Ashi Pandey");
    		System.out.println(stack.indexOf(stack.peek()));
    		System.out.println(stack.pop());
    		for(String data:stack) {
    		System.out.println(data);
    		}
		
	}
	
	
	

}
