import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PranavCode {
	
	public static void main(String[] args) {
	 	Scanner sc=new Scanner(System.in);
		String s=sc.next();
		Set<Character> str=new LinkedHashSet();
		for(int i=0;i<s.length();i++) 
		{
		    str.add(s.charAt(i));
		}
	   str.forEach(System.out::print);
	}

}