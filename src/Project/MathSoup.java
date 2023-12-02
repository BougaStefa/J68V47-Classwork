package Project;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MathSoup {

  //! Constants for the menu options
  private static final int MENU_GOAL_LOSE = 1;
  private static final int MENU_GOAL_MAINTAIN = 2;
  private static final int MENU_GOAL_GAIN = 3;
  private static final int MENU_PACE_SLOW = 1;
  private static final int MENU_PACE_NORMAL = 2;
  private static final int MENU_PACE_FAST = 3;
  private static final int MENU_SEX_MALE = 1;
  private static final int MENU_SEX_FEMALE = 2;
  private static final int MENU_ACTIVITY_SEDENTARY = 1;
  private static final int MENU_ACTIVITY_LIGHT = 2;
  private static final int MENU_ACTIVITY_MODERATE = 3;
  private static final int MENU_ACTIVITY_ACTIVE = 4;
  private static final int MENU_ACTIVITY_VERY_ACTIVE = 5;
  private static final int MENU_EXIT = 4;
  private static final int MENU_EXIT_BIG = 6;
  private static final int MENU_EXIT_SMALL = 3;
  private static final int MENU_YES = 1;
  private static final int MENU_NO = 2;
  private static final int WEEKDAYS = 7;
  private static final int WEIGHT_MULTIPLIER = 10;
  private static final double HEIGHT_MULTIPLIER = 6.25;
  private static final int AGE_MULTIPLIER = 5;
  private static final int MALE_ADDITION = 5;
  private static final int FEMALE_SUBTRACTION = 161;
  private static final double ACTIVITY_SEDENTARY_MULTIPLIER = 1.2;
  private static final double ACTIVITY_LIGHT_MULTIPLIER = 1.375;
  private static final double ACTIVITY_MODERATE_MULTIPLIER = 1.55;
  private static final double ACTIVITY_ACTIVE_MULTIPLIER = 1.725;
  private static final double ACTIVITY_VERY_ACTIVE_MULTIPLIER = 1.9;
  private static final int CALORIES_PER_KG = 7700;
  private static final int CALORIES_PER_HALF_KG = 3850;
  private static final int CALORIES_PER_QUARTER_KG = 1925;

  //!Used to store values from the file

  //!Input validation methods
  //?Methods getValidNumber and getValidDouble could be combined into one method
  //TODO: Combine getValidNumber and getValidDouble into one method
  public static int getValidNumber(Scanner scanner, int min, int max) {
    int number;
    while (true) {
      try {
        number = scanner.nextInt();
        if (number >= min && number <= max) {
          return number;
        } else {
          System.out.println("Invalid number. Please try again.");
        }
      } catch (java.util.InputMismatchException e) {
        System.out.println("Please enter a valid number");
        scanner.nextLine(); // clear input
      }
    }
  }

  public static double getValidDouble(Scanner scanner, double min, double max) {
    double number;
    while (true) {
      try {
        number = scanner.nextDouble();
        if (number >= min && number <= max) {
          return number;
        } else {
          System.out.println("Invalid number. Please try again.");
        }
      } catch (java.util.InputMismatchException e) {
        System.out.println("Please enter a valid number");
        scanner.nextLine(); // clear input
      }
    }
  }

  //!Asks for the user's weight, height and age and validates them using the getValidNumber method
  //!Most limits are set based on extreme human cases
  public static int getValidWeight(Scanner scanner) {
    System.out.println("Please enter your current weight in Kilograms");
    return getValidNumber(scanner, 30, 500);
  }

  public static int getValidHeight(Scanner scanner) {
    System.out.println("Please enter your current height in Centimeters");
    return getValidNumber(scanner, 55, 251);
  }

  public static int getValidAge(Scanner scanner) {
    System.out.println(
      "Please enter your current age(ONLY USERS OVER 18 ALLOWED)"
    );
    return getValidNumber(scanner, 18, 116);
  }

  //!If anything that is not in the specified range is detected then the user is asked to enter a valid username
  public String getValidUsername(Scanner scanner) {
    while (true) {
      String username = scanner.nextLine();
      String acceptedChars = "[^a-zA-Z0-9]";
      Pattern pattern = Pattern.compile(acceptedChars);
      if (pattern.matcher(username).find()) {
        System.out.println("Please enter a valid username");
      } else {
        return username;
      }
    }
  }

  //!Password length is validated in terms of length
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
        System.out.printf(
          "Please make sure your password has at least %d characters and at most %d%n",
          minLength,
          maxLength
        );
      }
    }
  }

  //!Menu Methods
  //TODO: REMOVE SWITCH CASES AND SIMPIFY TO JUST A PRINTOUT AND A GETVALIDNUMBER RETURNED. MIGHT ALSO NEED TO REMOVE CONSTANTS
  public String displayGoalMenu(Scanner scanner) {
    System.out.printf(
      "What do you wish to do:%n1.Lose Weight%n2.Maintain Weight%n3.Gain Weight%n"
    );
    int choice = getValidNumber(scanner, 1, 4);
    return switch (choice) {
      case MENU_GOAL_LOSE -> "Lose";
      case MENU_GOAL_MAINTAIN -> "Maintain";
      case MENU_GOAL_GAIN -> "Gain";
      //Impossible scenario
      default -> throw new IllegalArgumentException("Invalid Choice " + choice);
    };
  }

  public String displayPaceMenu(Scanner scanner) {
    System.out.printf(
      "Pick your own pace:%n1.Slowly(0.25kg per week)%n2.Normal(0.5kg per week)%n" +
      "3.Fast(1kg per week)%n"
    );
    int choice = getValidNumber(scanner, 1, 3);
    return switch (choice) {
      case MENU_PACE_SLOW -> "Slowly";
      case MENU_PACE_NORMAL -> "Normal";
      case MENU_PACE_FAST -> "Fast";
      //Impossible scenario
      default -> throw new IllegalArgumentException("Invalid Choice " + choice);
    };
  }

  public String displaySexMenu(Scanner scanner) {
    System.out.printf("What is your birth sex?%n1.Male%n2.Female%n");
    return switch (getValidNumber(scanner, 1, 2)) {
      case MENU_SEX_MALE -> "Male";
      case MENU_SEX_FEMALE -> "Female";
      //Impossible scenario
      default -> throw new IllegalArgumentException("Invalid Choice");
    };
  }

  public String displayActivityMenu(Scanner scanner) {
    System.out.printf(
      "What is your current activity level?%n1.Sedentary%n2.Lightly Active%n" +
      "3.Moderately Active%n4.Active%n5.Very Active%n"
    );
    int choice = getValidNumber(scanner, 1, 5);
    return switch (choice) {
      case MENU_ACTIVITY_SEDENTARY -> "Sedentary";
      case MENU_ACTIVITY_LIGHT -> "LightlyActive";
      case MENU_ACTIVITY_MODERATE -> "Moderate";
      case MENU_ACTIVITY_ACTIVE -> "Active";
      case MENU_ACTIVITY_VERY_ACTIVE -> "VeryActive";
      //Impossible scenario
      default -> throw new IllegalArgumentException("Invalid Choice " + choice);
    };
  }

  public int displayAccountExist(Scanner scanner) {
    System.out.printf("1.Yes%n2.No%n");
    int choice = getValidNumber(scanner, 1, 2);
    return switch (choice) {
      case MENU_YES -> MENU_YES;
      case MENU_NO -> MENU_NO;
      //Impossible scenario
      default -> throw new IllegalArgumentException("Invalid Choice " + choice);
    };
  }

  //!Calorie Calculations
  public long caloricMaintenance(
    String sex,
    int weight,
    int height,
    int age,
    String activity
  ) {
    double caloricMaintenance;
    double activityMultiplier =
      switch (activity) {
        case ("Sedentary") -> ACTIVITY_SEDENTARY_MULTIPLIER;
        case ("LightlyActive") -> ACTIVITY_LIGHT_MULTIPLIER;
        case ("Moderate") -> ACTIVITY_MODERATE_MULTIPLIER;
        case ("Active") -> ACTIVITY_ACTIVE_MULTIPLIER;
        case ("VeryActive") -> ACTIVITY_VERY_ACTIVE_MULTIPLIER;
        //Impossible scenario
        default -> throw new IllegalStateException(
          "Unexpected value: " + activity
        );
      };
    if (sex.equals("Male")) {
      caloricMaintenance =
        Math.round(
          (
            (WEIGHT_MULTIPLIER * weight) +
            (HEIGHT_MULTIPLIER * height) -
            (AGE_MULTIPLIER * age) +
            MALE_ADDITION
          ) *
          activityMultiplier
        );
    } else {
      caloricMaintenance =
        Math.round(
          (
            (WEIGHT_MULTIPLIER * weight) +
            (HEIGHT_MULTIPLIER * height) -
            (AGE_MULTIPLIER * age) -
            FEMALE_SUBTRACTION
          ) *
          activityMultiplier
        );
    }
    return Math.round(caloricMaintenance);
  }

  public long caloriesBasedOnGoal(String goal, String pace, long maintenance) {
    int paceMultiplier =
      switch (pace) {
        case ("Slowly") -> CALORIES_PER_QUARTER_KG;
        case ("Normal") -> CALORIES_PER_HALF_KG;
        case ("Fast") -> CALORIES_PER_KG;
        //Impossible scenario
        default -> throw new IllegalStateException("Unexpected value: " + pace);
      };
    return switch (goal) {
      case "Lose" -> maintenance - paceMultiplier / WEEKDAYS;
      case "Maintain" -> maintenance;
      case "Gain" -> maintenance + paceMultiplier / WEEKDAYS;
      //Impossible scenario
      default -> throw new IllegalArgumentException("Invalid Choice " + goal);
    };
  }

  //TODO: change the way account information is stored
  public void createAccount(Scanner scanner) {
    boolean accountCreated = false;
    System.out.println(
      "Please enter your username(No special characters allowed): "
    );
    while (!accountCreated) {
      String username = getValidUsername(scanner);
      if (checkUsernameExists(username, "Accounts.txt")) {
        System.out.println(
          "An account with this username already exists.Try again."
        );
      } else {
        accountCreated = true;
        System.out.println("Please enter a password(9-20 characters long)");
        String password = getValidPassword(scanner, 9, 20);
        String sex = displaySexMenu(scanner);
        int weight = getValidWeight(scanner);
        int height = getValidHeight(scanner);
        int age = getValidAge(scanner);
        String goal = displayGoalMenu(scanner);
        String pace = displayPaceMenu(scanner);
        String activity = displayActivityMenu(scanner);
        long maintenance = caloricMaintenance(
          sex,
          weight,
          height,
          age,
          activity
        );
        long calories = caloriesBasedOnGoal(goal, pace, maintenance);
        User newUser = new User(
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
        storeUser(newUser, "Accounts.txt");
        System.out.println(
          "Your account has been successfully initialized!" +
          "\n" +
          "Your maintenance calories have been estimated to: " +
          maintenance
        );
        if (!goal.equals("Maintain")) {
          System.out.println(
            "Your target calories,based on your goal have been estimated to: " +
            calories
          );
        }
        System.out.println(
          "Please adhere to your target for the next 7 days and then come back." +
          "\n" +
          "Make sure to note your daily calories and weight for every day."
        );
      }
    }
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
      System.out.println("Error storing to file" + e.getMessage());
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
      System.out.println("Error reading file: " + e.getMessage());
    }
    return false;
  }

  public long newMaintenance(long averageCalories, double weightLoss) {
    // New maintenance is old maintenance - (7700*weight change per week)
    return Math.round(averageCalories - ((7700 * weightLoss) / WEEKDAYS));
  }

  public long newGoalMath(long newMaintenance, long pace) {
    return Math.round(newMaintenance + (float) pace / WEEKDAYS);
  }

  public long averageCalories(Scanner scanner) {
    long totalCalories = 0;
    long dailyCalories = 0;
    for (int i = 0; i < WEEKDAYS; i++) {
      System.out.printf("Please enter your calories for day %d%n", i + 1);
      dailyCalories = getValidNumber(scanner, 0, 10000);
      // if the value entered is less than 1200 a warning is printed, values as low as
      // 1000 are accepted though
      if (dailyCalories < 1200) {
        System.out.println(
          "Warning: You are eating less than 1200 calories a day." +
          " This is not recommended."
        );
      } else if (dailyCalories > 5000) {
        System.out.println(
          "Warning: You are eating more than 5000 calories a day." +
          " This is not recommended."
        );
      }
      totalCalories += dailyCalories;
    }
    return (totalCalories / WEEKDAYS);
  }

  public double weightChange(Scanner scanner) {
    System.out.println("Please enter your weight for day 1");
    double weightDay1 = getValidDouble(scanner, 30, 500);
    System.out.println("Please enter your weight for day 7");
    double weightDay7 = getValidDouble(scanner, 30, 500);
    return weightDay7 - weightDay1;
  }

  public void recalibrationSequence(Scanner scanner) {
    // Switch statement for all possible scenarios
    // If the user's weight loss aligns with their goal and pace then a message
    // congratulating them and telling them
    // to keep up the good work is printed
    // if not then their new maintenance calories are calculated and printed
    // if the user has lost more than 1kg per week then a warning is printed
    long averageCalories = averageCalories(scanner);
    double weighChange = weightChange(scanner);
    long newGoal = newGoalMath(
      newMaintenance(averageCalories, weighChange),
      userPaceNumber
    );
    System.out.println("Debug: User Pace Number is " + userPaceNumber);
    System.out.println(
      "Debug: new maintenance is " +
      newMaintenance(averageCalories, weighChange)
    );
    System.out.println("Debug: Average calories is " + averageCalories);
    System.out.println("Debug: Weight change is " + weighChange);
    switch (userGoal) {
      case "Lose" -> {
        switch (userPace) {
          case "Slowly" -> {
            if (weighChange <= 0 && weighChange > -0.05) {
              System.out.println(
                "Looks like you've  barely lost any weight,lets recalibrate!"
              );
              System.out.println("Your calorie recommendation is: " + newGoal);
            } else if (weighChange <= -0.1 && weighChange > -0.5) {
              System.out.println(
                "Congratulations! You are on track to lose 0.25kg per week." +
                " Keep up the good work!"
              );
              System.out.println(
                "Here's a new calorie recommendation if you want to further tailor " +
                "your progress to how you've responded so far and more in line with your pace: " +
                newGoal
              );
            } else if (weighChange <= -0.5 && weighChange > -1) {
              System.out.println(
                "You are losing weight at a faster pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange <= -1 && weighChange > -2) {
              System.out.println(
                "You are losing weight at a much faster pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange <= -2) {
              System.out.println(
                "Warning: You are losing weight too fast. Please try to eat more." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange > 0) {
              System.out.println(
                "Oh no,looks like you've gained weight, lets recalibrate!"
              );
              System.out.println(
                "We recommend you tailor your intake to " + newGoal
              );
            }
          }
          case "Normal" -> {
            if (weighChange <= 0 && weighChange > -0.05) {
              System.out.println(
                "Looks like you've barely lost any weight,lets recalibrate!"
              );
              System.out.println("Your calorie recommendation is: " + newGoal);
            } else if (weighChange <= -0.1 && weighChange > -0.5) {
              System.out.println(
                "You are losing weight at a slower pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange <= -0.5 && weighChange > -0.99) {
              System.out.println(
                "Congratulations! You are on track to lose 0.5kg per week." +
                " Keep up the good work!"
              );
              System.out.println(
                "Here's a new calorie recommendation if you want to further tailor " +
                "your progress to how you've responded so far and more in line with your pace: " +
                newGoal
              );
            } else if (weighChange <= -1 && weighChange > -2) {
              System.out.println(
                "You are losing weight at a faster pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange <= -2) {
              System.out.println(
                "Warning: You are losing weight too fast. Please try to eat more." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange > 0) {
              System.out.println(
                "Oh no,looks like you've gained weight, lets recalibrate!"
              );
              System.out.println(
                "We recommend you tailor your intake to " + newGoal
              );
            }
          }
          case "Fast" -> {
            if (weighChange <= 0 && weighChange > -0.05) {
              System.out.println(
                "Looks like you've barely lost any weight,lets recalibrate!"
              );
              System.out.println("Your calorie recommendation is: " + newGoal);
            } else if (weighChange <= -0.1 && weighChange > -0.5) {
              System.out.println(
                "You are losing weight at a much slower pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange <= -0.5 && weighChange > -1) {
              System.out.println(
                "You are losing weight at a slower pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange <= -1 && weighChange > -2) {
              System.out.println(
                "Congratulations! You are on track to lose 1kg per week." +
                " Keep up the good work!"
              );
              System.out.println(
                "Here's a new calorie recommendation if you want to further tailor " +
                "your progress to how you've responded so far and more in line with your pace: " +
                newGoal
              );
            } else if (weighChange <= -2) {
              System.out.println(
                "Warning: You are losing weight too fast. Please try to eat more." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange > 0) {
              System.out.println(
                "Oh no,looks like you've gained weight, lets recalibrate!"
              );
              System.out.println(
                "We recommend you tailor your intake to " + newGoal
              );
            }
          }
        }
      }
      case "Maintain" -> {
        if (weighChange >= -0.05 && weighChange <= 0) {
          System.out.println(
            "Looks like you are on track with your goal, keep up the good work!"
          );
          System.out.println(
            "Here's a new calorie recommendation if you want to further tailor " +
            "your progress to how you've responded so far and more in line with your pace: " +
            newGoal
          );
        } else if (weighChange > 0) {
          System.out.println(
            "Looks like you've gained weight, lets recalibrate!"
          );
          System.out.println(
            "We recommend you tailor your intake to " + newGoal
          );
        } else {
          System.out.println(
            "Looks like you've lost weight, lets recalibrate!"
          );
          System.out.println(
            "We recommend you tailor your intake to " + newGoal
          );
        }
      }
      case "Gain" -> {
        switch (userPace) {
          case "Slowly" -> {
            if (weighChange >= 0 && weighChange < 0.1) {
              System.out.println(
                "Looks like you've barely gained any weight,lets recalibrate!"
              );
              System.out.println("Your calorie recommendation is: " + newGoal);
            } else if (weighChange >= 0.1 && weighChange < 0.5) {
              System.out.println(
                "Congratulations! You are on track to gain 0.25kg per week." +
                " Keep up the good work!"
              );
              System.out.println(
                "Here's a new calorie recommendation if you want to further tailor " +
                "your progress to how you've responded so far and more in line with your pace: " +
                newGoal
              );
            } else if (weighChange >= 0.5 && weighChange < 1) {
              System.out.println(
                "You are gaining weight at a faster pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange >= 1 && weighChange < 2) {
              System.out.println(
                "You are gaining weight at a much faster pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange >= 2) {
              System.out.println(
                "Warning: You are gaining weight too fast. Please try to eat less." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange < 0) {
              System.out.println(
                "Oh no,looks like you've lost weight, lets recalibrate!"
              );
              System.out.println(
                "We recommend you tailor your intake to " + newGoal
              );
            }
          }
          case "Normal" -> {
            if (weighChange >= 0 && weighChange < 0.1) {
              System.out.println(
                "Looks like you've barely gained any weight,lets recalibrate!"
              );
              System.out.println("Your calorie recommendation is: " + newGoal);
            } else if (weighChange >= 0.1 && weighChange < 0.5) {
              System.out.println(
                "You are gaining weight at a slower pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange >= 0.5 && weighChange < 1) {
              System.out.println(
                "Congratulations! You are on track to gain 0.5kg per week." +
                " Keep up the good work!"
              );
              System.out.println(
                "Here's a new calorie recommendation if you want to further tailor " +
                "your progress to how you've responded so far and more in line with your pace: " +
                newGoal
              );
            } else if (weighChange >= 1 && weighChange < 2) {
              System.out.println(
                "You are gaining weight at a faster pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange >= 2) {
              System.out.println(
                "Warning: You are gaining weight too fast. Please try to eat less." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange < 0) {
              System.out.println(
                "Oh no,looks like you've lost weight, lets recalibrate!"
              );
              System.out.println(
                "We recommend you tailor your intake to " + newGoal
              );
            }
          }
          case "Fast" -> {
            if (weighChange >= 0 && weighChange < 0.1) {
              System.out.println(
                "Looks like you've barely gained any weight,lets recalibrate!"
              );
              System.out.println("Your calorie recommendation is: " + newGoal);
            } else if (weighChange >= 0.1 && weighChange < 0.5) {
              System.out.println(
                "You are gaining weight at a much slower pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange >= 0.5 && weighChange < 1) {
              System.out.println(
                "You are gaining weight at a slower pace than expected." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange >= 1 && weighChange < 2) {
              System.out.println(
                "Congratulations! You are on track to gain 1kg per week." +
                " Keep up the good work!"
              );
              System.out.println(
                "Here's a new calorie recommendation if you want to further tailor " +
                "your progress to how you've responded so far and more in line with your pace: " +
                newGoal
              );
            } else if (weighChange >= 2) {
              System.out.println(
                "Warning: You are gaining weight too fast. Please try to eat less." +
                " We recommend you tailor your intake to " +
                newGoal
              );
            } else if (weighChange < 0) {
              System.out.println(
                "Oh no,looks like you've lost weight, lets recalibrate!"
              );
              System.out.println(
                "We recommend you tailor your intake to " + newGoal
              );
            }
          }
        }
      }
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
      System.out.println("Error reading file: " + e.getMessage());
    }
    return null;
  }

  public boolean login(Scanner scanner) {
    System.out.println("Please enter your username");
    String username = getValidUsername(scanner);
    while (true) {
      if (!checkUsernameExists(username, "Accounts.txt")) {
        System.out.println("This username does not exist,please try again");
      } else {
        User user = getUser(username, "Accounts.txt");
        if (user != null) {
          System.out.println("Please enter your password");
          String password = getValidPassword(scanner, 9, 20);
          if (password.equals(user.Password)) {
            System.out.println("Login successful!");
            return true;
          } else {
            System.out.println("Incorrect password,please try again");
          }
        }
      }
    }
  }

  public void runMathSoup(Scanner scanner) {
    System.out.println("Welcome to MathSoup, do you have an account with us?");
    int choice = displayAccountExist(scanner);
    scanner.nextLine();
    switch (choice) {
      case MENU_YES -> {
        while (true) {
          if (login(scanner)) {
            recalibrationSequence(scanner);
            break;
          }
        }
      }
      case MENU_NO -> {
        createAccount(scanner);
      }
      case MENU_EXIT_SMALL -> {
        System.out.println("Goodbye!");
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
