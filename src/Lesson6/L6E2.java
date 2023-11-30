package Lesson6;

import java.util.Scanner;
public class L6E2 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				int ans;
				do {
						System.out.println("""
										1.Say"Hello"
										2.Tell me the time
										3.Tell me a joke
										4.Quit""");
						//text block recommended, initially had \n but this looks cleaner
						ans = input.nextInt();
				} while (ans != 4);
				input.close();
		}
}
