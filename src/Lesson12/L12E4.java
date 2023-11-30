package Lesson12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L12E4 {
    public static void main(String[] args) {
        ArrayList<Car> carList = loadFile("src//Lesson12//carSales.txt/");
        for (int i = 0; i < carList.size(); i++) {
            Car thisCar = carList.get(i);
            displayCars(thisCar);
        }
    }

    public static ArrayList<Car> loadFile(String filename) {
        List<String> carDetails;
        ArrayList<Car> carList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            while (line != null) {
                carDetails = Arrays.asList(line.split(","));
                Car newCar = new Car();
                newCar.make = carDetails.get(0);
                newCar.model = carDetails.get(1);
                newCar.color = carDetails.get(5);
                newCar.price = Integer.parseInt(carDetails.get(4));
                newCar.condition = carDetails.get(7);
                newCar.vin = carDetails.get(3);
                newCar.year = Integer.parseInt(carDetails.get(2));
                newCar.mileage = Integer.parseInt(carDetails.get(6));
                carList.add(newCar);
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred reading file: " + e.toString());
        }
        return carList;
    }


    public static void displayCars(Car thisCar) {
        System.out.printf("%s %s (%d)%nVin: %s%nColour: %s%nMileage: %d%nCondition: %s%nPrice: %d%n", thisCar.make,
                thisCar.model, thisCar.year, thisCar.vin, thisCar.color, thisCar.mileage, thisCar.condition, thisCar.price);
        System.out.println("-------------------------------------");
    }
}
