package Lesson4;

import java.util.*;

public class L4E2 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("What is the capital of Spain");
				String answer1 = input.nextLine().toUpperCase();
				if (!answer1.equals("MADRID")) {
						System.out.println("Sorry, the correct answer is Madrid");
				}
				System.out.println("What is the capital of the UK");
				String answer2 = input.nextLine().toUpperCase();
				if (!answer2.equals("LONDON")) {
						System.out.println("Sorry, the correct answer is London");
				}
				System.out.println("What is the capital of Italy");
				String answer3 = input.nextLine().toUpperCase();
				if (!answer3.equals("ROME")) {
						System.out.println("Sorry, the correct answer is Rome");
				}
		}
}
