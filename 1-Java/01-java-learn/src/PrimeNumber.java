import java.util.Scanner;

public class PrimeNumber {
	
	public static boolean itsPrime(int n)
	{
		boolean temp = false;
		for(int i =2;i<n;i++)
		{
			if(n%i==0)
			{
				temp = true;
				break;
			}
		}
		if(temp==false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args) {
		
		for(int i=2;i<=500;i++)
		{
		boolean value = itsPrime(i);
		if(value==true)
		{
			System.out.println("This no is prime "+i);
		}
		else
		{
			System.out.println("This no is not prime "+i);
		}
		}
		

	}

}
