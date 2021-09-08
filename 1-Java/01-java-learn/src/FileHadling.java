import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHadling {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		FileReader reader = new FileReader("D:\\ashu.txt.txt");
		int ch = reader.read();
		while (ch != -1) {
			System.out.println((char) ch);
			ch = reader.read();
		}
		reader.close();

	}

}
