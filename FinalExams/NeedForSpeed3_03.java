
package DEMO.EXAMS_Final.Exam3;

import java.util.*;

public class NeedForSpeed3_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    // 80/100

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new TreeMap<>();    //mileage and fuel available

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            //List<Integer> current = new LinkedList<>();
            // cars.put(car,current);
            cars.put(car, new ArrayList<>());
            cars.get(car).add(mileage);
            cars.get(car).add(fuel);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");
            String commandName = command[0];
            String car = command[1];
            switch (commandName) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);  // current dist
                    int fuel = Integer.parseInt(command[3]); //Audi =47  ; fuel needed
                    int distanceReal = cars.get(car).get(0); // info from the For-loop - accumulated dist
                    int fuelReal = cars.get(car).get(1);   //Audi =62

                    if (fuelReal < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        //List<Integer> dataCar = cars.get(car);

                        distanceReal += distance;
                        fuelReal -= fuel;
                        cars.get(car).set(0, distanceReal);
                        cars.get(car).set(1, fuelReal);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (distanceReal > 100000) {   //car's mileage reaches 100 000 km
                            System.out.printf("Time to sell the %s!", car);
                            cars.remove(car);          // remove it  70/100 without it
                            break;
                        }
                    }
                    break;
                case "Refuel":
                    int fuel2 = Integer.parseInt(command[2]);
                    int fuelMoment = cars.get(car).get(1);
                    //cars.get(car).get(1)+=fuel2;  //! variable expected
                    fuelMoment += fuel2;
                    if (fuelMoment >= 75) {         // Each tank can hold a maximum of 75 liters of fuel
                        fuel2=fuelMoment-75-fuel2;  // 90/100 ???
                        fuelMoment = 75;
                    }
                    cars.get(car).set(1, fuelMoment);
                    System.out.printf("%s refueled with %d liters%n", car, Math.abs(fuel2));

                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(command[2]);
                    int mileageMoment = cars.get(car).get(0);
                    int current = mileageMoment - kilometres;

                    if (current < 10000) {
                        current = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometres);
                    }
                    cars.get(car).set(0, current);
                    break;
            }
            input = scanner.nextLine();
        }
        cars.entrySet().stream()
                .sorted((s, t) -> t.getValue().get(0) - s.getValue().get(0))
                .forEach(kvp -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));

    }
}
