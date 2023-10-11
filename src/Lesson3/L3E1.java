package Lesson3;

import java.util.*;

public class L3E1 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter your first name");
				String firstName = input.nextLine();
				System.out.println("Enter your last name");
				String lastName = input.nextLine();
				System.out.println("Enter your date of birth");
				int dob = input.nextInt();
				System.out.println("Your username is :" + firstName.substring(0, 1) + lastName.toLowerCase());
				System.out.println("Your password is :" + lastName.substring(0, 1).toLowerCase() + firstName.substring(0, 3).toUpperCase() + dob);
		}
}
