package Project;

public class User {

  String Username;
  String Password;
  String Goal;
  long Maintenance;
  long Calories;
  String Pace;
  String Activity;
  int Age;
  int Height;
  int Weight;

  public User(
    String username,
    String password,
    String goal,
    long maintenance,
    long calories,
    String pace,
    String activity,
    int age,
    int height,
    int weight
  ) {
    this.Username = username;
    this.Password = password;
    this.Goal = goal;
    this.Maintenance = maintenance;
    this.Calories = calories;
    this.Pace = pace;
    this.Activity = activity;
    this.Age = age;
    this.Height = height;
    this.Weight = weight;
  }
}
