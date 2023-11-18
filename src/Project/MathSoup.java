package Project;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MathSoup {
		//Menu constants for clarity
		final int MENU_GOAL_LOSE = 1;
		final int MENU_GOAL_MAINTAIN = 2;
		final int MENU_GOAL_GAIN = 3;
		final int MENU_PACE_SLOW = 1;
		final int MENU_PACE_NORMAL = 2;
		final int MENU_PACE_FAST = 3;
		final int MENU_QUIT = 4;

		//Subroutine to ensure a valid number is entered
		public static int getValidNumber(Scanner scanner, int min, int max) {
				int number;
				while (true) {
						try {
								number = scanner.nextInt();
								if (number >= min && number <= max) {
										return number;
								} else {
										System.out.println("Invalid option, please pick one from within the specified range");
								}
						} catch (NumberFormatException e) {
								System.out.println("Please enter a valid number");
								scanner.next();//clear input
						}

				}
		}


		public int DisplayGoalMenu(Scanner scanner) {
				System.out.printf("What do you wish to do:%n1.Lose Weight%n2.Maintain Weight%n3.Gain Weight%n4.Quit");
				return getValidNumber(scanner, 1, 4);
		}

		public int DisplayPaceMenu(Scanner scanner) {
				System.out.printf("What do you wish to do:%n1.Slowly(0.25kg per week)%n2.Normal(0.5kg per week)%n3.Fast(1kg per week)%n4.Quit");
				return getValidNumber(scanner, 1, 4);
		}

		public int caloricMaintenance(int sex, int weight, int height, int age) {
				int calories;
				if (sex == 1) {
						calories = (int) ((10 * weight) + (6.25 * height) - (5 * age) + 5);
				} else {
						calories = (int) ((10 * weight) + (6.25 * height) - (5 * age) - 161);
				}
				return calories;
		}

		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
		}
}
