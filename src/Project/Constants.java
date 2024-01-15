package Project;

public class Constants {

  public static final int MENU_GOAL_LOSE = 1;
  public static final int MENU_GOAL_MAINTAIN = 2;
  public static final int MENU_GOAL_GAIN = 3;
  public static final int MENU_PACE_SLOW = 1;
  public static final int MENU_PACE_NORMAL = 2;
  public static final int MENU_PACE_FAST = 3;
  public static final int MENU_SEX_MALE = 1;
  public static final int MENU_SEX_FEMALE = 2;
  public static final int MENU_ACTIVITY_SEDENTARY = 1;
  public static final int MENU_ACTIVITY_LIGHT = 2;
  public static final int MENU_ACTIVITY_MODERATE = 3;
  public static final int MENU_ACTIVITY_ACTIVE = 4;
  public static final int MENU_ACTIVITY_VERY_ACTIVE = 5;
  public static final int MENU_EXIT_SMALL = 3;
  public static final int MENU_YES = 1;
  public static final int MENU_NO = 2;
  public static final int WEEKDAYS = 7;
  public static final int WEIGHT_MULTIPLIER = 10;
  public static final double HEIGHT_MULTIPLIER = 6.25;
  public static final int AGE_MULTIPLIER = 5;
  public static final int MALE_ADDITION = 5;
  public static final int FEMALE_SUBTRACTION = 161;
  public static final double ACTIVITY_SEDENTARY_MULTIPLIER = 1.2;
  public static final double ACTIVITY_LIGHT_MULTIPLIER = 1.375;
  public static final double ACTIVITY_MODERATE_MULTIPLIER = 1.55;
  public static final double ACTIVITY_ACTIVE_MULTIPLIER = 1.725;
  public static final double ACTIVITY_VERY_ACTIVE_MULTIPLIER = 1.9;
  public static final int CALORIES_PER_KG = 7700;
  public static final int CALORIES_PER_HALF_KG = 3850;
  public static final int CALORIES_PER_QUARTER_KG = 1925;
  public static final String PACE_SLOWLY = "Slowly";
  public static final String PACE_NORMAL = "Normal";
  public static final String PACE_FAST = "Fast";
  public static final String GOAL_LOSE = "Lose";
  public static final String GOAL_MAINTAIN = "Maintain";
  public static final String GOAL_GAIN = "Gain";
  public static final String USERNAME_PROMPT =
    "Please enter your username(No special characters allowed): ";
  public static final String ACCOUNTS_FILE_PATH = "Project/Accounts.txt";
  public static final String USERNAME_EXISTS_MSG =
    "An account with this username already exists.Try again.";
  public static final String PASSWORD_PROMPT = "Please enter your password";
  public static final String ACCOUNT_CREATED_MSG =
    "Your account has been successfully initialized!\nYour maintenance calories have been estimated to: ";
  public static final String TARGET_CALORIES_MSG =
    "Your target calories, based on your goal have been estimated to: ";
  public static final String ADHERENCE_MSG =
    "Please adhere to your target for the next 7 days and then come back.\nMake sure to note your daily calories and weight for every day.";
  public static final String INVALID_USERNAME_PROMPT =
    "Invalid username. Please enter a username that contains only alphanumeric characters.";
  public static final int PASSWORD_MIN_LENGTH = 9;
  public static final int PASSWORD_MAX_LENGTH = 20;
  public static final String PASSWORD_LENGTH_PROMPT =
    "Please make sure your password has at least " +
    PASSWORD_MIN_LENGTH +
    " characters and at most " +
    PASSWORD_MAX_LENGTH +
    " characters";
  public static final String INVALID_NUMBER_PROMPT =
    "Invalid number. Please enter a number in the specified range: ";
  public static final String INVALID_NUMERICAL_INPUT =
    "Please enter a valid number";
  public static final String REQUEST_USER_WEIGHT =
    "Please enter your current weight in Kilograms";
  public static final int MIN_WEIGHT = 30;
  public static final int MAX_WEIGHT = 500;
  public static final String REQUEST_USER_HEIGHT =
    "Please enter your current height in Centimeters";
  public static final int MIN_HEIGHT = 55;
  public static final int MAX_HEIGHT = 251;
  public static final String REQUEST_USER_AGE =
    "Please enter your current age(ONLY USERS OVER 18 ALLOWED)";
  public static final int MIN_AGE = 18;
  public static final int MAX_AGE = 120;
  public static final String ACCEPTED_RANGE_USERNAME = "[^a-zA-Z0-9]";
  public static final String DISPLAY_GOAL_MENU =
    "What do you wish to do:\n1.Lose Weight\n2.Maintain Weight\n3.Gain Weight";
  public static final String INVALID_MENU_CHOICE = "Invalid choice";
  public static final String DISPLAY_PACE_MENU =
    "How fast do you want to reach your goal:\n1.Slowly\n2.Normal\n3.Fast";
  public static final String DISPLAY_SEX_MENU =
    "What is your birth sex?\n1.Male\n2.Female";
  public static final String USER_SEX_MALE = "Male";
  public static final String USER_SEX_FEMALE = "Female";
  public static final String DISPLAY_ACTIVITY_MENU =
    "How active are you?\n1.Sedentary\n2.Lightly Active\n3.Moderately Active\n4.Active\n5.Very Active";
  public static final String USER_ACTIVITY_SEDENTARY = "Sedentary";
  public static final String USER_ACTIVITY_LIGHT = "LightlyActive";
  public static final String USER_ACTIVITY_MODERATE = "ModeratelyActive";
  public static final String USER_ACTIVITY_ACTIVE = "Active";
  public static final String USER_ACTIVITY_VERY_ACTIVE = "VeryActive";
  public static final String DISPLAY_WELCOME_QUESTION =
    "Welcome to MathSoup!\nDo you have an account?\n1.Yes\n2.No";
  public static final String DISPLAY_STARTING_MENU = "1.Yes\n2.No\n3.Exit";
  public static final String UNEXPECTED_VALUE_ERROR = "Unexpected value: ";
  public static final String STORING_TO_FILE_ERROR = "Error storing to file ";
  public static final String READING_FROM_FILE_ERROR =
    "Error reading from file ";
  public static final String REQUEST_USER_CALORIES_DAY =
    "Please enter your calories for day ";
  public static final int MIN_ACCEPTED_CALORIES = 0;
  public static final int MAX_ACCEPTED_CALORIES = 10000;
  public static final int MIN_RECOMMENDED_CALORIES = 1200;
  public static final int MAX_RECOMMENDED_CALORIES = 5000;
  public static final String LOW_END_CALOERIE_WARNING =
    "Warning : You are eating less than 1200 calories a day. This is not recommended";
  public static final String HIGH_END_CALOERIE_WARNING =
    "Warning : You are eating more than 5000 calories a day. This is not recommended";
  public static final String REQUEST_USER_WEIGHT_DAY_ONE =
    "Please enter your weight for day 1";
  public static final String REQUEST_USER_WEIGHT_DAY_SEVEN =
    "Please enter your weight for day 7";
  public static final String WELCOME_BACK_MSG = "Welcome back ";
  public static final String WELCOME_BACK_MSG2 = "Hope your goal to ";
  public static final String WELCOME_BACK_MSG3 = " weight is going well!";
  public static final String WELCOME_BACK_MSG4 =
    "Your daily calorie intake for the past 7 days was set to: ";
  public static final String GOAL_FAILED_LOSE =
    "Oh no,looks like you've gained weight, lets recalibrate!";
  public static final String GOAL_BARELY_LOST =
    "Looks like you've barely lost any weight,lets recalibrate!";
  public static final String GOAL_CONGRATS_QUARTER =
    "Congratulations! You are on track to lose 0.25kg per week. Keep up the good work!";
  public static final String GOAL_FAST_LOSE =
    "You are losing weight at a faster pace than expected";
  public static final String GOAL_TOO_FAST_LOSE =
    "You are losing weight at a much faster pace than expected";
  public static final String GOAL_WARNING_LOSE =
    "Warning: You are losing weight too fast. Please try to eat more";
  public static final String GOAL_SLOW_LOSE =
    "You are losing weight at a slower pace than expected";
  public static final String GOAL_CONGRATS_HALF =
    "Congratulations! You are on track to lose 0.5kg per week. Keep up the good work!";
  public static final String GOAL_CONGRATS_KILO =
    "Congratulations! You are on track to lose 1kg per week. Keep up the good work!";
  public static final String GOAL_TOO_SLOW_LOSE =
    "You are losing weight at a much slower pace than expected";
  public static final String MAINTAIN_CONGRATS =
    "Looks like you are on track with your goal, keep up the good work!";
  public static final String MAINTAIN_LOSE =
    "Looks like you've lost weight, let's recalibrate!";
  public static final String GOAL_BARELY_GAIN =
    "Looks like you've barely gained any weight,lets recalibrate!";
  public static final String GOAL_CONGRATS_QUARTER_GAIN =
    "Congratulations! You are on track to gain 0.25kg per week. Keep up the good work!";
  public static final String GOAL_CONGRATS_HALF_GAIN =
    "Congratulations! You are on track to gain 0.5kg per week. Keep up the good work!";
  public static final String GOAL_CONGRATS_KILO_GAIN =
    "Congratulations! You are on track to gain 1kg per week. Keep up the good work!";
  public static final String GOAL_FAST_GAIN =
    "You are gaining weight at a faster pace than expected";
  public static final String GOAL_TOO_FAST_GAIN =
    "You are gaining weight at a much faster pace than expected";
  public static final String GOAL_WARNING_GAIN =
    "Warning: You are gaining weight too fast. Please try to eat less";
  public static final String GOAL_FAILED_GAIN =
    "Oh no,looks like you've lost weight, lets recalibrate!";
  public static final String GOAL_SLOW_GAIN =
    "You are gaining weight at a slower pace than expected";
  public static final String GOAL_TOO_SLOW_GAIN =
    "You are gaining weight at a much slower pace than expected";
  public static final String RECOMMEND_NEW_CALORIES =
    "We recommend you tailor your daily intake to : ";
  public static final String REQUEST_USERNAME = "Please enter your username";
  public static final String USERNAME_NOT_FOUND =
    "This username does not exist, please try again.";
  public static final String REQUEST_PASSWORD = "Please enter your password";
  public static final String LOGIN_SUCCESSFULL = "Login successful!";
  public static final String INCORRECT_PASSWORD =
    "Incorrect password, please try again.";
  public static final String EXIT_PROGRAM_MSG = "Thank you for using MathSoup!";
}
