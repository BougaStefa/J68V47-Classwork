package Lesson3;

import java.util.*;
public class L3E3 {
    public static void main(String[] args) {
        Scanner input   =   new Scanner(System.in);
        System.out.println("Enter the cost of the load");
        float loan        = input.nextFloat();
        System.out.println("Enter the interest rate");
        float interest    = input.nextFloat();
        System.out.println("Enter the number of years for the load");
        float yrs         = input.nextFloat();
        float j           = (interest/100)/12;
        float n           = yrs*12;
        float mPay        = (float) (loan*(j/(1-Math.pow(1+j,-n))));
        System.out.format("Monthly Payment is: £ %.2f " , mPay);
    }
}
