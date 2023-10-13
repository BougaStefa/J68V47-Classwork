package AdditionalChallenges;

import java.util.Scanner;

public class StringManipulation {
		//Setting up constants for the menu for clarity
		final int MENU_REVERSE_STRING = 1;
		final int MENU_PALINDROME_CHECK = 2;
		final int MENU_COUNT_VOWELS = 3;
		final int MENU_QUIT = 4;

		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				StringManipulation stringManipulation = new StringManipulation();
				stringManipulation.runManipulation(input);
		}

		//Subroutine to reverse the provided string
		public static void reverseString(Scanner input) {
				System.out.println("Enter a word");
				String userStringDirty = input.nextLine();
				//cleaning the string
				String userString = userStringDirty.replaceAll("[^a-zA-Z]", "");
				int length = userString.length();
				char array[] = new char[length];
				for (int i = 0; i < length; i++) {
						array[i] = userString.charAt(length - (i + 1));
						System.out.print(array[i]);
				}
				System.out.println("");//new line
		}

		public static void palindromeCheck(Scanner input) {
				System.out.println("Enter a word");
				//Removing anything that's not a letter
				String userStringDirty = input.nextLine();
				String userString = userStringDirty.replaceAll("[^a-zA-Z]", "").toUpperCase();
				int length = userString.length();
				char array[] = new char[length];
				for (int i = 0; i < length; i++) {
						array[i] = userString.charAt(i);
				}
				char yarra[] = new char[length];
				for (int i = 0; i < length; i++) {
						yarra[i] = userString.charAt(length - (i + 1));
				}
				for (int i = 0; i < length; i++) {
						if (array[i] != yarra[i]) {
								System.out.println("The string is not a palindrome");
								break;
						} else if (i == length - 1) System.out.println("The string is a palindrome!");
				}
		}

		public static void countVowels(Scanner input) {
				System.out.println("Enter a word/sentence");
				int count = 0;
				String userString = input.nextLine();
				int length = userString.length();
				for (int i = 0; i < length; i++) {
						char potentVowel = userString.charAt(i);
						if (potentVowel == 'a' || potentVowel == 'e' || potentVowel == 'i' || potentVowel == 'o'
										|| potentVowel == 'u') {
								count++;
						}
				}
				System.out.printf("There are %d vowels in your word/sentence%n", count);
		}

		//Subroutine that check the validity of the number provided
		public static int getValidNumber(Scanner input, int min, int max) {
				int choice;
				while (true) {
						if (input.hasNextInt()) {
								choice = input.nextInt();
								if (choice >= min && choice <= max) {
										input.nextLine();//clear input
										return choice;
								} else {
										System.out.println("Invalid option, please pick one from within the specified range");
								}
						} else {
								System.out.println("Please enter a number");
								input.next();//clear input
						}
				}
		}

		public int displayMainMenu(Scanner input) {
				int userChoice;
				do {
						System.out.printf("What do you wish to do: %n1.Reverse word%n2.Check if the word is a palindrome" +
										"%n3.Count the vowels of a word/sentence%n4.Quit%n");
						userChoice = getValidNumber(input, 1, 4);
				} while (userChoice < 1 || userChoice > 4);
				return userChoice;
		}

		public int displaySecondaryMenu(Scanner input) {
				int userContinue;
				do {
						System.out.printf("Do you want to do another?%n1. Yes%n2. No%n");
						userContinue = getValidNumber(input, 1, 2);
				} while (userContinue < 1 || userContinue > 2);
				return userContinue;
		}

		//Subroutine that runs the string manipulation program
		public void runManipulation(Scanner input) {
				int userChoice;
				int userContinue = 0;
				do {
						userChoice = displayMainMenu(input);
						switch (userChoice) {
								case MENU_REVERSE_STRING:
										reverseString(input);
										break;
								case MENU_PALINDROME_CHECK:
										palindromeCheck(input);
										break;
								case MENU_COUNT_VOWELS:
										countVowels(input);
										break;
								case MENU_QUIT:
										System.out.println("Goodbye!");
						}
						if (userChoice != MENU_QUIT) {
								userContinue = displaySecondaryMenu(input);
						}
				} while (userContinue != 2);
				System.out.println("Goodbye!");
		}


}
