
public class LinePrinter {

	public static void main(String[] args) {
		printLine();
		printLine(15);
		printLine(10);
		printLine(25);
		int characterCount = 30;
		printLine(2 * 15, '$');
		// Method overloading example from println() function
		System.out.println('A');
		System.out.println(1);
		System.out.println(2.05f);
	}
	
	public static void printLine() {
		System.out.println("-----------------------------");
	}
	
	// Method Overloading - Polymorphism
	public static void printLine(int numberOfCharacters) {
		for (int i = 0; i < numberOfCharacters; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void printLine(int numberOfCharacters, char character) {
		for (int i = 0; i < numberOfCharacters; i++) {
			System.out.print(character);
		}
		System.out.println();
	}

}
