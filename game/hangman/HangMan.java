/* Alexis Arellano Tuesday Oct 20/2020 */

package game.hangman;

import java.util.Scanner;

public class HangMan {
	boolean isCorrect;
	int wordLength = 0;
	String word = "";
	
	public HangMan(String text) {
		this.word = text;
	}
	
	public String hideWord(String text) {
		String hidden = "";
		for (int i = 0; i < text.length(); i++) {
			hidden += '*';
		}
		return hidden;
	}
	
	public boolean letterCheck(String hidden, char c) {
		for (int i = 0; i < hidden.length(); i++) {
			if (c ==  hidden.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	public String guess(String word, String puzzle, char c) {
		isCorrect = false;
		
		StringBuilder s = new StringBuilder(puzzle);
		
		for (int i = 0; i < word.length(); i++) {
			if (c ==  word.charAt(i) && s.charAt(i) == '*') {
				isCorrect = true;
				s = s.deleteCharAt(i);
				s = s.insert(i, c);
			}
		}
		
		return s.toString();
	}
	
	public void startGame() {
		Scanner input = new Scanner(System.in);
		
		String hiddenWord = hideWord(word);
		int count = 0;
		
		while(!word.equals(hiddenWord)) {
			System.out.print("Enter a letter in word " + hiddenWord + " > ");
			char c = input.next().charAt(0);
				
			
			if (!letterCheck(hiddenWord, c)) {
				
				hiddenWord = guess(word, hiddenWord,c);
				
				if(isCorrect == false) {
					System.out.println(c + " is Incorrect.");
					count++;
					System.out.println("   Attempt number: " + count);
				}
				
			}
			else {
				System.out.println(c + " has already been guessed.");
			}
		}
			
		System.out.println("You win! You guessed " + hiddenWord + " correctly!");
		System.out.println("    Number of attempts: " + count);
		}
}


