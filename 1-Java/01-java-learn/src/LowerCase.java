import java.util.Scanner;

public class LowerCase {

	public static void main(String[] args) {
		int result = 0;
		int value = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i=0; i<str.length(); i++)
		{
			 int c =(str.charAt(i));
			 value = c -96;
			result = result+value;
		}
		System.out.println(result);
	}

}
