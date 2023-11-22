package Lesson11;

import java.io.*;

public class L11E2 {
		public static void main(String[] args) {
				readWholeFile();
		}

		public static void readWholeFile() {
				try (BufferedReader in = new BufferedReader(new FileReader("TimesTable.txt"))) {
						String line;
						while ((line = in.readLine()) != null) {
								System.out.println(line);
						}
				} catch (IOException e) {
						System.out.println("Error occurred writing to file: " + e);
				}


		}
}
