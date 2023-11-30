package Lesson4;

import java.util.*;

public class L4E1 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter your first name");
				String fName = input.nextLine();
				System.out.println("Enter yur last name");
				String lName = input.nextLine();
				System.out.println("Enter the total value of your order");
				double oValue = input.nextDouble();
				System.out.println("Enter the amount you wish to pay as deposit");
				double deposit = input.nextDouble();
				System.out.println(fName.substring(0, 1).toUpperCase() + " "
								+ lName.substring(0, 1).toUpperCase() + lName.substring(1));
				// Capitalising the first letter of the name , just looks better
				System.out.println("Order Total: " + oValue);
				System.out.println("Deposit Paid: " + deposit);
				System.out.println("Remainder: " + (oValue - deposit));
				if (deposit > 150) {
						System.out.println("You get a free toaster!");
				}
				System.out.println("Have a nice day");
				input.close();
		}
}
