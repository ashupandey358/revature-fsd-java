import java.util.*;

public class Solution {

	public static String format(String s) {
		ArrayList<Character> list = new ArrayList();
		for(int i=0;i<s.length()-2;i++)
		{
			if(s.charAt(i)==s.charAt(i+1) )
			{
				list.add(s.charAt(i));
			}
		}
		 
	       
return list.toString() ;

}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(Solution.format(s.nextLine()));
		s.close();
	}

}
