import java.util.Scanner;

public class CodeingQuestion {

	public static void main(String[] args) {
		System.out.println("Entre the size of array");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		boolean r=maximumJump(nums);
		System.out.println(r);

	}

	private static boolean maximumJump(int[] nums) {
		int a = 0;
		boolean result = false;
		for(int i=0;i<nums.length-a;i=i+a)
		{
			if(nums[i+1]==0 && nums.length<=2 )
			{
				result=true;
				break;
			}
			a=nums[i+1];
			if(nums[i+1]==0 && nums[nums.length-1]!=0)
			{
				result=false;
				break;
						
			}
			else
			{
				result=true;
			}
			
		}
		return result;
	}

}
