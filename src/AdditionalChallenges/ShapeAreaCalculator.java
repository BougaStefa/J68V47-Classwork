package AdditionalChallenges;

import java.util.Scanner;

public class ShapeAreaCalculator {
		public static double circleArea(double r) {
				return Math.PI * Math.pow(r, 2);
		}

		public static double squareArea(double side) {
				return Math.pow(side, 2);
		}

		public static double triangleArea(double b, double h) {
				return (b * h) / 2;
		}

		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				String shape;
				do {
						System.out.println("Enter the type of shape whose area you wish to calculate");
						shape = input.nextLine().toUpperCase();
						//testing input via Strings instead of an int menu, used menu in the previous exercise
						if (shape.equals("CIRCLE")) {
								System.out.println("Provide the circle's radious in cm");
								double rad = input.nextDouble();
								double area = circleArea(rad);
								// squared symbol
								System.out.printf("Circle's area is %5.2f cm\u00B2%n", area);
						} else if (shape.equals("SQUARE")) {
								System.out.println("Provide the side's length in cm");
								double side = input.nextDouble();
								double area = squareArea(side);
								System.out.printf("Square's area is %5.2f cm\u00B2%n", area);
						} else if (shape.equals("TRIANGLE")) {
								System.out.println("Provide the triangle's base length in cm");
								double base = input.nextDouble();
								System.out.println("Provide the triangle's height length in cm");
								double height = input.nextDouble();
								double area = triangleArea(base, height);
								System.out.printf("Triangle's area is %5.2f cm\u00B2%n", area);
						} else {
								//wrong input check
								System.out.println("Invalid or Unsupported shape, check the spelling or try a different shape");
						}
						// Will keep running until you enter the correct values once
				} while (!shape.equals("CIRCLE") && !shape.equals("SQUARE") && !shape.equals("TRIANGLE"));
				input.close();
		}
}
