package Lesson2;

import java.util.*;
public class L2E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the first item");
        String  item1   =   input.nextLine();
        System.out.println("Enter the name of the second item");
        String  item2   =   input.nextLine();
        System.out.println("Enter the name of the third item");
        String  item3   =   input.nextLine();
        System.out.println("Enter the price of the first item");
        float   price1  = input.nextFloat();
        System.out.println("Enter the price of the second item");
        float   price2  = input.nextFloat();
        System.out.println("Enter the price of the third item");
        float   price3  = input.nextFloat();
        float   subtotal    =   price1  +   price2  +   price3;
        System.out.println("NESMART");
        System.out.print(item1);
        System.out.format("......... £ %.2f %n",price1);
        System.out.print(item2);
        System.out.format("......... £ %.2f %n",price2);
        System.out.print(item3);
        System.out.format("......... £ %.2f %n",price3);
        System.out.print("Subtotal");
        System.out.format("......... £ %.2f %n",subtotal);
    }
}
