//accidentally did extra challenges A plus E3 in one as I'd set up my random gen in L6
package Lesson7;

import java.util.*;

public class L7E3 {
		public static int askQuestion(int rand1, int rand2,Scanner scanner) {
				System.out.println("What is " + rand1 + " + " + rand2 + " ?");
				int input = scanner.nextInt();
				return input;
		}

		public static int correctAnswer(int score) {
				System.out.println("Correct!");
				score++;
				return score;
		}

		public static int wrongAnswer(int lives, int answer) {
				System.out.println("Wrong! The answer is " + answer);
				lives--;
				System.out.println("You have " + lives + " lives left");
				return lives;
		}

		public static void gameOver(int score, int lives) {
				System.out.println("Game over, your score is " + score);
				if (lives > 0) {
						System.out.print("Well done!");
				}
		}

		public static void main(String[] args) {
				Random random = new Random();
				Scanner scanner = new Scanner(System.in);
				int score = 0;
				int lives = 3;
				int userAnswer;
				int rightAnswer;
				int count = 1;
				while (count <= 10 && lives > 0) {
						int num1 = random.nextInt(420);
						int num2 = random.nextInt(69);
						userAnswer = askQuestion(num1, num2,scanner);
						rightAnswer = num1 + num2;
						if (userAnswer == rightAnswer) {
								score = correctAnswer(score);
						} else {
								lives = wrongAnswer(lives, rightAnswer);
						}
						count++;
				}
				gameOver(score, lives);
		}
}
