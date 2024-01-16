package Project;

public class User {

  private String username;
  private String password;
  private String goal;
  private long maintenance;
  private long calories;
  private String pace;
  private String activity;
  private int age;
  private int height;
  private int weight;
  
public User() {
}
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
    this.username = username;
    this.password = password;
    this.goal = goal;
    this.maintenance = maintenance;
    this.calories = calories;
    this.pace = pace;
    this.activity = activity;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getGoal() {
    return goal;
  }

  public long getMaintenance() {
    return maintenance;
  }

  public long getCalories() {
    return calories;
  }

  public String getPace() {
    return pace;
  }

  public String getActivity() {
    return activity;
  }

  public int getAge() {
    return age;
  }

  public int getHeight() {
    return height;
  }

  public int getWeight() {
    return weight;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }

  public void setMaintenance(long maintenance) {
    this.maintenance = maintenance;
  }

  public void setCalories(long calories) {
    this.calories = calories;
  }

  public void setPace(String pace) {
    this.pace = pace;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
