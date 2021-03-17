package vehicleExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");
        String[] busInfo = scan.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));


        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            try {
                switch (tokens[0]) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        if (tokens[1].equals("Car")) {
                            System.out.println(car.drive(distance));
                        } else if (tokens[1].equals("Truck")) {
                            System.out.println(truck.drive(distance));
                        } else {
                            System.out.println(bus.drive(distance));
                        }
                        break;
                    case "Refuel":
                        double litres = Double.parseDouble(tokens[2]);
                        if (tokens[1].equals("Car")) {
                            car.refuel(litres);
                        } else if (tokens[1].equals("Truck")) {
                            truck.refuel(litres);
                        } else {
                            bus.refuel(litres);
                        }
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
