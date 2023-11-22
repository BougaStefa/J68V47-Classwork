package Lesson11;

import java.io.*;
import java.util.Scanner;

public class L11E1 {
		public static void main(String[] args) {
				int choice;
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please provide a number from 1 to 9");
				choice = getValidNumber(scanner, 1, 9);
				saveTtimesTable(choice);
				scanner.close();
		}

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

		public static void saveTtimesTable(int number) {
				//not using append mode for the purposes of this exercise!
				try {
						PrintWriter out = new PrintWriter(new FileWriter("TimesTable.txt"));
						for (int i = 1; i <= 12; i++) {
								out.println(number + " x " + i + " = " + number * i);
						}
						out.close();
				} catch (IOException e) {
						System.out.println("Error occurred writing to file: " + e);
				}
		}
}



