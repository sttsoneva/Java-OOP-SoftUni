package vehicleExtension;

import java.text.DecimalFormat;

public class Vehicle implements IVehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        if (tankCapacity <= 0) {
            String message = "Capacity must be a positive number";
            throw new IllegalArgumentException(message);
        }

        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";

        if (this.fuelQuantity >= fuelNeeded) {
            this.fuelQuantity -= fuelNeeded;
            result = String.format("travelled %s km", df.format(distance));
        }
        return result;
    }

    @Override
    public void refuel(double litres) {
        if (litres <= 0) {
            String message = "Fuel must be a positive number";
            throw new IllegalArgumentException(message);
        }

        double availableCapacity = this.tankCapacity - this.fuelQuantity;
        if (litres > availableCapacity) {
            String message = "Cannot fit fuel in tank";
            throw new IllegalArgumentException(message);
        }

        this.fuelQuantity += litres;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
