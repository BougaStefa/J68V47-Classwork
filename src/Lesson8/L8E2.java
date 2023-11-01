package Lesson8;

import java.util.Random;

public class L8E2 {
    public static void main(String[] args) {
        int[] grades = new int[9];
        for (int i = 0; i < 9; i++) {
            grades[i] = randomNum();
        }
        for (int value : grades) {
            System.out.println(value);
        }

    }

    public static int randomNum() {
        Random random = new Random();
        return random.nextInt(100);
    }


}
