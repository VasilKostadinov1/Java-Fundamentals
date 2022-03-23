package DEMO.EXAMS_Final.Exam3;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeed3_2Maps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());  // 100/100

        Map<String, Integer> mileageCar = new TreeMap<>();
        Map<String, Integer> fuelCar = new TreeMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] command = scanner.nextLine().split("\\|");
            //{car}|{mileage}|{fuel}
            String carName = command[0];
            int mileage = Integer.parseInt(command[1]);
            int fuel = Integer.parseInt(command[2]);

            fuelCar.put(carName, fuel);
            mileageCar.put(carName, mileage);
        }
        //Then, you will be receiving different commands, each on a new line, separated by " : ", until the "Stop"
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] token = command.split(" : ");

            //Drive : {car} : {distance} : {fuel}
            String commandName = token[0];
            String carName = token[1];

            switch (commandName) {
                case "Drive":
                    //{distance} : {fuel}
                    int distance = Integer.parseInt(token[2]);
                    int fuel = Integer.parseInt(token[3]);

                    int currentFuel = fuelCar.get(carName);
                    if (fuel > currentFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currentMileage = mileageCar.get(carName);
                        int totalMileage = currentMileage + distance;  // increase its mileage
                        mileageCar.put(carName, totalMileage);

                        currentFuel -= fuel;                        // decrease its fuel with the given fuel
                        fuelCar.put(carName, currentFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuel);

                        if (totalMileage >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            fuelCar.remove(carName);            // remove it from the collection(s) !!! both
                            mileageCar.remove(carName);
                        }
                    }
                    break;
                case "Refuel":
                    //{car} : {fuel}
                    int fuelToRefuel = Integer.parseInt(token[2]);

                    int currentFuelToRefuel = fuelCar.get(carName);
                    int totalFuel = currentFuelToRefuel + fuelToRefuel;
                    if (totalFuel >= 75) {
                        totalFuel = 75;
                    }
                    fuelCar.put(carName, totalFuel);
                    System.out.printf("%s refueled with %d liters%n", carName, totalFuel - currentFuelToRefuel);
//                    int currentFuelToRefuel = fuelCar.get(carName);   // 2nd var !!!
//                    if (currentFuelToRefuel + fuelToRefuel >= 75) {
//                        fuelToRefuel = 75 - currentFuelToRefuel;
//                    }
//                    currentFuelToRefuel += fuelToRefuel;
//                    fuelCar.put(carName, currentFuelToRefuel);
//                    System.out.printf("%s refueled with %d liters%n", carName, fuelToRefuel);

                    break;
                case "Revert":
                    //{car} : {kilometers}
                    int kilometers = Integer.parseInt(token[2]);

                    int currentKilometers = mileageCar.get(carName);
                    int totalKilometers = currentKilometers - kilometers;

                    if (totalKilometers < 10000) {
                        totalKilometers = 10000;
                        mileageCar.put(carName, totalKilometers);
                        break;

                    } else {
                        mileageCar.put(carName, totalKilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                    }
                    break;
           }
            command = scanner.nextLine();
        }
        //mileage in descending order,
        //name in descending order
        //  {car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt.
        mileageCar.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())// -> mileage in descending order
                        .thenComparing(Map.Entry.comparingByKey())) // name is descending order
                .forEach(car -> {
                    System.out.println(car.getKey() + " -> Mileage: " + car.getValue() + " kms, Fuel in the tank: " +
                            fuelCar.get(car.getKey()) + " lt.");

                });
    }
}
