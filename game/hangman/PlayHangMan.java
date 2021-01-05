/* Alexis Arellano Tuesday Oct 20/2020 */

package game.hangman;

import java.util.Scanner;

public class PlayHangMan {
	public static void main(String[] args) {
		ReadFiles r = new ReadFiles();
		r.open();
		r.readFile();
		r.close();
		
		Scanner input = new Scanner(System.in);
		String play = "y";
		
		while(play.equals("y")) {
			String text = r.generateWord();
			HangMan hangMan = new HangMan(text);
			hangMan.startGame();
			
			System.out.println("Do you want to play again? (y/n): ");
			String i = input.next();
			play = i;
		}
		
		System.out.println("Thanks for playing!");
		input.close();
	}
}
