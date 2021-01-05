/* Alexis Arellano Tuesday Oct 20/2020 */

package count.characters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Count {
	
	private Scanner file;
	ArrayList<String> words = new ArrayList<String>();
	char[] alphabet = {'A','a','B','b','C','c','D','d','E','e','F','f',
				'G','g','H','h','I','i','J','j','K','k','L','l','M','m',
				'N','n','O','o','P','p','Q','q','R','r','S','s','T','t',
				'U','u','V','v','W','w','X','x','Y','y','Z','z'};
	
	int[] letterCount = new int[alphabet.length];
	
	public void open(String fileName) {
		try {
			File readFile = new File(fileName);
			
			// scanner for ReadFile
			file = new Scanner(readFile);

		}
		catch (IOException ioexception) {
			System.err.println("Error: Cannot open file.");
		}
	}
	
	public void read() {
		while(file.hasNext()) {
			words.add(file.next());
		}
	}
	
	public void close() {
		file.close();
	}
	
	public void countLetters() {
		
		
		for (int i = 0; i < alphabet.length; i++) {
			for (int j = 0; j < words.size(); j++) {
				for (int k = 0; k < words.get(j).length(); k++) {
					if(alphabet[i] == words.get(j).charAt(k)) {
						letterCount[i]++;
					}
				}
			}
		}
		
	}
	
	public void display() {
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println(alphabet[i] + " : " + letterCount[i]);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a filename: ");
		Scanner input = new Scanner(System.in);
		
		String fileName = input.next();
		Count count = new Count();
		count.open(fileName);
		
		count.read();
		count.countLetters();
		count.display();
		count.close();
		
	}
}
