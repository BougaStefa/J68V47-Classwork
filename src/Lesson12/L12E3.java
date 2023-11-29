package Lesson12;

public class L12E3 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.make = "Ferrari";
        car1.model = "F430";
        car1.color = "White";
        car1.price = 55125;
        car1.condition = "Good";
        car1.vin = "3GYVKNEFXAG625569";
        car1.year = 2009;
        car1.mileage = 45336;
        displayCarValues(car1);
    }


    public static void displayCarValues(Car car1) {
        System.out.printf("%s %s (%d)%nVin: %s%nColour: %s%nMileage: %d%nCondition: %s%nPrice: %d", car1.make,
                car1.model, car1.year, car1.vin, car1.color, car1.mileage, car1.condition, car1.price);
    }
}
