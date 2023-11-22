package Lesson11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L11E3 {
		public static void main(String[] args) {
				System.out.printf("The summary of the numbers in the file is: %f", sumNum());
		}

		public static double sumNum() {
				double sum = 0;
				try (BufferedReader in = new BufferedReader(new FileReader("numbers.txt"))) {
						String line;
						while ((line = in.readLine()) != null) {
								double num = Double.parseDouble(in.readLine());
								sum += num;
						}
				} catch (IOException e) {
						System.out.println("Error occurred writing to file: " + e.getMessage());
				}
				return sum;
		}
}
