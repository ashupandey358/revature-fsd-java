import java.util.Scanner;

public class SubString {
	
	
	public static void main(String[] args) {
		String subString="";
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for(int i=0; i<str.length() - 3; i=i+3) {
			if(i>str.length())
			{
				 subString = str.substring(i);
				 System.out.println(subString);
				 break;
			}
			else  {
		 subString = str.substring(i,i+3);
		 System.out.println(subString);
			}
		 
		
	}
		
	}
}
