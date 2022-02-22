package DEMO.ObjectsAndClasses_MoreExercise.RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tiers;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }

    public Tire[] getTiers() {
        return tiers;
    }

    public boolean hasTireWithLessPressureThanOne() {
        for (Tire tier : tiers) {
            if (tier.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
