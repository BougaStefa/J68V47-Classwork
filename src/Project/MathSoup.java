package Project;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MathSoup {
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

    private double maintenanceCalories;
    private String currentUsername;
    private String userGoal;
    private String userPace;
    private int userPaceNumber;

    private static final int WEEKDAYS = 7;

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


    public static int getValidWeight(Scanner scanner) {
        System.out.println("Please enter your current weight in Kilograms");
        return getValidNumber(scanner, 30, 500);
    }

    public static int getValidHeight(Scanner scanner) {
        System.out.println("Please enter your current height in Centimeters");
        return getValidNumber(scanner, 55, 251);
    }

    public static int getValidAge(Scanner scanner) {
        System.out.println("Please enter your current age(ONLY USERS OVER 18 ALLOWED)");
        return getValidNumber(scanner, 18, 116);
    }

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

    public String getValidPassword(Scanner scanner, int minLength, int maxLength) {
        while (true) {
            String password = scanner.nextLine();
            if (password.length() >= minLength && password.length() <= maxLength) {
                return password;
            } else {
                System.out.printf("Please make sure your password has at least %d characters and at most %d%n",
                        minLength, maxLength);
            }
        }
    }

    public int displayGoalMenu(Scanner scanner) {
        System.out.printf("What do you wish to do:%n1.Lose Weight%n2.Maintain Weight%n3.Gain Weight%n4.Exit%n");
        int choice = getValidNumber(scanner, 1, 4);
        return switch (choice) {
            case MENU_GOAL_LOSE -> 1;
            case MENU_GOAL_MAINTAIN -> 2;
            case MENU_GOAL_GAIN -> 3;
            case MENU_EXIT -> {
                System.out.println("Goodbye!");
                System.exit(0);
                yield 0;
            }
            default -> 0;
        };
    }

    public int displayPaceMenu(Scanner scanner) {
        System.out.printf("Pick your own pace:%n1.Slowly(0.25kg per week)%n2.Normal(0.5kg per week)%n" +
                "3.Fast(1kg per week)%n");
        int choice = getValidNumber(scanner, 1, 3);
        //Impossible scenario
        return switch (choice) {
            case MENU_PACE_SLOW -> {
                userPace = "Slowly";
                yield 1925;
            }
            case MENU_PACE_NORMAL -> {
                userPace = "Normal";
                yield 3850;
            }
            case MENU_PACE_FAST -> {
                userPace = "Fast";
                yield 7700;
            }
            default -> 0;
        };
    }

    public int displaySexMenu(Scanner scanner) {
        System.out.printf("What is your birth sex?%n1.Male%n2.Female%n3.Exit%n");
        int choice = getValidNumber(scanner, 1, 3);
        return switch (choice) {
            case MENU_SEX_MALE -> 1;
            case MENU_SEX_FEMALE -> 2;
            case MENU_EXIT_SMALL -> {
                System.out.println("Goodbye!");
                System.exit(0);
                yield 0;
            }
            default -> 0;
        };
    }

    public double displayActivityMenu(Scanner scanner) {
        System.out.printf("What is your current activity level?%n1.Sedentary%n2.Lightly Active%n" +
                "3.Moderately Active%n4.Active%n5.Very Active%n6.Exit%n");
        int choice = getValidNumber(scanner, 1, 6);
        return switch (choice) {
            case MENU_ACTIVITY_SEDENTARY -> 1.2;
            case MENU_ACTIVITY_LIGHT -> 1.375;
            case MENU_ACTIVITY_MODERATE -> 1.55;
            case MENU_ACTIVITY_ACTIVE -> 1.725;
            case MENU_ACTIVITY_VERY_ACTIVE -> 1.9;
            case MENU_EXIT_BIG -> {
                System.out.println("Goodbye!");
                System.exit(0);
                yield 0;
            }
            default -> 0;
        };
    }

    public int displayAccountExist(Scanner scanner) {
        System.out.printf("1.Yes%n2.No%n3.Exit%n");
        int choice = getValidNumber(scanner, 1, 3);
        return switch (choice) {
            case MENU_YES -> 1;
            case MENU_NO -> 2;
            case MENU_EXIT_SMALL -> {
                System.out.println("Goodbye!");
                System.exit(0);
                yield 0;
            }
            default -> 0;
        };
    }

    public double caloricMaintenance(int sex, int weight, int height, int age, double activity) {
        double calories;
        if (sex == 1) {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) + 5) * activity;
        } else {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) - 161) * activity;
        }
        return calories;
    }

    public void initialMessage(Scanner scanner) {
        System.out.println("Let us proceed with your initial calorie recommendation. Please answer" +
                " the following questions: ");
        maintenanceCalories = Math.round(caloricMaintenance(displaySexMenu(scanner), getValidWeight(scanner),
                getValidHeight(scanner), getValidAge(scanner), displayActivityMenu(scanner)));
        try (PrintWriter out = new PrintWriter(new FileWriter(currentUsername + ".txt", true))) {
            //New line in the file.Without it maintenance saves on the same line as password
            out.print("Maintenance:" + maintenanceCalories);
        } catch (IOException e) {
            System.out.println("Error storing to file" + e.getMessage());
        }
        System.out.printf("Based on that information your daily maintenance calories are: %.0f%n",
                maintenanceCalories);
        scanner.nextLine();
    }

    public double caloriesBasedOnGoal(int goal, int pace, double maintenance) {
        return switch (goal) {
            case MENU_GOAL_LOSE -> maintenance - (double) pace / WEEKDAYS;
            case MENU_GOAL_MAINTAIN -> maintenance;
            case MENU_GOAL_GAIN -> maintenance + (double) pace / WEEKDAYS;
            default -> 0;
        };
    }

    public void createAccount(Scanner scanner) {
        boolean accountCreated = false;
        System.out.println("Please enter your username(No special characters allowed): ");
        while (!accountCreated) {
            String username = getValidUsername(scanner);
            if (checkAccountExist(username)) {
                System.out.println("An account with this username already exists.Try again.");
            } else {
                accountCreated = true;
                System.out.println("Please enter a password(9-20 characters long)");
                String password = getValidPassword(scanner, 9, 20);
                storeAccountToFile(username, password);
                System.out.println("Account created successfully");
                currentUsername = username;
            }
        }
    }

    private void storeAccountToFile(String username, String password) {
        String textName = username + ".txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(textName))) {
            out.println("Username:" + username);
            out.println("Password:" + password);
        } catch (IOException e) {
            System.out.println("Error occurred saving account" + e.getMessage());
        }
    }

    public boolean checkAccountExist(String username) {
        String accountFile = username + ".txt";
        File file = new File(accountFile);
        return file.exists() && !file.isDirectory();
    }

    public void storeGoalToFile(Scanner scanner, String username) {
        int goal = displayGoalMenu(scanner);
        switch (goal) {
            case MENU_GOAL_LOSE -> {
                try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt", true))) {
                    out.println();
                    out.println("Goal:Lose");
                    double newTarget = Math.round(caloriesBasedOnGoal
                            (goal, displayPaceMenu(scanner), maintenanceCalories));
                    out.println("Calories:" + newTarget);
                    out.println("Pace:" + userPace);
                    System.out.println("Your new target calories is: " + newTarget);
                    System.out.println("Your preferences have been stored in your profile.");
                } catch (IOException e) {
                    System.out.println("Error storing to file" + e.getMessage());
                }
            }
            case MENU_GOAL_MAINTAIN -> {
                try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt", true))) {
                    out.println("Goal:Maintain");
                    double newTarget = Math.round(caloriesBasedOnGoal
                            (goal, displayPaceMenu(scanner), maintenanceCalories));
                    out.println("Calories:" + newTarget);
                    out.println("Pace:" + userPace);
                    System.out.println("Your preferences have been stored in your profile.");
                } catch (IOException e) {
                    System.out.println("Error storing to file" + e.getMessage());
                }
            }
            case MENU_GOAL_GAIN -> {
                try (PrintWriter out = new PrintWriter(new FileWriter(username + ".txt", true))) {
                    out.println("Goal:Gain");
                    double newTarget = Math.round(caloriesBasedOnGoal
                            (goal, displayPaceMenu(scanner), maintenanceCalories));
                    out.println("Calories:" + newTarget);
                    out.println("Pace:" + userPace);
                    System.out.println("Your new target calories is: " + newTarget);
                    System.out.println("Your preferences have been stored in your profile.");
                } catch (IOException e) {
                    System.out.println("Error storing to file" + e.getMessage());
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + displayGoalMenu(scanner));
        }
    }

    public long newMaintenance(long averageCalories, double weightLoss) {
        //New maintenance is old maintenance - (7700*weight change per week)
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
            //if the value entered is less than 1200 a warning is printed, values as low as 1000 are accepted though
            if (dailyCalories < 1200) {
                System.out.println("Warning: You are eating less than 1200 calories a day." +
                        " This is not recommended.");
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
        //Switch statement for all possible scenarios
        //If the user's weight loss aligns with their goal and pace then a message congratulating them and telling them
        //to keep up the good work is printed
        //if not then their new maintenance calories are calculated and printed
        //if the user has lost more than 1kg per week then a warning is printed
        long averageCalories = averageCalories(scanner);
        double weighChange = weightChange(scanner);
        long newGoal = newGoalMath(newMaintenance(averageCalories, weighChange), userPaceNumber);
        System.out.println("Debug: User Pace Number is " + userPaceNumber);
        System.out.println("Debug: new maintenance is " + newMaintenance(averageCalories, weighChange));
        System.out.println("Debug: Average calories is " + averageCalories);
        System.out.println("Debug: Weight change is " + weighChange);
        switch (userGoal) {
            case "Lose" -> {
                switch (userPace) {
                    case "Slowly" -> {
                        if (weighChange <= 0 && weighChange > -0.05) {
                            System.out.println("Looks like you've  barely lost any weight,lets recalibrate!");
                            System.out.println("Your calorie recommendation is: " + newGoal);
                        } else if (weighChange <= -0.1 && weighChange > -0.5) {
                            System.out.println("Congratulations! You are on track to lose 0.25kg per week." +
                                    " Keep up the good work!");
                            System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                                    "your progress to how you've responded so far and more in line with your pace: " +
                                    newGoal);
                        } else if (weighChange <= -0.5 && weighChange > -1) {
                            System.out.println("You are losing weight at a faster pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange <= -1 && weighChange > -2) {
                            System.out.println("You are losing weight at a much faster pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange <= -2) {
                            System.out.println("Warning: You are losing weight too fast. Please try to eat more." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange > 0) {
                            System.out.println("Oh no,looks like you've gained weight, lets recalibrate!");
                            System.out.println("We recommend you tailor your intake to " +
                                    newGoal);
                        }
                    }
                    case "Normal" -> {
                        if (weighChange <= 0 && weighChange > -0.05) {
                            System.out.println("Looks like you've barely lost any weight,lets recalibrate!");
                            System.out.println("Your calorie recommendation is: " + newGoal);
                            ;
                        } else if (weighChange <= -0.1 && weighChange > -0.5) {
                            System.out.println("You are losing weight at a slower pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange <= -0.5 && weighChange > -0.99) {
                            System.out.println("Congratulations! You are on track to lose 0.5kg per week." +
                                    " Keep up the good work!");
                            System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                                    "your progress to how you've responded so far and more in line with your pace: " +
                                    newGoal);
                        } else if (weighChange <= -1 && weighChange > -2) {
                            System.out.println("You are losing weight at a faster pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange <= -2) {
                            System.out.println("Warning: You are losing weight too fast. Please try to eat more." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);

                        } else if (weighChange > 0) {
                            System.out.println("Oh no,looks like you've gained weight, lets recalibrate!");
                            System.out.println("We recommend you tailor your intake to " +
                                    newGoal);
                        }
                    }
                    case "Fast" -> {
                        if (weighChange <= 0 && weighChange > -0.05) {
                            System.out.println("Looks like you've barely lost any weight,lets recalibrate!");
                            System.out.println("Your calorie recommendation is: " + newGoal);
                        } else if (weighChange <= -0.1 && weighChange > -0.5) {
                            System.out.println("You are losing weight at a much slower pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange <= -0.5 && weighChange > -1) {
                            System.out.println("You are losing weight at a slower pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange <= -1 && weighChange > -2) {
                            System.out.println("Congratulations! You are on track to lose 1kg per week." +
                                    " Keep up the good work!");
                            System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                                    "your progress to how you've responded so far and more in line with your pace: " +
                                    newGoal);
                        } else if (weighChange <= -2) {
                            System.out.println("Warning: You are losing weight too fast. Please try to eat more." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange > 0) {
                            System.out.println("Oh no,looks like you've gained weight, lets recalibrate!");
                            System.out.println("We recommend you tailor your intake to " +
                                    newGoal);
                        }
                    }
                }
            }
            case "Maintain" -> {
                if (weighChange >= -0.05 && weighChange <= 0) {
                    System.out.println("Looks like you are on track with your goal, keep up the good work!");
                    System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                            "your progress to how you've responded so far and more in line with your pace: " +
                            newGoal);
                } else if (weighChange > 0) {
                    System.out.println("Looks like you've gained weight, lets recalibrate!");
                    System.out.println("We recommend you tailor your intake to " +
                            newGoal);
                } else {
                    System.out.println("Looks like you've lost weight, lets recalibrate!");
                    System.out.println("We recommend you tailor your intake to " +
                            newGoal);
                }
            }
            case "Gain" -> {
                switch (userPace) {
                    case "Slowly" -> {
                        if (weighChange >= 0 && weighChange < 0.1) {
                            System.out.println("Looks like you've barely gained any weight,lets recalibrate!");
                            System.out.println("Your calorie recommendation is: " + newGoal);
                        } else if (weighChange >= 0.1 && weighChange < 0.5) {
                            System.out.println("Congratulations! You are on track to gain 0.25kg per week." +
                                    " Keep up the good work!");
                            System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                                    "your progress to how you've responded so far and more in line with your pace: " +
                                    newGoal);
                        } else if (weighChange >= 0.5 && weighChange < 1) {
                            System.out.println("You are gaining weight at a faster pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange >= 1 && weighChange < 2) {
                            System.out.println("You are gaining weight at a much faster pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange >= 2) {
                            System.out.println("Warning: You are gaining weight too fast. Please try to eat less." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange < 0) {
                            System.out.println("Oh no,looks like you've lost weight, lets recalibrate!");
                            System.out.println("We recommend you tailor your intake to " +
                                    newGoal);
                        }
                    }
                    case "Normal" -> {
                        if (weighChange >= 0 && weighChange < 0.1) {
                            System.out.println("Looks like you've barely gained any weight,lets recalibrate!");
                            System.out.println("Your calorie recommendation is: " + newGoal);
                        } else if (weighChange >= 0.1 && weighChange < 0.5) {
                            System.out.println("You are gaining weight at a slower pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange >= 0.5 && weighChange < 1) {
                            System.out.println("Congratulations! You are on track to gain 0.5kg per week." +
                                    " Keep up the good work!");
                            System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                                    "your progress to how you've responded so far and more in line with your pace: " +
                                    newGoal);
                        } else if (weighChange >= 1 && weighChange < 2) {
                            System.out.println("You are gaining weight at a faster pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange >= 2) {
                            System.out.println("Warning: You are gaining weight too fast. Please try to eat less." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);

                        } else if (weighChange < 0) {
                            System.out.println("Oh no,looks like you've lost weight, lets recalibrate!");
                            System.out.println("We recommend you tailor your intake to " +
                                    newGoal);
                        }
                    }
                    case "Fast" -> {
                        if (weighChange >= 0 && weighChange < 0.1) {
                            System.out.println("Looks like you've barely gained any weight,lets recalibrate!");
                            System.out.println("Your calorie recommendation is: " + newGoal);
                        } else if (weighChange >= 0.1 && weighChange < 0.5) {
                            System.out.println("You are gaining weight at a much slower pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange >= 0.5 && weighChange < 1) {
                            System.out.println("You are gaining weight at a slower pace than expected." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange >= 1 && weighChange < 2) {
                            System.out.println("Congratulations! You are on track to gain 1kg per week." +
                                    " Keep up the good work!");
                            System.out.println("Here's a new calorie recommendation if you want to further tailor " +
                                    "your progress to how you've responded so far and more in line with your pace: " +
                                    newGoal);
                        } else if (weighChange >= 2) {
                            System.out.println("Warning: You are gaining weight too fast. Please try to eat less." +
                                    " We recommend you tailor your intake to " +
                                    newGoal);
                        } else if (weighChange < 0) {
                            System.out.println("Oh no,looks like you've lost weight, lets recalibrate!");
                            System.out.println("We recommend you tailor your intake to " +
                                    newGoal);
                        }
                    }
                }
            }
        }
    }

    public boolean login(Scanner scanner) {
        System.out.println("Please enter your username");
        while (true) {
            String username = getValidUsername(scanner);
            String accountFile = username + ".txt";
            if (checkAccountExist(username)) {
                try (BufferedReader in = new BufferedReader(new FileReader(accountFile))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.startsWith("Password:")) {
                            System.out.println("Enter your password:");
                            String password = scanner.nextLine();
                            if (line.substring(9).equals(password)) {
                                System.out.println("Login successful!");
                                currentUsername = username;
                                return true;
                            } else {
                                System.out.println("Incorrect password.");
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("An account with this username does not exist, please try again.");
            }
        }
    }

    public void readGoal(String username) {
        Scanner scanner = new Scanner(System.in);
        String goal = null;
        String calories = null;
        try (BufferedReader in = new BufferedReader(new FileReader(username + ".txt"))) {
            String line;
            String properAccountSetupCheck = null;
            while ((line = in.readLine()) != null) {
                //store the entire file into properAccountSetupCheck
                properAccountSetupCheck = properAccountSetupCheck + line + "\n";
                if (line.startsWith("Goal:")) {
                    goal = line.substring(5);
                    //For future use.
                    userGoal = goal;
                }
                if (line.startsWith("Calories:")) {
                    calories = line.substring(9);
                }
                if (line.startsWith("Pace:")) {
                    userPace = line.substring(5);
                    switch (userPace) {

                        case "Slowly" -> {
                            assert goal != null;
                            if (goal.equals("Lose"))
                                userPaceNumber = -1925;
                            else if (goal.equals("Gain"))
                                userPaceNumber = 1925;
                            else
                                userPaceNumber = 0;
                        }
                        case "Normal" -> {
                            assert goal != null;
                            if (goal.equals("Lose"))
                                userPaceNumber = -3850;
                            else if (goal.equals("Gain"))
                                userPaceNumber = 3850;
                            else
                                userPaceNumber = 0;
                        }
                        case "Fast" -> {
                            assert goal != null;
                            if (goal.equals("Lose"))
                                userPaceNumber = -7700;
                            else if (goal.equals("Gain"))
                                userPaceNumber = 7700;
                            else
                                userPaceNumber = 0;
                        }
                    }
                }
                if (line.startsWith("Maintenance:")) {
                    maintenanceCalories = Double.parseDouble(line.substring(12));
                }
            }
            //If there is no goal calories pace and maintenance in the file then the user completed that part of
            //account creation
            if (goal == null || calories == null || userPace == null) {
                System.out.println("It looks like you haven't fully set up your account yet. Let's do that now.");
                initialMessage(scanner);
                storeGoalToFile(scanner, username);
                System.out.println("Please adhere to your target for the next 7 days and then come back." + "\n" +
                        "Make sure to note your daily calories and weight for every day.");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        /* If the user has not completed the 7-day check then the program will exit */
        assert goal != null;
        assert calories != null;
        System.out.printf("Welcome %s. Hope your goal to %s weight by eating %s calories a day been going well!%n",
                username, goal.toLowerCase(), Math.round(Float.parseFloat(calories)));
    }

    public void runMathSoup(Scanner scanner) {
        System.out.println("Welcome to MathSoup, do you have an account with us?");
        int choice = displayAccountExist(scanner);
        scanner.nextLine();
        switch (choice) {
            case MENU_YES -> {
                while (true) {
                    if (login(scanner)) {
                        readGoal(currentUsername);
                        recalibrationSequence(scanner);
                        break;
                    }
                }
            }
            case MENU_NO -> {
                createAccount(scanner);
                initialMessage(scanner);
                storeGoalToFile(scanner, currentUsername);
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
