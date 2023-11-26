package Project;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MathSoup {
		private static final int MENU_GOAL_LOSE = 1;
		private static final int MENU_GOAL_MAINTAIN = 2;
		private static final int MENU_GOAL_GAIN = 3;
		private static final int MENU_PACE_SLOW = 1;
		private static final int MENU_PACE_NORMAL = 2;
		private static final int MENU_PACE_FAST = 3;
		private static final int MENU_SEX_MALE = 1;
		private static final int MENU_SEX_FEMALE = 2;
		private static final int MENU_ACTIVITY_SEDENTARY = 1;
		private static final int MENU_ACTIVITY_LIGHT = 2;
		private static final int MENU_ACTIVITY_MODERATE = 3;
		private static final int MENU_ACTIVITY_ACTIVE = 4;
		private static final int MENU_ACTIVITY_VERY_ACTIVE = 5;
		private static final int MENU_EXIT = 4;
		private static final int MENU_EXIT_BIG = 6;
		private static final int MENU_EXIT_SMALL = 3;
		private static final int MENU_YES = 1;
		private static final int MENU_NO = 2;

		private double maintenanceCalories;
		private String currentUsername;

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
								scanner.nextLine(); // clear input
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
				while (true) {
						String password = scanner.nextLine();
						if (password.length() >= minLength && password.length() <= maxLength) {
								return password;
						} else {
								System.out.printf("Please make sure your password has at least %d characters and at most %d%n",
												minLength, maxLength);
						}
				}
		}

		public int displayGoalMenu(Scanner scanner) {
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
						default -> 0;
				};
		}

		public int displayPaceMenu(Scanner scanner) {
				System.out.printf("Pick your own pace:%n1.Slowly(0.25kg per week)%n2.Normal(0.5kg per week)%n" +
								"3.Fast(1kg per week)%n");
				int choice = getValidNumber(scanner, 1, 3);
				return switch (choice) {
						case MENU_PACE_SLOW -> 1925;
						case MENU_PACE_NORMAL -> 3850;
						case MENU_PACE_FAST -> 7700;
						default -> 0;
				};
		}

		public int displaySexMenu(Scanner scanner) {
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
						default -> 0;
				};
		}

		public double displayActivityMenu(Scanner scanner) {
				System.out.printf("What is your current activity level?%n1.Sedentary%n2.Lightly Active%n" +
								"3.Moderately Active%n4.Active%n5.Very Active%n6.Exit%n");
				int choice = getValidNumber(scanner, 1, 6);
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
						default -> 0;
				};
		}

		public int displayAccountExist(Scanner scanner) {
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
						default -> 0;
				};
		}

		public double caloricMaintenance(int sex, int weight, int height, int age, double activity) {
				double calories;
				if (sex == 1) {
						calories = ((10 * weight) + (6.25 * height) - (5 * age) + 5) * activity;
				} else {
						calories = ((10 * weight) + (6.25 * height) - (5 * age) - 161) * activity;
				}
				return calories;
		}

		public void initialMessage(Scanner scanner) {
				System.out.println("Welcome! Let us proceed with your initial calorie recommendation. Please answer" +
								"the following questions: ");
				maintenanceCalories = caloricMaintenance(displaySexMenu(scanner), getValidWeight(scanner),
								getValidHeight(scanner), getValidAge(scanner), displayActivityMenu(scanner));
				System.out.printf("Based on that information your daily maintenance calories are: %.0f%n",
								maintenanceCalories);
				scanner.nextLine();
		}

		public double caloriesBasedOnGoal(int goal, int pace, double maintenance) {
				switch (goal) {
						case MENU_GOAL_LOSE:
								return maintenance - pace / 7;
						case MENU_GOAL_MAINTAIN:
								return maintenance;
						case MENU_GOAL_GAIN:
								return maintenance + pace / 7;
						default:
								return 0;
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
								storeAccountToFile(username, password);
								System.out.println("Account created successfully");
								currentUsername = username;
						}
				}
		}

		private void storeAccountToFile(String username, String password) {
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
				File file = new File(accountFile);
				return file.exists() && !file.isDirectory();
		}

		public void storeGoalToFile(Scanner scanner, String username, double calories) {
				int goal = displayGoalMenu(scanner);
				switch (goal) {
						case MENU_GOAL_LOSE:
								try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt", true))) {
										out.println("Goal:Lose");
										out.println("Calories:" + Math.round(caloriesBasedOnGoal
														(goal, displayPaceMenu(scanner), maintenanceCalories)));
										System.out.println("Your preferences have been stored in your profile.");
								} catch (IOException e) {
										System.out.println("Error storing to file" + e.getMessage());
								}
								break;
						case MENU_GOAL_MAINTAIN:
								try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt", true))) {
										out.println("Goal:Maintain");
										out.println("Calories:" + Math.round(caloriesBasedOnGoal
														(goal, displayPaceMenu(scanner), maintenanceCalories)));
										System.out.println("Your preferences have been stored in your profile.");
								} catch (IOException e) {
										System.out.println("Error storing to file" + e.getMessage());
								}
								break;
						case MENU_GOAL_GAIN:
								try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt", true))) {
										out.println("Goal:Gain");
										out.println("Calories:" + Math.round(caloriesBasedOnGoal
														(goal, displayPaceMenu(scanner), maintenanceCalories)));
										System.out.println("Your preferences have been stored in your profile.");
								} catch (IOException e) {
										System.out.println("Error storing to file" + e.getMessage());
								}
								break;
						default:
								throw new IllegalStateException("Unexpected value: " + displayGoalMenu(scanner));
				}
		}

		public boolean login(Scanner scanner) {
				System.out.println("Please enter your username");
				while (true) {
						String username = getValidUsername(scanner);
						String accountFile = username + ".txt";
						if (checkAccountExist(username)) {
								try (BufferedReader in = new BufferedReader(new FileReader(accountFile))) {
										String line;
										while ((line = in.readLine()) != null) {
												if (line.startsWith("Password:")) {
														System.out.println("Enter your password:");
														String password = scanner.nextLine();
														if (line.substring(9).equals(password)) {
																System.out.println("Login successful!");
																currentUsername = username;
																return true;
														} else {
																System.out.println("Incorrect password.");
																return false;
														}
												}
										}
								} catch (IOException e) {
										System.out.println("Error reading file: " + e.getMessage());
								}
						} else {
								System.out.println("An account with this username does not exist, please try again.");
						}
				}
		}

		public double caloriesTwoWeeks(Scanner scanner) {
				double totalCalories = 0;
				for (int i = 1; i <= 14; i++) {
						System.out.printf("How many calories did you consume on day %d%n", i);
						double calories = getValidNumber(scanner, 600, 8000);
						if (calories <= 1200) {
								System.out.println("Please note that this low a calorie intake can be a health risk");
						}
						totalCalories += calories;
				}

				return Math.round(totalCalories / 14);
		}

		public double recalibrationSequence(Scanner scanner) {
				System.out.println("Have you been collected weight and calorie data as instructed?");
				int choice = getValidNumber(scanner, 1, 2);
				switch (choice) {
						case MENU_YES:
								collectCalorieData();
								collectWeightData();
						case MENU_NO:
								System.out.println("Please collect weight and calorie data for the next 14 days and then come back");
								System.exit(0);
						default:
								//Impossible scenario
								System.out.println("Goodbye!");
								System.exit(0);
								return 0;
				}
		}

		public void readGoal(String username) {
				String goal = null;
				String calories = null;
				try (BufferedReader in = new BufferedReader(new FileReader(username + ".txt"))) {
						String line;
						while ((line = in.readLine()) != null) {
								if (line.startsWith("Goal:")) {
										goal = line.substring(5);
								}
								if (line.startsWith("Calories:")) {
										calories = line.substring(9);
								}
						}
				} catch (IOException e) {
						System.out.println("Error reading file: " + e.getMessage());
				}
				System.out.printf("Welcome %s. Hope your goal to %s weight by eating %s calories a day been going well!%n",
								username, goal, calories);
		}

		public void runMathSoup(Scanner scanner) {
				System.out.println("Welcome to MathSoup, do you have an account with us?");
				int choice = displayAccountExist(scanner);
				scanner.nextLine();
				switch (choice) {
						case MENU_YES:
								while (true) {
										if (login(scanner)) {
												readGoal(currentUsername);

												break;
										}

								}
								break;
						case MENU_NO:
								createAccount(scanner);
								initialMessage(scanner);
								storeGoalToFile(scanner, currentUsername, maintenanceCalories);
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
