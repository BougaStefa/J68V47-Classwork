package Lesson5;
import java.util.*;
public class L5E3 {
    public static void main(String[] args)
    {
        Scanner input   =   new Scanner(System.in);
        int score       =   0;
        for(int size    =   1;  size<=10;   size++)
        {
            System.out.println("Question "   +   size    +   "\nWhat is "  +   69  +   "x" +   size  +   "\n");
            int answer  =   input.nextInt();
            if(answer   ==   69*size)
            {
                score++;
            }
        }
        System.out.println("Congratulations you got "    +   score   +   " questions right!!");
    }
}
