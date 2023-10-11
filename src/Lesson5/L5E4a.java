package Lesson5;

import java.util.*;

public class L5E4a {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter a number");
				int n = input.nextInt();
				long fact = 1;
				for (int count = n; count >= 1; count--) {
						fact *= count;
				}
				System.out.println("The factorial of " + n + " is " + fact);
		}
}
