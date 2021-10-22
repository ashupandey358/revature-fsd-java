import java.util.Scanner;

public class CharCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int countu =0;
		int countl =0;
		int counts=0;
		int countn=0;
		
		for(int i=0; i<str.length(); i++)
		{
			Character c=str.charAt(i);
			if( Character.isUpperCase(c))
			{
				countu++;
			}
			else if( Character.isLowerCase(c))
			{
				countl++;
			}
			else if( Character.isDigit(c))
			{
				countn++;
			}
			else
			{
				counts++;
			}
		}
		System.out.println(countl);
		System.out.println(countu);
		System.out.println(counts);
		System.out.println(countn);

	}

}
