package Lesson9;

import java.util.*;
import java.io.File;

public class L9E2 {

    public static void exception1() {
        // exception 1
        // divide by 0
        try {
            int exception1 = 10 / 0;
            System.out.println(exception1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void exception2() {
        // exception 2
        // Exceeding max value
        try {
            int exception2 = Integer.MAX_VALUE + 1;
            System.out.println(exception2);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void exception3() {
        // exception 3
        //out of bounds
        try {
            int[] myArray3 = new int[5];
            int exception3 = myArray3[5];
            System.out.println(exception3);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void exception4() {
        // exception 4
        // Cannot load from array as it is null
        try {
            int[] myArray4 = null;
            int exception4 = myArray4[0];
            System.out.println(exception4);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void exception5() {
        // exception 5
        //file cannot be found
        try {
            File exception5 = new File("exception5.txt");
            Scanner scanner = new Scanner(exception5);
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void exception6() {
        // exception 6
        // Number format exception
        try {
            String thisString = "Hello";
            int exception6 = Integer.parseInt(thisString);
            System.out.println(exception6);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void exception7() {
        // exception 7
        //Cannot execute toUpperCase on a null string
        try {
            String exception7 = null;
            System.out.println(exception7.toUpperCase());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        exception1();
        exception2();
        exception3();
        exception4();
        exception5();
        exception6();
        exception7();

    }
}