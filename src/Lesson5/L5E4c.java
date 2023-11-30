package Lesson5;

import java.util.*;

public class L5E4c {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the number for the pattern");
				int pat = input.nextInt();
				System.out.println("Enter the length of the pattern");
				int leng = input.nextInt();
				for (int i = 0; i < leng; i++) {
						System.out.print("*" + pat + "*.");

				}
				input.close();
		}
}

