
package DEMO.ObjectsAndClasses_Exercises.VehicleCatalogue_06;

public class Truck {
    // {typeOfVehicle} {model} {color} {horsepower}

    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Truck(String model, String color, int horsepower) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.type = "Truck";
    }
    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                this.type, this.model, this.color, this.horsepower);
    }
}
