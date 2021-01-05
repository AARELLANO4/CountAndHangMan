/* Alexis Arellano Tuesday Oct 20/2020 */

package game.hangman;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadFiles {
	
	private Scanner fileName;
	ArrayList<String> words = new ArrayList<String>();
	String randomWord = "";
	
	public void open() {
		try {
			File file = new File("hangman.txt");
			
			// scanner for ReadFile
			fileName = new Scanner(file);
			

		}
		catch (IOException ioexception) {
			System.err.println("Error: Cannot open file.");
		}
	}
	
	public void readFile() {

		while(fileName.hasNextLine()) {
			words.add(fileName.next());
		}
	}
	
	public String generateWord() {
		Random random = new Random();
		int index = random.nextInt(words.size());
		randomWord = words.get(index);
		
		return randomWord;
	}
	
	public void close() {
		fileName.close();
	}
}
