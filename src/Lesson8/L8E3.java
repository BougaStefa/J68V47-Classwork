package Lesson8;

import java.util.*;

public class L8E3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Set up the directions array
        String[] directions = {"Start by exiting the building you are currently in and turning left onto the main road.",
                "Walk down the road for two blocks until you reach the traffic lights.",
                "At the traffic lights, turn right onto Oak Street.",
                "Follow Oak Street for one block then turn left onto Elm Street.",
                "Walk to the end of Elm Street. Your doctor's office will be the third building on the right side of the road.",
                "Enter through the front door of the office. Let the receptionist know you have arrived for your appointment.",
                "Take a seat in the waiting room. The doctor will call your name when it's time to be seen. You've arrived!"
        };

        // Print out each direction
        int step = 1;
        for (String direction : directions) {
            System.out.format("%d. %s %n", step, direction);
            step++;
        }
        step = 1;
        System.out.println("Enter the new direction instructions: ");
        String instructionsEntered = input.nextLine();
        System.out.println("Which step would this be? ");
        int chosenStep = input.nextInt();
        for (String direction : addValueToArray(directions, instructionsEntered, chosenStep)) {
            System.out.format("%d. %s %n", step, direction);
            step++;
        }
        input.nextLine();
        step = 1;
        for (String direction : removeLastItem(addValueToArray(directions, instructionsEntered, chosenStep))) {
            System.out.format("%d. %s %n", step, direction);
            step++;
        }
    }

    public static String[] addValueToArray(String[] oldArray, String newString, int stepPosition) {
        String[] newArray = new String[oldArray.length + 1];
        for (int i = 0; i <= (stepPosition - 1); i++) {
            newArray[i] = oldArray[i];
            if (i == (stepPosition - 1)) {
                newArray[i] = newString;
            }
        }
        for (int i = stepPosition; i <= oldArray.length; i++) {
            newArray[i] = oldArray[i - 1];
        }
        return newArray;
    }

    public static String[] removeLastItem(String[] oldArray) {
        return Arrays.copyOf(oldArray, oldArray.length - 1);
    }
}