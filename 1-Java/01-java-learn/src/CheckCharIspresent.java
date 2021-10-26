import java.util.Scanner;

public class CheckCharIspresent {
	
		
	

	public static void main(String[] args) {
		int result =0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for(int i=97; i<=122; i++)
		{
			int value = str.indexOf(i);
			if(value!=-1)
			{
				result++;
			}
		}
		System.out.println(result);
		if(result >= 26)
		{
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}

}
