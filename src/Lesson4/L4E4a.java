package Lesson4;

import java.util.*;

public class L4E4a {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Guess the number");
				int guess = input.nextInt();
				int answer = 69;
				if (guess < answer) {
						System.out.println("Too low, go higher");
				} else if (guess > answer) { 
						System.out.println("Too high, go lower");
				} else {
						System.out.println("That is correct!");
				}
				input.close();
		}
}
