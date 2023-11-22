package Lesson11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class L11E4 {
		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				//For testing the files are file1 and file2
				String first = ensureTextFile1(scanner);
				String second = ensureTextFile2(scanner);
				if (compareFiles(first, second)) {
						System.out.println("The files are identical");
				} else {
						System.out.println("The files are not identical");
				}
				scanner.close();
		}

		public static boolean compareFiles(String name1, String name2) {
				try (BufferedReader in1 = new BufferedReader(new FileReader(name1));
						 BufferedReader in2 = new BufferedReader(new FileReader(name2))) {
						String line1, line2;
						while ((line1 = in1.readLine()) != null && (line2 = in2.readLine()) != null) {
								//If the file comparison encounters a discrepancy it returns false
								if (!line1.equals(line2)) return false;
						}
						//Checks if both files had the same amount of lines
						//This way if a file happens to be identical up until the point that it ends it won't be shown as identical
						return in1.readLine() == null && in2.readLine() == null;
				} catch (IOException e) {
						System.out.println("Error occurred while comparing files: " + e);
						return false;
				}
		}

		//OPTIONAL FUNCTIONS checking if an actual text file was named as the input for more functional scenario with
		//multiple files and not just 2 example files
		public static String ensureTextFile1(Scanner scanner) {
				System.out.println("Please chose the first text file you wish to compare");
				while (true) {
						String userInput = scanner.nextLine();
						if (userInput.endsWith(".txt")) {
								return userInput;
						} else {
								System.out.printf("Please enter a valid text file name%nHINT: Include the .txt extension at the end%n");
						}
				}
		}

		public static String ensureTextFile2(Scanner scanner) {
				System.out.println("Please chose the second text file you wish to compare");
				while (true) {
						String userInput = scanner.nextLine();
						if (userInput.endsWith(".txt")) {
								return userInput;
						} else {
								System.out.printf("Please enter a valid text file name%nHINT: Include the .txt extension at the end%n");
						}
				}
		}
}