import          java.util.*;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
public class    L4E4b {
    public static void main(String[] args) {
        Scanner input   =   new Scanner(System.in);
        System.out.println("Enter the % of the student's test score");
        int     score   = input.nextInt();
        if(score>=70){
            System.out.println(ansi().eraseScreen().fg(GREEN).a("Congratulations, you got an A"));
        }
        else if(score>=60){
            System.out.println(ansi().eraseScreen().fg(GREEN).a("Congratulations, you got a B"));
        }
        else if(score>=50){
            System.out.println(ansi().eraseScreen().fg(YELLOW).a("Congratulation, you got a C"));
        }
        else if(score>=40){
            System.out.println(ansi().eraseScreen().fg(YELLOW).a("Congratulations, you got a D"));
        }
        else{
            System.out.println(ansi().eraseScreen().fg(RED).a("Sorry, you get no award"));
        }


    }
}
