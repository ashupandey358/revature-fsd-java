import java.util.Scanner;

public class CountString {
	
	
	
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in) ;
		String s = sc.next();
		String c = sc.next();
		for(int i=0 ;i<s.length();i++)
		{
			if(s.charAt(i)==c.charAt(0))
			{
				count++;
			}
		}
		System.out.println(count);
	}

}
