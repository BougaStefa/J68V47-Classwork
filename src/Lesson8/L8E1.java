package Lesson8;
import java.util.Scanner;

public class L8E1 {
    public static void main(String[] args) {
        String[] names = new String[5];
        Scanner input = new Scanner(System.in);
        for(int i=0; i<=4; i++){
            System.out.println("Enter the name of student number " + (i+1));
            names[i] = input.nextLine();
        }
        System.out.printf("Out of %d students the first one is %s and the last one is %s",names.length,names[0],names[4]);
        input.close();
    }
}
