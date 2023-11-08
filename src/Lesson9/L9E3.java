package Lesson9;

import java.util.Scanner;

public class L9E3 {

		public static int askQuestion(int number1, int number2, boolean[] errorFlag) {
				Scanner scanner = new Scanner(System.in);
				System.out.format("What is %d + %d? ", number1, number2);
				//initializing values
				int userAnswer = 0;
				boolean validInput = false;
				while (!validInput) {
						try {
								//Accepting values as strings in order to check for blank spaces and empty strings
								String input = scanner.nextLine().trim();
								//Trimming out all white spaces
								if (input.isEmpty()) {
										System.out.println("No input detected");
										//Adding error flags for later
										errorFlag[0] = true;
								} else {
										//Taking the inputs as ints
										userAnswer = Integer.parseInt(input);
										validInput = true;
								}
								//non number entries catch
						} catch (NumberFormatException e) {
								System.out.println("No valid number");
								//Adding error flags for later
								errorFlag[1] = true;
						}

				}
				return userAnswer;
		}


		public static int correctAnswer(int score) {
				System.out.println("CORRECT!");
				score++;
				return score;
		}

		public static int wrongAnswer(int answer, int lives) {
				System.out.format("WRONG! The answer is %d %n", answer);
				lives--;
				System.out.format("You have %d lives left. %n", lives);
				return lives;
		}

		public static void gameOver(int score, int lives) {
				System.out.format("GAME OVER. Your final score is %d %n", score);
				if (lives > 0) {
						System.out.println("Well done!");
				}
		}

		public static void main(String[] args) {
				int score = 0;
				int lives = 3;
				int userAnswer;
				int answer;
				int count = 1;
				boolean[] errorFlag = new boolean[2];
				while (count <= 10 && lives > 0) {
						userAnswer = askQuestion(count, count * count, errorFlag);
						answer = count + (count * count);
						if (answer == userAnswer) {
								score = correctAnswer(score);
						} else {
								lives = wrongAnswer(answer, lives);
						}
						count++;
				}
				gameOver(score, lives);
				//Highlighting the fact that errors occurred at the end
				if (errorFlag[0]) {
						System.out.println("Empty entries were detected");
				}
				if (errorFlag[1]) {
						System.out.println("Wrong inputs were detected");
				}

		}
}