package Lesson5;

import java.util.*;

public class L5E4b {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				Random random = new Random();
				int corNum = random.nextInt();
				String result = "";
				for (int count = 0; count < 5; count++) {
						System.out.println("Guess the number");
						int guess = input.nextInt();
						if (guess == corNum) {
								result = "Correct!!";
								count = 5;
						} else {
								result = "Wrong!!";

						}
				}
				System.out.println(result);
				input.close();
		}
}

