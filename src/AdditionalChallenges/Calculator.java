package AdditionalChallenges;

import java.util.Scanner;

public class Calculator {
		public static double addition(double x, double y) {
				return x + y;
		}

		public static double subtraction(double x, double y) {
				return x - y;
		}

		public static double multiplication(double x, double y) {
				return x * y;
		}

		public static double division(double x, double y) {
				return x / y;
		}

		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter the first number: ");
				double num1 = input.nextDouble();
				System.out.print("Enter the second number: ");
				double num2 = input.nextDouble();
				System.out.print("Enter the operation you wish to perform.(+,-,*,/)");
				char operator = input.next().charAt(0);
				input.close();
				double result = 0;
				if (operator == '+') {
						result = addition(num1, num2);
				} else if (operator == '-') {
						result = subtraction(num1, num2);
				} else if (operator == '*') {
						result = multiplication(num1, num2);
				} else if (operator == '/') {
						if (num2 == 0) {
								System.out.println("You cannot divide by 0");
						} else {
								result = division(num1, num2);
						}
				} else {
						System.out.println("Invalid operator, try again");
						//Just using return here to avoid printing the result in case of an invalid operator
						return;
				}
				System.out.println("The result is: " + result);
		}
}
