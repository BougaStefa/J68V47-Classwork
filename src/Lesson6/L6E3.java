package Lesson6;

import java.util.Random;
import java.util.Scanner;

public class L6E3 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				Random random = new Random();
				int score = 0;
				int lives = 3;
				int qs = 1;
				while (lives > 0 && qs <= 10) {
						int rand = random.nextInt(420);
						int rand2 = random.nextInt(69);
						int ans = rand * rand2;
						System.out.println("Question " + qs + "\nWhat is " + rand + "x" + rand2 + "\n");
						int userAns = input.nextInt();
						if (ans == userAns) {
								score++;
						} else {
								lives--;
						}
						qs++;
				}
				if (lives > 0) {
						System.out.println("Well done, you got " + score + " out of 10 correct!");
				}
				input.close();
		}
}