
package DEMO.ObjectsAndClasses_Exercises.VehicleCatalogue_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        int carHorsepower = 0;
        int truckHorsepower = 0;

        //truck Mercedes blue 300
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);

            if (type.equals("car")) {
                Car car = new Car(model, color, horsePower);
                cars.add(car);
                carHorsepower += car.getHorsepower();
            } else if (type.equals("truck")) {
                Truck truck = new Truck(model, color, horsePower);
                trucks.add(truck);
                truckHorsepower += truck.getHorsepower();
            }

            input = scanner.nextLine();
        }
        // When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower...
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            for (Car car : cars) {
                if (car.getModel().equals(input)) {
                    System.out.println(car);
                    break;
                }
            }
            for (Truck truck : trucks) {
                if (truck.getModel().equals(input)) {
                    System.out.println(truck);
                    break;
                }
            }
            input = scanner.nextLine();
        }
        // Cars have average horsepower of: 413.33.
        double avgCarHorsepower = 0;
        if (cars.size() != 0) {
            avgCarHorsepower = carHorsepower * 1.0 / cars.size();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarHorsepower);

        double avgTruckHorsepower = 0;
        if (trucks.size() != 0) {
            avgTruckHorsepower = truckHorsepower * 1.0 / trucks.size();
        }
        System.out.printf("Trucks have average horsepower of: %.2f.%n", avgTruckHorsepower);



    }
}
