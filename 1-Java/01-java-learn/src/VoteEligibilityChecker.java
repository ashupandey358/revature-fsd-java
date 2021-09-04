import java.util.Scanner;

public class VoteEligibilityChecker {

	public static void main(String[] args) {
		System.out.println("Enter the age:");
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		
		// 10 < 18 - true
		// 18 < 18 - false
		// 25 < 18 - false
		if (age < 18) {
			System.out.println("Cannot Vote.");
		} else {
			System.out.println("Can Vote.");
		}
	}

}
