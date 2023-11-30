package Lesson4;
/*If forced to use the else statement learned in today's lesson I would just set up
a different value for the total cost and then use else to add 10 to it if pAmount was under 50
but that's a lot of extra lines, unlike this comment explaining it.
 */

import java.util.*;

public class L4E3 {
		public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter your total purchase amount");
				double pAmount = input.nextDouble();
				if (pAmount < 50) {   //Lesson4.L4E3 says under 50 so assuming equal to 50 has no fee
						pAmount = pAmount + 10;
				}
				System.out.println("Your total including shipping is: " + pAmount);
				input.close();
		}
}
