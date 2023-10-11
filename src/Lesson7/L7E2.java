package Lesson7;
import java.util.*;
public class L7E2 {
    public static int calculateSum(int x,int y){
        int sum = x+y;
        return sum;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number");
        int num1 = input.nextInt();
        System.out.println("Enter the second number");
        int num2 = input.nextInt();
        int sum = calculateSum(num1,num2);
        System.out.println("The sum of " + num1 + " + " + num2 + " is " + sum);
    }
}
