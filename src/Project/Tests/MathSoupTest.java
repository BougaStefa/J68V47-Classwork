package Project.Tests;

import static Project.Constants.ACTIVITY_ACTIVE_MULTIPLIER;
import static Project.Constants.ACTIVITY_LIGHT_MULTIPLIER;
import static Project.Constants.ACTIVITY_MODERATE_MULTIPLIER;
import static Project.Constants.ACTIVITY_SEDENTARY_MULTIPLIER;
import static Project.Constants.ACTIVITY_VERY_ACTIVE_MULTIPLIER;
import static Project.Constants.CALORIES_PER_HALF_KG;
import static Project.Constants.CALORIES_PER_KG;
import static Project.Constants.CALORIES_PER_QUARTER_KG;
import static Project.Constants.GOAL_GAIN;
import static Project.Constants.GOAL_LOSE;
import static Project.Constants.GOAL_MAINTAIN;
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
import static Project.Constants.USER_ACTIVITY_ACTIVE;
import static Project.Constants.USER_ACTIVITY_LIGHT;
import static Project.Constants.USER_ACTIVITY_MODERATE;
import static Project.Constants.USER_ACTIVITY_SEDENTARY;
import static Project.Constants.USER_ACTIVITY_VERY_ACTIVE;
import static Project.Constants.USER_SEX_FEMALE;
import static Project.Constants.USER_SEX_MALE;
import static Project.Constants.WEEKDAYS;
import static org.junit.jupiter.api.Assertions.*;

import Project.MathSoup;
import Project.User;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
  
}
