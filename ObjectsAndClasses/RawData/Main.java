package DEMO.ObjectsAndClasses_MoreExercise.RawData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower); // Initialize

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);     // Initialize

            int count = 0;
            Tire[] tires = new Tire[4];                          // Initialize
            for (int j = 5; j < tokens.length; j += 2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                tires[count] = new Tire(tirePressure, tireAge);
                count++;
            }
            Car car = new Car(model, engine, cargo, tires);
            cars.putIfAbsent(model, car);
        }
        String cargoType = scanner.nextLine();
        for (Car car : cars.values()) {
            if (cargoType.equals("flamable") && car.getCargo().getType().equals("flamable")
                    && car.getEngine().getEnginePower()>250){
                System.out.println(car);

            } else if (cargoType.equals("fragile") && "fragile".equals(car.getCargo().getType()) &&
                    car.hasTireWithLessPressureThanOne()){
                System.out.println(car);

            }
        }




    }
}
