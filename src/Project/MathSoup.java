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

		public String getValidUsername(Scanner scanner) {
				while (true) {
						String username = scanner.nextLine();
						String acceptedChars = "[^a-zA-Z0-9]";
						Pattern pattern = Pattern.compile(acceptedChars);
						if (pattern.matcher(username).find()) {
								System.out.println("Please enter a valid username");
						} else {
								return username;
						}
				}
		}

		public String getValidPassword(Scanner scanner, int minLength, int maxLength) {
				//Ensuring that a password of 9-20 characters is returned.
				while (true) {
						String password = scanner.nextLine();
						if (password.length() >= minLength && password.length() <= maxLength) {
								return password;
						} else {
								System.out.printf("Please make sure your password has at least %d characters and at most %d%n", minLength, maxLength);
						}
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
				System.out.printf("1.Yes%n2.No%n3.Exit%n");
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
		public static void storeAccountOld(String username, String password) {
				//Stores the newly created account to a .txt file with the same name and also stores the password on a new line
				String textName = username + ".txt";
				try (PrintWriter out = new PrintWriter(new FileWriter(textName))) {
						out.println("Username:" + username);
						out.println("Password:" + password);
				} catch (IOException e) {
						System.out.println("Error occurred saving account" + e.getMessage());
				}
		}


		public void createAccount(Scanner scanner) {
				boolean accountCreated = false;
				System.out.println("Please enter your username(No special characters allowed): ");
				while (!accountCreated) {
						String username = getValidUsername(scanner);
						if (checkAccountExist(username)) {
								System.out.println("An account with this username already exists.Try again.");
						} else {
								accountCreated = true;
								System.out.println("Please enter a password(9-20 characters long)");
								String password = getValidPassword(scanner, 9, 20);
								storeAccount(username, password);
								System.out.println("Account created successfully");
						}
				}
		}

		private void storeAccount(String username, String password) {
				//Stores the newly created account to a .txt file with the same name and also stores the password on a new line
				String textName = username + ".txt";
				try (PrintWriter out = new PrintWriter(new FileWriter(textName))) {
						out.println("Username:" + username);
						out.println("Password:" + password);
				} catch (IOException e) {
						System.out.println("Error occurred saving account" + e.getMessage());
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
				System.out.println("Welcome to MathSoup, do you have an account with us?");
				int choice = DisplayAccountExist(scanner);
				scanner.nextLine();
				switch (choice) {
						case MENU_YES:
								//LOGIN CODE GOES HERE
								break;
						case MENU_NO:
								createAccount(scanner);
								break;
						case MENU_EXIT_SMALL:
								System.out.println("Goodbye!");
								System.exit(0);
				}
		}


		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				MathSoup mathsoup = new MathSoup();
				mathsoup.runMathSoup(scanner);
		}
}
