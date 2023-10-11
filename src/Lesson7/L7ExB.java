/*Doubled up the menus instead of going straight back to it for some variety
*/
package Lesson7;

import java.util.Scanner;
import java.util.Random;

public class L7ExB {
    public static void showMenu() {
        System.out.printf("Menu%n1.Easy Math Problems%n2.Hard Math Problems%n3.Quit%n");
    }

    public static void showMenu2() {
        System.out.printf("Do you wish to:%n1.Go back to main menu%n2.Quit%n");
    }

    public static int getOption() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static int askQuestion(int rand1, int rand2) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is " + rand1 + " + " + rand2 + " ?");
        return input.nextInt();
    }

    public static int correctAnswer(int score) {
        System.out.println("Correct!");
        score++;
        return score;
    }

    public static int wrongAnswer(int lives, int answer) {
        System.out.println("Wrong! The answer is " + answer);
        lives--;
        System.out.println("You have " + lives + " lives left");
        return lives;
    }

    public static void gameOver(int score, int lives) {
        System.out.println("Game over, your score is " + score);
        if (lives > 0) {
            System.out.println("Well done!");
        }
    }

    public static void main(String[] args) {
        int option;
        do {
                showMenu();
                option = getOption();
                if (option == 1) {
                    Random random = new Random();
                    int score = 0;
                    int lives = 3;
                    int userAnswer;
                    int rightAnswer;
                    int count = 1;
                    while (count <= 10 && lives > 0) {
                        int num1 = random.nextInt(100);
                        int num2 = random.nextInt(100);
                        userAnswer = askQuestion(num1, num2);
                        rightAnswer = num1 + num2;
                        if (userAnswer == rightAnswer) {
                            score = correctAnswer(score);
                        } else {
                            lives = wrongAnswer(lives, rightAnswer);
                        }
                        count++;
                    }
                    gameOver(score, lives);
                } else if (option == 2) {
                    Random random = new Random();
                    int score = 0;
                    int lives = 3;
                    int userAnswer;
                    int rightAnswer;
                    int count = 1;
                    while (count <= 10 && lives > 0) {
                        int num1 = random.nextInt(5);
                        int num2 = random.nextInt(5);
                        userAnswer = askQuestion(num1, num2);
                        rightAnswer = num1 * num2;
                        if (userAnswer == rightAnswer) {
                            score = correctAnswer(score);
                        } else {
                            lives = wrongAnswer(lives, rightAnswer);
                        }
                        count++;
                    }
                    gameOver(score, lives);
                } else if (option == 3) {
                    System.out.println("Bye!");
                    //Used break, assuming it works the same as C++. If there's a way to achieve the same outcome without
                    //it let me know!
                    break;
                } else {
                    System.out.println("Not a valid entry.Pick between 1 and 3");
                }
                showMenu2();
                option = getOption();
                if(option==2){
                    System.out.println("Bye!");
                }
            } while (option == 1);
        }
    }

