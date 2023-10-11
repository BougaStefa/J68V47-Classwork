package Lesson5;

import java.util.*;

public class L5E1 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter a number");
				int num = input.nextInt();
				for (int count = 1; count < 13; count++) {
						System.out.println(num + " x " + count + " = " + num * count);
				}
		}
}
