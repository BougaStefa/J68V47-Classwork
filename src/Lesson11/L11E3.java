package Lesson11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L11E3 {
		public static void main(String[] args) {
				System.out.printf("The summary of the numbers in the file is: %d", sumNum());
		}

		public static int sumNum() {
				int sum = 0;
				try (BufferedReader in = new BufferedReader(new FileReader("numbers.txt"))) {
						String line;
						while ((line = in.readLine()) != null) {
								try {
										int num = Integer.parseInt(line);
										sum += num;
								} catch (NumberFormatException e) {
										System.out.println("Error parsing this integer from line: " + line);
								}
						}
				} catch (IOException e) {
						System.out.println("Error occurred writing to file: " + e.getMessage());
				}
				return sum;
		}
}
