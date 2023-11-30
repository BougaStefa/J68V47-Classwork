package Lesson7;

import java.util.*;

public class L7E1 {
		public static void showMenu() {
				System.out.println("1.Say \"Hello!\"\n2.Tell me the time\n3.Tell me a joke\n4.Quit");
		}

		public static int getOption(Scanner scanner) {
				int option = scanner.nextInt();
				return option;
		}

		public static void optionResp(String message) {
				System.out.println(message);
		}

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int choice;
				do {
						showMenu();
						choice = getOption(scanner);
						if (choice == 1) {
								optionResp("Hello!");
						} else if (choice == 2) {
								optionResp("The time is x");
						} else if (choice == 3) {
								optionResp("Big funny joke haha");
						} else if (choice == 4) {
								optionResp("Bye!");
						} else {
								optionResp("Not a valid entry.Pick between 1 and 4");
						}
				} while (choice != 4);
			
		}
}

