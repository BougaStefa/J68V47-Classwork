package Project.Tests;

import static Project.Constants.ACCOUNT_CREATED_MSG;
import static Project.Constants.ACTIVITY_ACTIVE_MULTIPLIER;
import static Project.Constants.ACTIVITY_LIGHT_MULTIPLIER;
import static Project.Constants.ACTIVITY_MODERATE_MULTIPLIER;
import static Project.Constants.ACTIVITY_SEDENTARY_MULTIPLIER;
import static Project.Constants.ACTIVITY_VERY_ACTIVE_MULTIPLIER;
import static Project.Constants.ADHERENCE_MSG;
import static Project.Constants.CALORIES_PER_HALF_KG;
import static Project.Constants.CALORIES_PER_KG;
import static Project.Constants.CALORIES_PER_QUARTER_KG;
import static Project.Constants.GOAL_CONGRATS_KILO_GAIN;
import static Project.Constants.GOAL_CONGRATS_QUARTER;
import static Project.Constants.GOAL_GAIN;
import static Project.Constants.GOAL_LOSE;
import static Project.Constants.GOAL_MAINTAIN;
import static Project.Constants.LOGIN_SUCCESSFULL;
import static Project.Constants.MAINTAIN_CONGRATS;
import static Project.Constants.MENU_GOAL_GAIN;
import static Project.Constants.MENU_GOAL_LOSE;
import static Project.Constants.MENU_GOAL_MAINTAIN;
import static Project.Constants.MIN_AGE;
import static Project.Constants.MIN_HEIGHT;
import static Project.Constants.MIN_WEIGHT;
import static Project.Constants.PACE_FAST;
import static Project.Constants.PACE_NORMAL;
import static Project.Constants.PACE_SLOWLY;
import static Project.Constants.PASSWORD_MAX_LENGTH;
import static Project.Constants.PASSWORD_MIN_LENGTH;
import static Project.Constants.RECOMMEND_NEW_CALORIES;
import static Project.Constants.TARGET_CALORIES_MSG;
import static Project.Constants.USERNAME_NOT_FOUND;
import static Project.Constants.USER_ACTIVITY_ACTIVE;
import static Project.Constants.USER_ACTIVITY_LIGHT;
import static Project.Constants.USER_ACTIVITY_MODERATE;
import static Project.Constants.USER_ACTIVITY_SEDENTARY;
import static Project.Constants.USER_ACTIVITY_VERY_ACTIVE;
import static Project.Constants.USER_SEX_FEMALE;
import static Project.Constants.USER_SEX_MALE;
import static Project.Constants.WEEKDAYS;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import Project.MathSoup;
import Project.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class MathSoupTest {

  //---------------------------getValidNumber() Tests---------------------------//
  @Test
  public void testGetValidNumber_ValidInput() {
    String input = "5\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    int result = mathSoup.getValidNumber(scanner, 1, 10);
    assertTrue(result >= 1 && result <= 10);
  }

  @Test
  public void testGetValidNumber_MultipleInputs() {
    String input = "0\n11\n5\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    int result = mathSoup.getValidNumber(scanner, 1, 10);
    assertTrue(result >= 1 && result <= 10);
  }

  @Test
  public void testGetValidNumber_InvalidInput() {
    String input = "abc\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.getValidNumber(scanner, 1, 10);
      }
    );
  }

  //---------------------------getValidDouble() Tests---------------------------//
  @Test
  public void testGetValidDouble_ValidInput() {
    String input = "5.5\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getValidDouble(scanner, 1, 10);
    assertTrue(result >= 1 && result <= 10);
  }

  @Test
  public void testGetValidDouble_MultipleInputs() {
    String input = "0\n11\n5.5\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getValidDouble(scanner, 1, 10);
    assertTrue(result >= 1 && result <= 10);
  }

  @Test
  public void testGetValidDouble_InvalidInput() {
    String input = "abc\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.getValidDouble(scanner, 1, 10);
      }
    );
  }

  //---------------------------getValidWeight() Tests---------------------------//
  // No need to test for valid input, as it is tested above(getValidNumber())
  //---------------------------getValidHeight() Tests---------------------------//
  // No need to test for valid input, as it is tested above(getValidNumber())
  //---------------------------getValidAge() Tests---------------------------//
  // No need to test for valid input, as it is tested above(getValidNumber())
  //---------------------------getValidUsername() Tests---------------------------//
  @Test
  public void testGetValidUsername_ValidInput() {
    String input = "abc\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.getValidUsername(scanner);
    assertEquals("abc", result);
  }

  @Test
  public void testGetValidUsername_InvalidInput() {
    String input = "abc@\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.getValidUsername(scanner);
      }
    );
  }

  //---------------------------getValidPassword() Tests---------------------------//
  @Test
  public void testGetValidPassword_ValidInput() {
    String input = "abc1\nabc12345678\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.getValidPassword(scanner, 6, 20);
    assertTrue(
      result.length() >= PASSWORD_MIN_LENGTH &&
      result.length() <= PASSWORD_MAX_LENGTH
    );
  }

  @Test
  public void testGetValidPassword_InvalidInput() {
    String input = "abc12\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.getValidPassword(scanner, 6, 20);
      }
    );
  }

  //---------------------------displayGoalMenu() Tests---------------------------//
  @Test
  public void testDisplayGoalMenu_Gain() {
    String input = "3\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayGoalMenu(scanner);
    assertEquals(GOAL_GAIN, result);
  }

  @Test
  public void testDisplayGoalMenu_Lose() {
    String input = "1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayGoalMenu(scanner);
    assertEquals(GOAL_LOSE, result);
  }

  @Test
  public void testDisplayGoalMenu_Maintain() {
    String input = "2\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayGoalMenu(scanner);
    assertEquals(GOAL_MAINTAIN, result);
  }

  @Test
  public void testDisplayGoalMenu_InvalidInput() {
    String input = "4\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.displayGoalMenu(scanner);
      }
    );
  }

  //---------------------------displayPaceMenu() Tests---------------------------//
  @Test
  public void testDisplayPaceMenu_Slow() {
    String input = "1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayPaceMenu(scanner);
    assertEquals(PACE_SLOWLY, result);
  }

  @Test
  public void testDisplayPaceMenu_Normal() {
    String input = "2\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayPaceMenu(scanner);
    assertEquals(PACE_NORMAL, result);
  }

  @Test
  public void testDisplayPaceMenu_Fast() {
    String input = "3\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayPaceMenu(scanner);
    assertEquals(PACE_FAST, result);
  }

  @Test
  public void testDisplayPaceMenu_InvalidInput() {
    String input = "4\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.displayPaceMenu(scanner);
      }
    );
  }

  //---------------------------displaySexMenu() Tests---------------------------//
  @Test
  public void testDisplaySexMenu_Male() {
    String input = "1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displaySexMenu(scanner);
    assertEquals(USER_SEX_MALE, result);
  }

  @Test
  public void testDisplaySexMenu_Female() {
    String input = "2\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displaySexMenu(scanner);
    assertEquals(USER_SEX_FEMALE, result);
  }

  @Test
  public void testDisplaySexMenu_InvalidInput() {
    String input = "3\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.displaySexMenu(scanner);
      }
    );
  }

  //---------------------------displayActivityMenu() Tests---------------------------//
  @Test
  public void testDisplayActivityMenu_Sedentary() {
    String input = "1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayActivityMenu(scanner);
    assertEquals(USER_ACTIVITY_SEDENTARY, result);
  }

  @Test
  public void testDisplayActivityMenu_Light() {
    String input = "2\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayActivityMenu(scanner);
    assertEquals(USER_ACTIVITY_LIGHT, result);
  }

  @Test
  public void testDisplayActivityMenu_Moderate() {
    String input = "3\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayActivityMenu(scanner);
    assertEquals(USER_ACTIVITY_MODERATE, result);
  }

  @Test
  public void testDisplayActivityMenu_Active() {
    String input = "4\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayActivityMenu(scanner);
    assertEquals(USER_ACTIVITY_ACTIVE, result);
  }

  @Test
  public void testDisplayActivityMenu_VeryActive() {
    String input = "5\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    String result = mathSoup.displayActivityMenu(scanner);
    assertEquals(USER_ACTIVITY_VERY_ACTIVE, result);
  }

  @Test
  public void testDisplayActivityMenu_InvalidInput() {
    String input = "6\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.displayActivityMenu(scanner);
      }
    );
  }

  //--------------------------displayAccountExist()------------------------------------//
  //No need to test for valid input, as it is tested above(getValidNumber())
  //--------------------------caloricMaintenance------------------------------------//
  @Test
  public void testCaloricMaintenance_ValidInput() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.caloricMaintenance(
      "Male",
      70,
      160,
      21,
      "Sedentary"
    );
    assertEquals(1920, result, 0.01);
  }

  @Test
  public void testCaloricMaintenance_ValidInputEdge() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.caloricMaintenance(
      "Female",
      MIN_WEIGHT,
      MIN_HEIGHT,
      MIN_AGE,
      "Sedentary"
    );
    assertEquals(471, result, 0.01);
  }

  //---------------------------calculateCaloricMaintenance() Tests---------------------------//
  @Test
  public void testCalculateCaloricMaintenance_Male() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.calculateCaloricMaintenance(
      USER_SEX_MALE,
      70,
      170,
      25,
      1.2
    );
    double expected = ((10 * 70) + (6.25 * 170) - (5 * 25) + 5) * 1.2;
    assertEquals(expected, result, 0.01);
  }

  @Test
  public void testCalculateCaloricMaintenance_Female() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.calculateCaloricMaintenance(
      USER_SEX_FEMALE,
      60,
      160,
      30,
      1.3
    );
    double expected = ((10 * 60) + (6.25 * 160) - (5 * 30) - 161) * 1.3;
    assertEquals(expected, result, 0.01);
  }

  //---------------------------getActivityMultiplier() Tests---------------------------//
  @Test
  public void testGetActivityMultiplier_Sedentary() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getActivityMultiplier(USER_ACTIVITY_SEDENTARY);
    assertEquals(ACTIVITY_SEDENTARY_MULTIPLIER, result, 0.01);
  }

  @Test
  public void testGetActivityMultiplier_Light() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getActivityMultiplier(USER_ACTIVITY_LIGHT);
    assertEquals(ACTIVITY_LIGHT_MULTIPLIER, result, 0.01);
  }

  @Test
  public void testGetActivityMultiplier_Moderate() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getActivityMultiplier(USER_ACTIVITY_MODERATE);
    assertEquals(ACTIVITY_MODERATE_MULTIPLIER, result, 0.01);
  }

  @Test
  public void testGetActivityMultiplier_Active() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getActivityMultiplier(USER_ACTIVITY_ACTIVE);
    assertEquals(ACTIVITY_ACTIVE_MULTIPLIER, result, 0.01);
  }

  @Test
  public void testGetActivityMultiplier_VeryActive() {
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.getActivityMultiplier(USER_ACTIVITY_VERY_ACTIVE);
    assertEquals(ACTIVITY_VERY_ACTIVE_MULTIPLIER, result, 0.01);
  }

  @Test
  public void testGetActivityMultiplier_InvalidInput() {
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      IllegalStateException.class,
      () -> mathSoup.getActivityMultiplier("Invalid")
    );
  }

  //---------------------------caloriesBasedOnGoal() Tests---------------------------//
  @Test
  public void testCaloriesBasedOnGoal_GainFast() {
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.caloriesBasedOnGoal(GOAL_GAIN, PACE_FAST, 2000);
    long expected = 2000 + (mathSoup.getPaceMultiplier(PACE_FAST) / WEEKDAYS);
    assertEquals(expected, result);
  }

  @Test
  public void testCaloriesBasedOnGoal_LoseSlowly() {
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.caloriesBasedOnGoal(GOAL_LOSE, PACE_SLOWLY, 2000);
    long expected = 2000 - (mathSoup.getPaceMultiplier(PACE_SLOWLY) / WEEKDAYS);
    assertEquals(expected, result);
  }

  @Test
  public void testCaloriesBasedOnGoal_Maintain() {
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.caloriesBasedOnGoal(
      GOAL_MAINTAIN,
      PACE_NORMAL,
      2000
    );
    long expected = 2000;
    assertEquals(expected, result);
  }

  //---------------------------getPaceMultiplier() Tests---------------------------//
  @Test
  public void testGetPaceMultiplier_Slowly() {
    MathSoup mathSoup = new MathSoup();
    int result = mathSoup.getPaceMultiplier(PACE_SLOWLY);
    assertEquals(CALORIES_PER_QUARTER_KG, result);
  }

  @Test
  public void testGetPaceMultiplier_Normal() {
    MathSoup mathSoup = new MathSoup();
    int result = mathSoup.getPaceMultiplier(PACE_NORMAL);
    assertEquals(CALORIES_PER_HALF_KG, result);
  }

  @Test
  public void testGetPaceMultiplier_Fast() {
    MathSoup mathSoup = new MathSoup();
    int result = mathSoup.getPaceMultiplier(PACE_FAST);
    assertEquals(CALORIES_PER_KG, result);
  }

  @Test
  public void testGetPaceMultiplier_InvalidInput() {
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      IllegalStateException.class,
      () -> mathSoup.getPaceMultiplier("Invalid")
    );
  }

  //---------------------------calculateCalories() Tests---------------------------//
  @Test
  public void testCalculateCalories_GainFast() {
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.calculateCalories(
      GOAL_GAIN,
      2000,
      mathSoup.getPaceMultiplier(PACE_FAST)
    );
    long expected = 2000 + (mathSoup.getPaceMultiplier(PACE_FAST) / WEEKDAYS);
    assertEquals(expected, result);
  }

  @Test
  public void testCalculateCalories_LoseSlowly() {
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.calculateCalories(
      GOAL_LOSE,
      2000,
      mathSoup.getPaceMultiplier(PACE_SLOWLY)
    );
    long expected = 2000 - (mathSoup.getPaceMultiplier(PACE_SLOWLY) / WEEKDAYS);
    assertEquals(expected, result);
  }

  @Test
  public void testCalculateCalories_Maintain() {
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.calculateCalories(
      GOAL_MAINTAIN,
      2000,
      mathSoup.getPaceMultiplier(PACE_NORMAL)
    );
    long expected = 2000;
    assertEquals(expected, result);
  }

  //---------------------------createUser() Tests---------------------------//
  @Test
  public void testCreateUser_ValidInput() {
    String input = "password123\n1\n70\n170\n25\n1\n1\n1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    User result = mathSoup.createUser(scanner, "testUser");
    assertFalse(result == null);
    assertEquals("testUser", result.getUsername());
    assertEquals("password123", result.getPassword());
    assertEquals(70, result.getWeight());
    assertEquals(170, result.getHeight());
    assertEquals(25, result.getAge());
  }

  //All variables are controlled so invalid input is technically already handled before
  //reaching this function so only one scenario is simulated here(short password)
  @Test
  public void testCreateUser_InvalidPassword() {
    String input = "pass\npassword123\n1\n70\n170\n25\n1\n1\n1\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    User result = mathSoup.createUser(scanner, "testUser");
    assertFalse(result == null);
    assertEquals("testUser", result.getUsername());
    assertEquals("password123", result.getPassword());
    assertEquals(70, result.getWeight());
    assertEquals(170, result.getHeight());
    assertEquals(25, result.getAge());
  }

  //---------------------------displayAccountCreatedMessage() Tests---------------------------//
  //NOTE : For some reason the end of line character was different, had to replace it for an accurate comparison(text was fine)
  @Test
  public void testDisplayAccountCreatedMessage_GoalMaintain() {
    User user = new User();
    user.setGoal(GOAL_MAINTAIN);
    user.setMaintenance(2000);
    MathSoup mathSoup = new MathSoup();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mathSoup.displayAccountCreatedMessage(user);
    String expectedOutput =
      ACCOUNT_CREATED_MSG + "2000\n" + ADHERENCE_MSG + "\n";
    String actualOutput = outContent.toString();
    assertEquals(
      expectedOutput.replace("\r\n", "\n"),
      actualOutput.replace("\r\n", "\n")
    );
  }

  @Test
  public void testDisplayAccountCreatedMessage_GoalNotMaintain() {
    User user = new User();
    user.setGoal(GOAL_LOSE);
    user.setMaintenance(2000);
    user.setCalories(1800);
    MathSoup mathSoup = new MathSoup();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mathSoup.displayAccountCreatedMessage(user);
    String expectedOutput =
      ACCOUNT_CREATED_MSG +
      "2000\n" +
      TARGET_CALORIES_MSG +
      "1800\n" +
      ADHERENCE_MSG +
      "\n";
    String actualOutput = outContent.toString();
    assertEquals(
      expectedOutput.replace("\r\n", "\n"),
      actualOutput.replace("\r\n", "\n")
    );
  }

  //---------------------------storeUser() Tests------------------------------------------//
  @Test
  public void testStoreUser() {
    User user = new User();
    user.setUsername("testUser");
    user.setPassword("testPassword");
    user.setGoal(GOAL_MAINTAIN);
    user.setMaintenance(2000);
    user.setCalories(2000);
    user.setPace(PACE_NORMAL);
    user.setActivity(USER_ACTIVITY_MODERATE);
    user.setAge(25);
    user.setHeight(175);
    user.setWeight(70);
    String filename = "testUserFile.txt";
    String expectedOutput =
      "testUser,testPassword,Maintain,2000,2000,Normal,ModeratelyActive,25,175,70";
    MathSoup.storeUser(user, filename);
    try {
      String actualOutput = new String(Files.readAllBytes(Paths.get(filename)))
        .trim();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      fail("Failed to read the user file: " + e.getMessage());
    } finally {
      try {
        Files.deleteIfExists(Paths.get(filename));
      } catch (IOException e) {
        System.out.println("Failed to delete the test file: " + e.getMessage());
      }
    }
  }

  @Test
  public void testStoreUserWithNullUser() {
    User user = null;
    String filename = "testUserFile.txt";
    try {
      MathSoup.storeUser(user, filename);
      fail("Expected an exception to be thrown");
    } catch (Exception e) {
      assertTrue(e instanceof NullPointerException);
    } finally {
      try {
        Files.deleteIfExists(Paths.get(filename));
      } catch (IOException e) {
        System.out.println("Failed to delete the test file: " + e.getMessage());
      }
    }
  }

  //-------------------------------------checkUsernameExists() Tests-------------------------------------//
  @Test
  public void testCheckUsernameExists_UserExists() {
    String username = "testUser";
    String filename = "testUserFile.txt";
    try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
      out.println(
        username + ",testPassword,MAINTAIN,2000,2000,NORMAL,MODERATE,25,175,70"
      );
    } catch (IOException e) {
      fail("Failed to create the test file: " + e.getMessage());
    }
    boolean result = MathSoup.checkUsernameExists(username, filename);
    assertTrue(result);
    try {
      Files.deleteIfExists(Paths.get(filename));
    } catch (IOException e) {
      System.out.println("Failed to delete the test file: " + e.getMessage());
    }
  }

  @Test
  public void testCheckUsernameExists_UserDoesNotExist() {
    String username = "nonexistentUser";
    String filename = "testUserFile.txt";
    try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
      out.println(
        "testUser,testPassword,MAINTAIN,2000,2000,NORMAL,MODERATE,25,175,70"
      );
    } catch (IOException e) {
      fail("Failed to create the test file: " + e.getMessage());
    }
    boolean result = MathSoup.checkUsernameExists(username, filename);
    assertFalse(result);
    try {
      Files.deleteIfExists(Paths.get(filename));
    } catch (IOException e) {
      System.out.println("Failed to delete the test file: " + e.getMessage());
    }
  }

  //-------------------------------------newMaintenance() Tests-----------------------------------------//
  @Test
  public void testNewMaintenance_WeightLossIsZero() {
    MathSoup mathSoup = new MathSoup();
    long averageCalories = 2000;
    double weightLoss = 0;
    long expected = 2000;
    long result = mathSoup.newMaintenance(averageCalories, weightLoss);
    assertEquals(expected, result);
  }

  @Test
  public void testNewMaintenance_WeightLossIsPositive() {
    MathSoup mathSoup = new MathSoup();
    long averageCalories = 2000;
    double weightLoss = 1.3;
    long expected =
      2000 - Math.round((CALORIES_PER_KG * weightLoss) / WEEKDAYS);
    long result = mathSoup.newMaintenance(averageCalories, weightLoss);
    assertEquals(expected, result);
  }

  @Test
  public void testNewMaintenance_AverageCaloriesIsZero() {
    MathSoup mathSoup = new MathSoup();
    long averageCalories = 0;
    double weightLoss = 1;
    long expected = -Math.round((CALORIES_PER_KG * weightLoss) / WEEKDAYS);
    long result = mathSoup.newMaintenance(averageCalories, weightLoss);
    assertEquals(expected, result);
  }

  //-------------------------------------newGoalMath() Tests-----------------------------------------//
  @Test
  public void testNewGoalMath_PaceIsZero() {
    MathSoup mathSoup = new MathSoup();
    long newMaintenance = 2000;
    long pace = 0;
    long expected = 2000;
    long result = mathSoup.newGoalMath(newMaintenance, pace);
    assertEquals(expected, result);
  }

  @Test
  public void testNewGoalMath_PaceIsPositive() {
    MathSoup mathSoup = new MathSoup();
    long newMaintenance = 2000;
    long pace = 500;
    long expected = 2000 + Math.round((float) pace / WEEKDAYS);
    long result = mathSoup.newGoalMath(newMaintenance, pace);
    assertEquals(expected, result);
  }

  @Test
  public void testNewGoalMath_NewMaintenanceIsZero() {
    MathSoup mathSoup = new MathSoup();
    long newMaintenance = 0;
    long pace = 500;
    long expected = Math.round((float) pace / WEEKDAYS);
    long result = mathSoup.newGoalMath(newMaintenance, pace);
    assertEquals(expected, result);
  }

  //-------------------------------------averageCalories() Tests-----------------------------------------//
  @Test
  public void testAverageCalories_ValidInput() {
    String input = "2000\n2000\n2000\n2000\n2000\n2000\n2000\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.averageCalories(scanner);
    assertEquals(2000, result);
  }

  @Test
  public void testAverageCalories_MixedInput() {
    String input = "1000\n2000\n3000\n2000\n1000\n2000\n3000\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    long result = mathSoup.averageCalories(scanner);
    assertEquals(2000, result);
  }

  @Test
  public void testAverageCalories_InvalidInput() {
    String input = "abc\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.averageCalories(scanner);
      }
    );
  }

  //-------------------------------------weightChange() Tests-----------------------------------------//
  @Test
  public void testWeightChange_WeightLoss() {
    String input = "80\n75\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.weightChange(scanner);
    assertEquals(-5, result, 0.001);
  }

  @Test
  public void testWeightChange_WeightGain() {
    String input = "75\n80\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.weightChange(scanner);
    assertEquals(5, result, 0.001);
  }

  @Test
  public void testWeightChange_NoWeightChange() {
    String input = "80\n80\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    double result = mathSoup.weightChange(scanner);
    assertEquals(0, result, 0.001);
  }

  @Test
  public void testWeightChange_InvalidInput() {
    String input = "abc\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    MathSoup mathSoup = new MathSoup();
    assertThrows(
      NoSuchElementException.class,
      () -> {
        mathSoup.weightChange(scanner);
      }
    );
  }

  //-------------------------------------welcomeBack() Tests-----------------------------------------//
  @Test
  public void testWelcomeBack() {
    User user = new User();
    user.setUsername("testUser");
    user.setGoal("Lose");
    user.setCalories(2000);
    String expectedOutput =
      "Welcome back testUser\n" +
      "Hope your goal to Lose weight is going well!\n" +
      "Your daily calorie intake for the past 7 days was set to: 2000\n";
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    MathSoup mathSoup = new MathSoup();
    mathSoup.welcomeBack(user);
    assertEquals(
      expectedOutput.replace("\r\n", "\n"),
      outContent.toString().replace("\r\n", "\n")
    );
  }

  //---------------------------handleGoal() Tests---------------------------//
  @Test
  public void testHandleGoal_LoseSlowly() {
    User user = new User();
    user.setGoal(GOAL_LOSE);
    user.setPace(PACE_SLOWLY);
    user.setUsername("validusername");
    MathSoup mathSoup = new MathSoup();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mathSoup.handleGoal(user, -0.1, 2000);
    String expectedOutput =
      GOAL_CONGRATS_QUARTER + "\n" + RECOMMEND_NEW_CALORIES + "2000\n";
    assertEquals(
      expectedOutput.replace("\r\n", "\n"),
      outContent.toString().replace("\r\n", "\n")
    );
  }

  @Test
  public void testHandleGoal_Maintain() {
    User user = new User();
    user.setGoal(GOAL_MAINTAIN);
    user.setUsername("validusername");
    MathSoup mathSoup = new MathSoup();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mathSoup.handleGoal(user, 0.05, 2000);
    String expectedOutput =
      MAINTAIN_CONGRATS + "\n" + RECOMMEND_NEW_CALORIES + "2000\n";
    assertEquals(
      expectedOutput.replace("\r\n", "\n"),
      outContent.toString().replace("\r\n", "\n")
    );
  }

  @Test
  public void testHandleGoal_GainFast() {
    User user = new User();
    user.setGoal(GOAL_GAIN);
    user.setPace(PACE_FAST);
    user.setUsername("validusername");
    MathSoup mathSoup = new MathSoup();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mathSoup.handleGoal(user, 2.0, 2000);
    String expectedOutput =
      GOAL_CONGRATS_KILO_GAIN + "\n" + RECOMMEND_NEW_CALORIES + "2000\n";
    assertEquals(
      expectedOutput.replace("\r\n", "\n"),
      outContent.toString().replace("\r\n", "\n")
    );
  }

  //---------------------------updateCalories() Tests----------------------------------------//
  @Test
  public void testUpdateCalories_UserExists() throws IOException {
    File tempFile = File.createTempFile("test", ".txt");
    tempFile.deleteOnExit();
    String username = "testuser";
    String originalData =
      username +
      ",data1,data2,data3,1000,data5\notheruser,data1,data2,data3,2000,data5\n";
    Files.write(tempFile.toPath(), originalData.getBytes());
    MathSoup.updateCalories(username, 1500, tempFile.getAbsolutePath());
    String expectedData =
      username +
      ",data1,data2,data3,1500,data5\notheruser,data1,data2,data3,2000,data5\n";
    String actualData = new String(Files.readAllBytes(tempFile.toPath()));
    assertEquals(
      expectedData.replace("\r\n", "\n"),
      actualData.replace("\r\n", "\n")
    );
  }

  @Test
  public void testUpdateCalories_UserDoesNotExist() throws IOException {
    File tempFile = File.createTempFile("test", ".txt");
    tempFile.deleteOnExit();
    String originalData = "otheruser,data1,data2,data3,2000,data5\n";
    Files.write(tempFile.toPath(), originalData.getBytes());
    MathSoup.updateCalories("testuser", 1500, tempFile.getAbsolutePath());
    String actualData = new String(Files.readAllBytes(tempFile.toPath()));
    assertEquals(
      originalData.replace("\r\n", "\n"),
      actualData.replace("\r\n", "\n")
    );
  }

  //---------------------------getUser() Tests----------------------------------------//
  @Test
  public void testGetUser_UserExists() throws IOException {
    File tempFile = File.createTempFile("test", ".txt");
    tempFile.deleteOnExit();
    String username = "testuser";
    String originalData =
      username +
      ",password,Lose,2000,2000,Fast,active,20,160,95\notheruser,password,name,25,175,75,male,light,2500,2\n";
    Files.write(tempFile.toPath(), originalData.getBytes());
    User user = MathSoup.getUser(username, tempFile.getAbsolutePath());
    assertEquals(username, user.getUsername());
    assertEquals("password", user.getPassword());
    assertEquals(20, user.getAge());
    assertEquals(160, user.getHeight());
    assertEquals(95, user.getWeight());
    assertEquals("active", user.getActivity());
    assertEquals(2000, user.getCalories());
    assertEquals("Lose", user.getGoal());
    assertEquals(2000, user.getMaintenance());
    assertEquals("Fast", user.getPace());
  }

  @Test
  public void testGetUser_UserDoesNotExist() throws IOException {
    File tempFile = File.createTempFile("test", ".txt");
    tempFile.deleteOnExit();
    String originalData =
      "otheruser,password,name,25,175,75,male,light,2500,2\n";
    Files.write(tempFile.toPath(), originalData.getBytes());
    User user = MathSoup.getUser("testuser", tempFile.getAbsolutePath());
    assertNull(user);
  }
}
