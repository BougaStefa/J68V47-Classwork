package Lesson2;

import java.util.*;

public class L2E2 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.print("Provide the first number: ");
				int firstNum = input.nextInt();
				System.out.print("Provide the second number: ");
				int secondNum = input.nextInt();
				int addition = firstNum + secondNum;
				int subtraction = firstNum - secondNum;
				int multiplication = firstNum * secondNum;
				int division = firstNum / secondNum;
				int modulo = firstNum % secondNum;
				int exponent = (int) Math.pow(firstNum, secondNum);
				System.out.println(firstNum + "+" + secondNum + "=" + addition);
				System.out.println(firstNum + "-" + secondNum + "=" + subtraction);
				System.out.println(firstNum + "*" + secondNum + "=" + multiplication);
				System.out.println(firstNum + "/" + secondNum + "=" + division);
				System.out.println(firstNum + "%" + secondNum + "=" + modulo);
				System.out.println(firstNum + "^" + secondNum + "=" + exponent);
				input.close();
		}
}
