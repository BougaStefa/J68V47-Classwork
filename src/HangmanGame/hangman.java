package HangmanGame;

import static HangmanGame.asciiman.*;
import static Project.Constants.*;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class hangman {

  public static String getWord() {
    Random random = new Random();
    int randLine = random.nextInt(58108) + 1;
    int counter = 0;
    try (
      BufferedReader br = new BufferedReader(
        new FileReader("J68V47-Classwork\\src\\HangmanGame\\wordbase.txt")
      );
    ) {
      String line = br.readLine();
      while (line != null) {
        if (counter == randLine) {
          return line;
        }
        line = br.readLine();
        counter++;
      }
    } catch (IOException e) {
      System.out.println(READING_FROM_FILE_ERROR + e.getMessage());
    }
    return null;
  }

  public static String guessWrong(int lives) {
    System.out.println("Incorrect!");
    switch (lives) {
      case 1:
        return LIFE_ONE;
      case 2:
        return LIFE_TWO;
      case 3:
        return LIFE_THREE;
      case 4:
      case 5:
        return LIFE_FIVE;
      case 6:
        return LIFE_SIX;
      case 7:
        return LIFE_SEVEN;
      default:
        return null;
    }
  }

  public static void showResult(String word, String guess, char[] guessSoFar) {
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == guess.charAt(0)) {
        guessSoFar[i] = guess.charAt(0);
      }
    }
    System.out.println(guessSoFar);
  }

  public static void guessesSoFar(String[] guess) {
    System.out.println("Letters tried so far: ");
    for (int i = 0; i < guess.length; i++) {
      if (guess[i] != null) {
        System.out.print(guess[i] + " ");
      }
    }
    System.out.println();
  }

  public static String getValidLetter(Scanner scanner) {
    String acceptedChars = "[^a-zA-Z]";
    Pattern pattern = Pattern.compile(acceptedChars);
    while (true) {
      String letter = scanner.nextLine();
      if (pattern.matcher(letter).find()) {
        System.out.println(INVALID_USERNAME_PROMPT);
      } else {
        return letter;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String word = getWord();
    int currentLife = 1;
    int i = 0;
    String[] guesses = new String[7];
    char[] guessSoFar = new char[word.length()];
    Arrays.fill(guessSoFar, '_');
    String guess = "";
    while (currentLife <= 7) {
      System.out.println("Guess a letter: ");
      while (true) {
        guess = getValidLetter(scanner).toLowerCase();
        if (guess.length() == 1) {
          break;
        }
      }
      if (word.contains(guess)) {
        System.out.println("Correct!");
        showResult(word, guess, guessSoFar);
        String currentGuess = new String(guessSoFar);
        if (currentGuess.equals(word)) {
          System.out.println("You won!");
          System.out.println("The word was: " + word);
          scanner.close();
          return;
        }
      } else {
        System.out.println(guessWrong(currentLife));
        System.out.println("What you got so far :");
        showResult(word, guess, guessSoFar);
        guesses[i] = guess;
        i++;
        guessesSoFar(guesses);
        currentLife++;
      }
    }
    System.out.println("You lost!");
    System.out.println("The word was: " + word);
    scanner.close();
  }
}
