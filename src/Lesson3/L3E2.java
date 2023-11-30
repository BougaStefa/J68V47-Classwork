package Lesson3;

import java.util.*;

public class L3E2 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("What is the capital of Spain");
				String answer1 = input.nextLine().toUpperCase();
				System.out.println(answer1.contains("MADRID"));
				System.out.println("What is the capital of the UK");
				String answer2 = input.nextLine().toUpperCase();
				System.out.println(answer2.contains("LONDON"));
				System.out.println("What is the capital of Italy");
				String answer3 = input.nextLine().toUpperCase();
				System.out.println(answer3.contains("ROME"));
				input.close();
		}
}
