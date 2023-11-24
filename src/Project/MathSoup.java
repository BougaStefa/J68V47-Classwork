package Project;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MathSoup {
		//CONSTANTS FOR CLARITY
		final int MENU_GOAL_LOSE = 1;
		final int MENU_GOAL_MAINTAIN = 2;
		final int MENU_GOAL_GAIN = 3;
		final int MENU_PACE_SLOW = 1;
		final int MENU_PACE_NORMAL = 2;
		final int MENU_PACE_FAST = 3;
		final int MENU_SEX_MALE = 1;
		final int MENU_SEX_FEMALE = 2;
		final int MENU_ACTIVITY_SEDENTARY = 1;
		final int MENU_ACTIVITY_LIGHT = 2;
		final int MENU_ACTIVITY_MODERATE = 3;
		final int MENU_ACTIVITY_ACTIVE = 4;
		final int MENU_ACTIVITY_VERY_ACTIVE = 5;
		final int MENU_EXIT = 4;
		final int MENU_EXIT_BIG = 6;
		final int MENU_EXIT_SMALL = 3;
		final int MENU_YES = 1;
		final int MENU_NO = 2;

		//INPUT VALIDATION
		public static int getValidNumber(Scanner scanner, int min, int max) {
				int number;
				while (true) {
						try {
								number = scanner.nextInt();
								if (number >= min && number <= max) {
										return number;
								} else {
										System.out.println("Invalid number. Please try again.");
								}
						} catch (java.util.InputMismatchException e) {
								System.out.println("Please enter a valid number");
								scanner.nextLine();//clear input
						}

				}
		}

		public static int getValidWeight(Scanner scanner) {
				System.out.println("Please enter your current weight in Kilograms");
				return getValidNumber(scanner, 30, 500);
		}

		public static int getValidHeight(Scanner scanner) {
				System.out.println("Please enter your current height in Centimeters");
				return getValidNumber(scanner, 55, 251);
		}

		public static int getValidAge(Scanner scanner) {
				System.out.println("Please enter your current age(ONLY USERS OVER 18 ALLOWED)");
				return getValidNumber(scanner, 18, 116);
		}

		public static boolean getValidUsername(String username) {
				//acceptedChars includes everything that is NOT a-zA-Z0-9
				String acceptedChars = "[^a-zA-Z0-9]";
				Pattern pattern = Pattern.compile(acceptedChars);
				//If anything matching is found it returns true meaning there's a special character
				return pattern.matcher(username).find();
		}

		public String getUsername(Scanner scanner) {
				while (true) {
						String username = scanner.nextLine();
						if (getValidUsername(username)) {
								System.out.println("Please enter a valid username");
						} else {
								return username;
						}
				}
		}

		public boolean getSpecificLengthString(String input, int length) {
				return input.length() == length;
		}

		public String getPassword(Scanner scanner) {
				String password = scanner.nextLine();
				if (getSpecificLengthString(password, 9)) {
						return password;
				} else {
						System.out.println("");
				}
		}
		//INPUT VALIDATION END

		//MENUS
		public int DisplayGoalMenu(Scanner scanner) {
				System.out.printf("What do you wish to do:%n1.Lose Weight%n2.Maintain Weight%n3.Gain Weight%n4.Exit%n");
				int choice = getValidNumber(scanner, 1, 4);
				return switch (choice) {
						case MENU_GOAL_LOSE -> 1;
						case MENU_GOAL_MAINTAIN -> 2;
						case MENU_GOAL_GAIN -> 3;
						case MENU_EXIT -> {
								System.out.println("Goodbye!");
								System.exit(0);
								yield 0;
						}
						//Impossible scenario
						default -> 0;
				};
		}

		public int DisplayPaceMenu(Scanner scanner) {
				System.out.printf("Pick your own pace:%n1.Slowly(0.25kg per week)%n2.Normal(0.5kg per week)%n" +
								"3.Fast(1kg per week)%n4.Exit%n");
				int choice = getValidNumber(scanner, 1, 4);
				return switch (choice) {
						/*Numbers returned here are the calories in 0.25,0.5 and 1kg respectively*/
						case MENU_PACE_SLOW -> 1925;
						case MENU_PACE_NORMAL -> 3850;
						case MENU_PACE_FAST -> 7700;
						case MENU_EXIT -> {
								System.out.println("Goodbye!");
								System.exit(0);
								yield 0;
						}
						//Impossible scenario
						default -> 0;
				};
		}

		public int DisplaySexMenu(Scanner scanner) {
				System.out.printf("What is your birth sex?%n1.Male%n2.Female%n3.Exit%n");
				int choice = getValidNumber(scanner, 1, 3);
				return switch (choice) {
						case MENU_SEX_MALE -> 1;
						case MENU_SEX_FEMALE -> 2;
						case MENU_EXIT_SMALL -> {
								System.out.println("Goodbye!");
								System.exit(0);
								yield 0;
						}
						//Impossible scenario
						default -> 0;
				};
		}

		public double DisplayActivityMenu(Scanner scanner) {
				System.out.printf("What is your current activity level?%n1.Sedentary%n2.Lightly Active%n" +
								"3.Moderately Active%n4.Active%n5.Very Active%n6.Exit%n");
				int choice = getValidNumber(scanner, 1, 6);
				/* AFTER ENSURING A VALID OPTION IS PICKED WE RETURN THE ACTIVITY COEFFICIENT */
				return switch (choice) {
						case MENU_ACTIVITY_SEDENTARY -> 1.2;
						case MENU_ACTIVITY_LIGHT -> 1.375;
						case MENU_ACTIVITY_MODERATE -> 1.55;
						case MENU_ACTIVITY_ACTIVE -> 1.725;
						case MENU_ACTIVITY_VERY_ACTIVE -> 1.9;
						case MENU_EXIT_BIG -> {
								System.out.println("Goodbye!");
								System.exit(0);
								yield 0;
						}
						//Impossible scenario
						default -> 0;
				};
		}

		public int DisplayAccountExist(Scanner scanner) {
				System.out.println("Do you already have an account?");
				int choice = getValidNumber(scanner, 1, 3);
				return switch (choice) {
						case MENU_YES -> 1;
						case MENU_NO -> 2;
						case MENU_EXIT_SMALL -> {
								System.out.println("Goodbye!");
								System.exit(0);
								yield 0;
						}
						//Impossible scenario
						default -> 0;
				};
		}


		//MENUS END
//CALORIC CALCULATION
		public double caloricMaintenance(int sex, int weight, int height, int age, double activity) {
				double calories;
				if (sex == 1) {
						calories = ((10 * weight) + (6.25 * height) - (5 * age) + 5) * activity;
				} else {
						calories = ((10 * weight) + (6.25 * height) - (5 * age) - 161) * activity;
				}
				return calories;
		}


		//CALORIC CALCULATIONS END
		//USER ACCOUNTS
		public void createUsername(String username, Scanner scanner) {
				while (true) {
						if (!checkAccountExist(username)) {
								try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt"))) {
										out.println("Username:" + username);
										System.out.println("Account created successfully!");
								} catch (IOException e) {
										System.out.println("Error occured writing to file: " + e.getMessage());
								}
								break;
						} else {
								System.out.println("That username already exists.");
								username = getUsername(scanner);
						}
				}
		}

		public boolean checkAccountExist(String username) {
				String accountFile = username + ".txt";
				//Created file object with the naming scheme username.txt
				File file = new File(accountFile);
				//If it returns false the file does not exist meaning the account does not exist
				//Returning true means it exists
				return file.exists() && !file.isDirectory();
		}


		//MAIN
		public void runMathSoup(Scanner scanner) {
				System.out.println("Please create a username" + "\n" + "NOTE:No special characters allowed");
				String username = getUsername(scanner);
				createUsername(username, scanner);

		}

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				MathSoup mathsoup = new MathSoup();
				mathsoup.runMathSoup(scanner);
		}
}
