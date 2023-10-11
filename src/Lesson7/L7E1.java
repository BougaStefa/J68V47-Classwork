package Lesson7;
import java.util.*;
public class L7E1 {
    public static void showMenu(){
        System.out.println("1.Say \"Hello!\"\n2.Tell me the time\n3.Tell me a joke\n4.Quit");
    }
    public static int getOption(){
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        return option;
    }
    public static void optionResp(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = getOption();
            if(option==1){
                optionResp("Hello!");
            }
            else if(option==2){
                optionResp("The time is x");
            }
            else if(option==3){
                optionResp("Big funny joke haha");
            }
            else if(option==4){
                optionResp("Bye!");
            }
            else{
                optionResp("Not a valid entry.Pick between 1 and 4");
            }
        } while(option!=4);
    }
}

