import java.util.*;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
public class L4E4a {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        Scanner input   =   new Scanner(System.in);
        System.out.println("Guess the number");
        int guess       =   input.nextInt();
        int answer      =   69;
        if(guess<answer){
            System.out.println(ansi().eraseScreen().fg(RED).a("Too low, go higher"));
        }
        else if(guess>answer){ // Not yet covered but it looks better than 3xIFs
            System.out.println(ansi().eraseScreen().fg(RED).a("Too high, go lower"));
        }
        else{
            System.out.println(ansi().eraseScreen().fg(GREEN).a("That is correct!"));
        }
    }
}
