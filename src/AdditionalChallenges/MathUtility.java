package AdditionalChallenges;

import java.util.Scanner;
import java.util.Random;

public class MathUtility {
		//calculate minimum array number
		public static int findMin(int[] num) {
				//checking for empty array
				if (num.length == 0) {
						throw new IllegalArgumentException("Array is empty, cannot find its minimum value");
				}
				int min = num[0];
				for (int i = 1; i < num.length; i++) {
						if (min > num[i]) {
								min = num[i];
						}
				}
				return min;
		}

		//calculate maximum array number
		public static int findMax(int[] num) {
				//checking for empty array
				if (num.length == 0) {
						throw new IllegalArgumentException("Array is empty, cannot find its maximum value");
				}
				int max = num[0];
				for (int i = 1; i < num.length; i++) {
						if (max < num[i]) {
								max = num[i];
						}
				}
				return max;
		}

		//calculate random number within a given range
		public static int randNum(int min, int max) {
				Random random = new Random();
				return random.nextInt(max - min) + min;
		}

		//calculate factorial.Adjusted to check if a positive number was entered
		public static long factorialNum(int num) {
				if (num < 0) {
						throw new IllegalArgumentException("Factorial calculations only work on " +
										"numbers equal to or bigger than 0");
				}
				long fact = 1;
				do {
						fact = fact * num;
						num--;
				} while (num > 0);
				return fact;
		}

		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				//declaring menu choices
				int userChoice;
				int userContinue;
				//Setting up secondary menu in case the user wishes to stop after the first calculation
				do {
						//Setting up main menu loop
						do {
								System.out.printf("What do you wish to do: %n1.Calculate Factorial%n2" +
												".Generate random numbers%n3.Find array mix/max%n4.Quit%n");
								userChoice = input.nextInt();
								if (userChoice == 3) {
										System.out.printf("Would you like to get:%n1.Min%n2.Max%n");
										int userChoice2 = input.nextInt();
										input.nextLine();
										System.out.printf("How long is the array?(Enter a number bigger than 0)%n");
										int length = input.nextInt();
										input.nextLine();
										int[] array = new int[length];
										//Filling array
										System.out.printf("Please populate the area with numbers%n");
										for (int i = 0; i < length; i++) {
												array[i] = input.nextInt();
												input.nextLine();
												if (i == length - 1) {
														break;
												} else {
														System.out.printf("Enter the next number%n");
												}
										}
										//Checking for the user's secondary choice menu
										if (userChoice2 == 1) {
												System.out.printf("The minimum value in your array is %d%n", findMin(array));
										} else if (userChoice2 == 2) {
												System.out.printf("The maximum value in your array is %d%n", findMax(array));
										}
										//Shoots straight to secondary menu
										break;
								} else if (userChoice == 2) {
										//Getting the range from the user
										System.out.printf("Enter the minimum number for the range%n");
										int min = input.nextInt();
										input.nextLine();
										System.out.printf("Enter the maximum number for the range%n");
										int max = input.nextInt();
										input.nextLine();
										//Flagging error when the user enters a higher value for minimum instead of maximum
										if (min > max) throw new IllegalArgumentException("The minimum value needs to be lower than" +
														"the maximum");
										System.out.printf("Your random number is: %d%n", randNum(min, max));
										//Shoots straight to secondary menu
										break;
								} else if (userChoice == 1) {
										System.out.printf("Enter the number whose factorial you wish to calculate(Note: Number" +
														"has to be 0 or higher)%n");
										int userNum = input.nextInt();
										input.nextLine();
										System.out.printf("The factorial of %d is %d%n", userNum, factorialNum(userNum));
										//Shoots straight to secondary menu
										break;
								} else if (userChoice == 4) {
										System.out.printf("Goodbye!%n");
								}
								//Checks for incorrect inputs in the main menu
								else {
										System.out.printf("Please select an option from 1 to 4%n");
								}
								//Loop stops when the user selects the Quit option
						} while (userChoice != 4);
						//Skips secondary menu if the user selected Quit in the main menu
						if (userChoice == 4) break;
						//Start of secondary menu
						System.out.printf("Would you like to do another?%n1.Yes%n2.No%n");
						userContinue = input.nextInt();
						input.nextLine();
						if (userContinue == 2) {
								System.out.printf("Goodbye!%n");
						}
						//Secondary menu terminates if the user selects the Quit option
				} while (userContinue != 2);
		}
}
