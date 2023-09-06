//Take a name and a hobby, output a short story using them
import java.util.*;
public class L2E1 {
    public static void main(String[] args) {
    Scanner input   =   new Scanner(System.in);
    System.out.print("What is your name? ");
    String  name    =   input.nextLine();
    System.out.print("What is your hobby? ");
    String  hobby   =   input.nextLine();
    System.out.println("Hello " + name + ", I heard that you are interested in " + hobby + ", how dull");
    }
}
