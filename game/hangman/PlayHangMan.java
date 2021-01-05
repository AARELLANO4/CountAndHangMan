/**********************************************
 * Workshop 4 
 * Course: JAC444 - WINTER 2020
 * Last Name: Arellano
 * First Name: Alexis
 * ID: 155816184
 * Section: NDD
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 *  - AA
 * Date: Tuesday October 20/2020
 * **********************************************/

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
