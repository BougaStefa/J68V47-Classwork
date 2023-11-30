package Lesson4;

import java.util.*;

public class L4E4b {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the % of the student's test score");
				int score = input.nextInt();
				if (score >= 70) {
						System.out.println("Congratulations, you got an A");
				} else if (score >= 60) {
						System.out.println("Congratulations, you got a B");
				} else if (score >= 50) {
						System.out.println("Congratulation, you got a C");
				} else if (score >= 40) {
						System.out.println("Congratulations, you got a D");
				} else {
						System.out.println("Sorry, you get no award");
				}
				input.close();
		}
}
