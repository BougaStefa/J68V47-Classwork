import java.util.*;
public class Lesson2 {
    public static void main(String[] args) {
    Scanner input   =   new Scanner(System.in);
    System.out.print("What is your name? ");
    String  name    =   input.nextLine();
    System.out.print("What is your hobby? ");
    String  hobby   =   input.nextLine();
    System.out.println("Hello " + name + ", I heard that you are interested in " + hobby + ", how dull");
    }
}
