package Project;

import static Project.Constants.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class MathSoup {

  //! Constants

  //!Input validation methods
  //?Methods getValidNumber and getValidDouble could be combined into one method
  public int getValidNumber(Scanner scanner, int min, int max) {
    while (true) {
      try {
        int number = scanner.nextInt();
        if (number >= min && number <= max) {
          return number;
        } else {
          System.out.println(INVALID_NUMBER_PROMPT + min + "-" + max);
        }
      } catch (java.util.NoSuchElementException e) {
        System.out.println(INVALID_NUMERICAL_INPUT);
        scanner.nextLine(); // clear input
      }
    }
  }

  public double getValidDouble(Scanner scanner, double min, double max) {
    while (true) {
      try {
        double number = scanner.nextDouble();
        if (number >= min && number <= max) {
          return number;
        } else {
          System.out.println(INVALID_NUMBER_PROMPT + min + "-" + max);
        }
      } catch (java.util.InputMismatchException e) {
        System.out.println(INVALID_NUMERICAL_INPUT);
        scanner.nextLine(); // clear input
      }
    }
  }

  //Limits based on extreme existing cases
  public int getValidWeight(Scanner scanner) {
    System.out.println(REQUEST_USER_WEIGHT);
    return getValidNumber(scanner, MIN_WEIGHT, MAX_WEIGHT);
  }

  public int getValidHeight(Scanner scanner) {
    System.out.println(REQUEST_USER_HEIGHT);
    return getValidNumber(scanner, MIN_HEIGHT, MAX_HEIGHT);
  }

  public int getValidAge(Scanner scanner) {
    System.out.println(REQUEST_USER_AGE);
    return getValidNumber(scanner, MIN_AGE, MAX_AGE);
  }

  //!If anything that is not in the specified range is detected then the user is asked to enter a valid username
  public String getValidUsername(Scanner scanner) {
    String acceptedChars = ACCEPTED_RANGE_USERNAME;
    Pattern pattern = Pattern.compile(acceptedChars);
    while (true) {
      String username = scanner.nextLine();
      if (pattern.matcher(username).find()) {
        System.out.println(INVALID_USERNAME_PROMPT);
      } else {
        return username;
      }
    }
  }

  public String getValidPassword(
    Scanner scanner,
    int minLength,
    int maxLength
  ) {
    while (true) {
      String password = scanner.nextLine();
      if (password.length() >= minLength && password.length() <= maxLength) {
        return password;
      } else {
        System.out.println(PASSWORD_LENGTH_PROMPT);
      }
    }
  }

  //!Menu Methods
  //TODO: REMOVE SWITCH CASES AND SIMPIFY TO JUST A PRINTOUT AND A GETVALIDNUMBER RETURNED. MIGHT ALSO NEED TO REMOVE CONSTANTS
  public String displayGoalMenu(Scanner scanner) {
    System.out.println(DISPLAY_GOAL_MENU);
    return switch (getValidNumber(scanner, MENU_GOAL_LOSE, MENU_GOAL_GAIN)) {
      case MENU_GOAL_LOSE -> GOAL_LOSE;
      case MENU_GOAL_MAINTAIN -> GOAL_MAINTAIN;
      case MENU_GOAL_GAIN -> GOAL_GAIN;
      //Impossible scenario
      default -> throw new IllegalArgumentException(INVALID_MENU_CHOICE);
    };
  }

  public String displayPaceMenu(Scanner scanner) {
    System.out.println(DISPLAY_PACE_MENU);
    return switch (getValidNumber(scanner, MENU_PACE_SLOW, MENU_PACE_FAST)) {
      case MENU_PACE_SLOW -> PACE_SLOWLY;
      case MENU_PACE_NORMAL -> PACE_NORMAL;
      case MENU_PACE_FAST -> PACE_FAST;
      //Impossible scenario
      default -> throw new IllegalArgumentException(DISPLAY_PACE_MENU);
    };
  }

  public String displaySexMenu(Scanner scanner) {
    System.out.println(DISPLAY_SEX_MENU);
    return switch (getValidNumber(scanner, MENU_SEX_MALE, MENU_SEX_FEMALE)) {
      case MENU_SEX_MALE -> USER_SEX_MALE;
      case MENU_SEX_FEMALE -> USER_SEX_FEMALE;
      //Impossible scenario
      default -> throw new IllegalArgumentException(INVALID_MENU_CHOICE);
    };
  }

  public String displayActivityMenu(Scanner scanner) {
    System.out.println(DISPLAY_ACTIVITY_MENU);
    return switch (
      getValidNumber(
        scanner,
        MENU_ACTIVITY_SEDENTARY,
        MENU_ACTIVITY_VERY_ACTIVE
      )
    ) {
      case MENU_ACTIVITY_SEDENTARY -> USER_ACTIVITY_SEDENTARY;
      case MENU_ACTIVITY_LIGHT -> USER_ACTIVITY_LIGHT;
      case MENU_ACTIVITY_MODERATE -> USER_ACTIVITY_MODERATE;
      case MENU_ACTIVITY_ACTIVE -> USER_ACTIVITY_ACTIVE;
      case MENU_ACTIVITY_VERY_ACTIVE -> USER_ACTIVITY_VERY_ACTIVE;
      //Impossible scenario
      default -> throw new IllegalArgumentException(INVALID_MENU_CHOICE);
    };
  }

  public int displayAccountExist(Scanner scanner) {
    System.out.println(DISPLAY_WELCOME_QUESTION);
    return getValidNumber(scanner, MENU_YES, MENU_NO);
  }

  //!Calorie Calculations
  public long caloricMaintenance(
    String sex,
    int weight,
    int height,
    int age,
    String activity
  ) {
    double activityMultiplier = getActivityMultiplier(activity);
    double caloricMaintenance = calculateCaloricMaintenance(
      sex,
      weight,
      height,
      age,
      activityMultiplier
    );
    return Math.round(caloricMaintenance);
  }

  public double calculateCaloricMaintenance(
    String sex,
    int weight,
    int height,
    int age,
    double activityMultiplier
  ) {
    double baseCaloricMaintenance =
      (WEIGHT_MULTIPLIER * weight) +
      (HEIGHT_MULTIPLIER * height) -
      (AGE_MULTIPLIER * age);
    if (sex.equals(USER_SEX_MALE)) {
      return (baseCaloricMaintenance + MALE_ADDITION) * activityMultiplier;
    } else {
      return (baseCaloricMaintenance - FEMALE_SUBTRACTION) * activityMultiplier;
    }
  }

  public double getActivityMultiplier(String activity) {
    return switch (activity) {
      case (USER_ACTIVITY_SEDENTARY) -> ACTIVITY_SEDENTARY_MULTIPLIER;
      case (USER_ACTIVITY_LIGHT) -> ACTIVITY_LIGHT_MULTIPLIER;
      case (USER_ACTIVITY_MODERATE) -> ACTIVITY_MODERATE_MULTIPLIER;
      case (USER_ACTIVITY_ACTIVE) -> ACTIVITY_ACTIVE_MULTIPLIER;
      case (USER_ACTIVITY_VERY_ACTIVE) -> ACTIVITY_VERY_ACTIVE_MULTIPLIER;
      default -> throw new IllegalStateException(
        UNEXPECTED_VALUE_ERROR + activity
      );
    };
  }

  public long caloriesBasedOnGoal(String goal, String pace, long maintenance) {
    return calculateCalories(goal, maintenance, getPaceMultiplier(pace));
  }

  public int getPaceMultiplier(String pace) {
    return switch (pace) {
      case (PACE_SLOWLY) -> CALORIES_PER_QUARTER_KG;
      case (PACE_NORMAL) -> CALORIES_PER_HALF_KG;
      case (PACE_FAST) -> CALORIES_PER_KG;
      default -> throw new IllegalStateException(UNEXPECTED_VALUE_ERROR + pace);
    };
  }

  public long calculateCalories(
    String goal,
    long maintenance,
    int paceMultiplier
  ) {
    return switch (goal) {
      case GOAL_LOSE -> maintenance - paceMultiplier / WEEKDAYS;
      case GOAL_MAINTAIN -> maintenance;
      case GOAL_GAIN -> maintenance + paceMultiplier / WEEKDAYS;
      default -> throw new IllegalArgumentException(INVALID_MENU_CHOICE);
    };
  }

  public void createAccount(Scanner scanner) {
    boolean accountCreated = false;
    System.out.println(USERNAME_PROMPT);
    while (!accountCreated) {
      String username = getValidUsername(scanner);
      if (checkUsernameExists(username, ACCOUNTS_FILE_PATH)) {
        System.out.println(USERNAME_EXISTS_MSG);
      } else {
        accountCreated = true;
        User newUser = createUser(scanner, username);
        storeUser(newUser, ACCOUNTS_FILE_PATH);
        displayAccountCreatedMessage(newUser);
      }
    }
  }

  public User createUser(Scanner scanner, String username) {
    System.out.println(PASSWORD_PROMPT);
    String password = getValidPassword(
      scanner,
      PASSWORD_MIN_LENGTH,
      PASSWORD_MAX_LENGTH
    );
    String sex = displaySexMenu(scanner);
    int weight = getValidWeight(scanner);
    int height = getValidHeight(scanner);
    int age = getValidAge(scanner);
    String goal = displayGoalMenu(scanner);
    String pace = displayPaceMenu(scanner);
    String activity = displayActivityMenu(scanner);
    long maintenance = caloricMaintenance(sex, weight, height, age, activity);
    long calories = caloriesBasedOnGoal(goal, pace, maintenance);
    return new User(
      username,
      password,
      goal,
      maintenance,
      calories,
      pace,
      activity,
      age,
      height,
      weight
    );
  }

  public void displayAccountCreatedMessage(User user) {
    System.out.println(ACCOUNT_CREATED_MSG + user.Maintenance);
    if (!user.Goal.equals(GOAL_MAINTAIN)) {
      System.out.println(TARGET_CALORIES_MSG + user.Calories);
    }
    System.out.println(ADHERENCE_MSG);
  }

  public static void storeUser(User user, String filename) {
    try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
      out.println(
        user.Username +
        "," +
        user.Password +
        "," +
        user.Goal +
        "," +
        user.Maintenance +
        "," +
        user.Calories +
        "," +
        user.Pace +
        "," +
        user.Activity +
        "," +
        user.Age +
        "," +
        user.Height +
        "," +
        user.Weight
      );
    } catch (IOException e) {
      System.out.println(STORING_TO_FILE_ERROR + e.getMessage());
    }
  }

  public static boolean checkUsernameExists(String username, String filename) {
    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
      String line = in.readLine();
      while (line != null) {
        String existingUsername = line.split(",")[0];
        if (existingUsername.equals(username)) {
          return true;
        }
        line = in.readLine();
      }
    } catch (IOException e) {
      System.out.println(READING_FROM_FILE_ERROR + e.getMessage());
    }
    return false;
  }

  public long newMaintenance(long averageCalories, double weightLoss) {
    // New maintenance is old maintenance - (7700*weight change per week)
    return Math.round(
      averageCalories - ((CALORIES_PER_KG * weightLoss) / WEEKDAYS)
    );
  }

  public long newGoalMath(long newMaintenance, long pace) {
    return Math.round(newMaintenance + (float) pace / WEEKDAYS);
  }

  public long averageCalories(Scanner scanner) {
    long totalCalories = 0;
    long dailyCalories = 0;
    for (int i = 0; i < WEEKDAYS; i++) {
      System.out.println(REQUEST_USER_CALORIES_DAY + (i + 1));
      dailyCalories =
        getValidNumber(scanner, MIN_ACCEPTED_CALORIES, MAX_ACCEPTED_CALORIES);
      // if the value entered is less than 1200 a warning is printed, values as low as
      // 0 are accepted though
      if (dailyCalories < MIN_RECOMMENDED_CALORIES) {
        System.out.println(LOW_END_CALOERIE_WARNING);
      } else if (dailyCalories > MAX_RECOMMENDED_CALORIES) {
        System.out.println(HIGH_END_CALOERIE_WARNING);
      }
      totalCalories += dailyCalories;
    }
    return (totalCalories / WEEKDAYS);
  }

  public double weightChange(Scanner scanner) {
    System.out.println(REQUEST_USER_WEIGHT_DAY_ONE);
    double weightDay1 = getValidDouble(scanner, MIN_WEIGHT, MAX_WEIGHT);
    System.out.println(REQUEST_USER_WEIGHT_DAY_SEVEN);
    double weightDay7 = getValidDouble(scanner, MIN_WEIGHT, MAX_WEIGHT);
    return weightDay7 - weightDay1;
  }

  public void welcomeBack(User user) {
    System.out.println(WELCOME_BACK_MSG + user.Username);
    System.out.println(WELCOME_BACK_MSG2 + user.Goal + WELCOME_BACK_MSG3);
    System.out.println(WELCOME_BACK_MSG4 + user.Calories);
  }

  //TODO: Split up scenarios into different methods. Look up Maps and how to use them
  public void recalibrationSequence(Scanner scanner, User user) {
    welcomeBack(user);
    long averageCalories = averageCalories(scanner);
    double weighChange = weightChange(scanner);
    long paceMultiplier;
    if (user.Pace.equals(PACE_SLOWLY)) {
      paceMultiplier = CALORIES_PER_QUARTER_KG;
    } else if (user.Pace.equals(PACE_NORMAL)) {
      paceMultiplier = CALORIES_PER_HALF_KG;
    } else {
      paceMultiplier = CALORIES_PER_KG;
    }
    long newGoal = newGoalMath(
      newMaintenance(averageCalories, weighChange),
      paceMultiplier
    );
    handleGoal(user, weighChange, newGoal);
  }

  public void handleGoal(User user, double weighChange, long newGoal) {
    TreeMap<Double, String> messages = new TreeMap<>();
    switch (user.Goal) {
      case GOAL_LOSE:
        switch (user.Pace) {
          case PACE_SLOWLY -> {
            messages.put(0.0, GOAL_FAILED_LOSE);
            messages.put(-0.05, GOAL_BARELY_LOST);
            messages.put(-0.1, GOAL_CONGRATS_QUARTER);
            messages.put(-0.5, GOAL_FAST_LOSE);
            messages.put(-1.0, GOAL_TOO_FAST_LOSE);
            messages.put(-2.0, GOAL_WARNING_LOSE);
            messages.put(Double.NEGATIVE_INFINITY, GOAL_FAILED_LOSE);
            break;
          }
          case PACE_NORMAL -> {
            messages.put(0.0, GOAL_FAILED_LOSE);
            messages.put(-0.05, GOAL_BARELY_LOST);
            messages.put(-0.1, GOAL_SLOW_LOSE);
            messages.put(-0.5, GOAL_CONGRATS_HALF);
            messages.put(-1.0, GOAL_FAST_LOSE);
            messages.put(-2.0, GOAL_WARNING_LOSE);
            messages.put(Double.NEGATIVE_INFINITY, GOAL_FAILED_LOSE);
            break;
          }
          case PACE_FAST -> {
            messages.put(0.0, GOAL_FAILED_LOSE);
            messages.put(-0.05, GOAL_BARELY_LOST);
            messages.put(-0.1, GOAL_TOO_SLOW_LOSE);
            messages.put(-0.5, GOAL_SLOW_LOSE);
            messages.put(-1.0, GOAL_CONGRATS_KILO);
            messages.put(-2.0, GOAL_WARNING_LOSE);
            messages.put(Double.NEGATIVE_INFINITY, GOAL_FAILED_LOSE);
            break;
          }
        }
        break;
      case GOAL_MAINTAIN:
        messages.put(-0.05, MAINTAIN_LOSE);
        messages.put(0.05, MAINTAIN_CONGRATS);
        messages.put(Double.POSITIVE_INFINITY, GOAL_FAILED_LOSE);
        break;
      case GOAL_GAIN:
        switch (user.Pace) {
          case PACE_SLOWLY:
            messages.put(0.1, GOAL_BARELY_GAIN);
            messages.put(0.5, GOAL_CONGRATS_QUARTER_GAIN);
            messages.put(1.0, GOAL_FAST_GAIN);
            messages.put(2.0, GOAL_TOO_FAST_GAIN);
            messages.put(Double.POSITIVE_INFINITY, GOAL_WARNING_GAIN);
            messages.put(0.0, GOAL_FAILED_GAIN);
            break;
          case PACE_NORMAL:
            messages.put(0.1, GOAL_BARELY_GAIN);
            messages.put(0.5, GOAL_SLOW_GAIN);
            messages.put(1.0, GOAL_CONGRATS_HALF_GAIN);
            messages.put(2.0, GOAL_FAST_GAIN);
            messages.put(Double.POSITIVE_INFINITY, GOAL_WARNING_GAIN);
            messages.put(0.0, GOAL_FAILED_GAIN);
            break;
          case PACE_FAST:
            messages.put(0.1, GOAL_BARELY_GAIN);
            messages.put(0.5, GOAL_TOO_SLOW_GAIN);
            messages.put(1.0, GOAL_SLOW_GAIN);
            messages.put(2.0, GOAL_CONGRATS_KILO_GAIN);
            messages.put(Double.POSITIVE_INFINITY, GOAL_WARNING_GAIN);
            messages.put(0.0, GOAL_FAILED_GAIN);
            break;
        }
        break;
    }

    Map.Entry<Double, String> entry = messages.floorEntry(weighChange);
    if (entry != null) {
      System.out.println(entry.getValue());
      System.out.println(RECOMMEND_NEW_CALORIES + newGoal);
      updateCalories(user.Username, newGoal, ACCOUNTS_FILE_PATH);
    }
  }

  public static void updateCalories(
    String username,
    long newGoal,
    String filename
  ) {
    try {
      List<String> lines = Files.readAllLines(Paths.get(filename));
      List<String> modifiedLines = new ArrayList<>();

      for (String line : lines) {
        if (line.startsWith(username)) {
          String[] parts = line.split(","); // Assuming fields are comma-separated
          parts[4] = String.valueOf(newGoal); // Assuming the "Calories" field is the third field
          modifiedLines.add(String.join(",", parts));
        } else {
          modifiedLines.add(line);
        }
      }

      Files.write(Paths.get(filename), modifiedLines);
    } catch (IOException e) {
      System.out.println(READING_FROM_FILE_ERROR + e.getMessage());
    }
  }

  public static User getUser(String username, String filename) {
    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
      String line = in.readLine();
      while (line != null) {
        String[] userDetails = line.split(",");
        if (userDetails[0].equals(username)) {
          return new User(
            userDetails[0],
            userDetails[1],
            userDetails[2],
            Long.parseLong(userDetails[3]),
            Long.parseLong(userDetails[4]),
            userDetails[5],
            userDetails[6],
            Integer.parseInt(userDetails[7]),
            Integer.parseInt(userDetails[8]),
            Integer.parseInt(userDetails[9])
          );
        }
        line = in.readLine();
      }
    } catch (IOException e) {
      System.out.println(READING_FROM_FILE_ERROR + e.getMessage());
    }
    return null;
  }

  public User login(Scanner scanner) {
    System.out.println(REQUEST_USERNAME);
    scanner.nextLine();
    while (true) {
      String username = getValidUsername(scanner);
      if (!checkUsernameExists(username, ACCOUNTS_FILE_PATH)) {
        System.out.println(USERNAME_NOT_FOUND);
      } else {
        System.out.println(REQUEST_PASSWORD);
        while (true) {
          String password = scanner.nextLine();
          User user = getUser(username, ACCOUNTS_FILE_PATH);
          if (user != null && password.equals(user.Password)) {
            System.out.println(LOGIN_SUCCESSFULL);
            return user;
          } else {
            System.out.println(INCORRECT_PASSWORD);
          }
        }
      }
    }
  }

  public void runMathSoup(Scanner scanner) {
    switch (displayAccountExist(scanner)) {
      case MENU_YES -> {
        while (true) {
          User user = login(scanner);
          if (user != null) {
            recalibrationSequence(scanner, user);
            break;
          }
        }
      }
      case MENU_NO -> {
        scanner.nextLine();
        createAccount(scanner);
      }
      case MENU_EXIT_SMALL -> {
        System.out.println(EXIT_PROGRAM_MSG);
        System.exit(0);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MathSoup mathsoup = new MathSoup();
    mathsoup.runMathSoup(scanner);
    scanner.close();
  }
}
