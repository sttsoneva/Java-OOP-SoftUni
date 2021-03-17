package wildFarm;

import wildFarm.animals.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Animal> animals = new LinkedHashSet<>();

        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        while (!inputLine.equals("End")) {

            String[] animalDetails = inputLine.split("\\s+");
            String[] foodDetails = scan.nextLine().split("\\s+");
            String type = animalDetails[0];
            String name = animalDetails[1];
            double weight = Double.parseDouble(animalDetails[2]);
            String livingRegion = animalDetails[3];

            String foodType = foodDetails[0];
            int foodQuantity = Integer.parseInt(foodDetails[1]);

            Animal animal = null;
            switch (type) {
                case "Cat":
                    String breed = animalDetails[4];
                    animal = new Cat(name, type, weight, livingRegion, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(name, type, weight, livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(name, type, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(name, type, weight, livingRegion);
                    break;
            }

            Food food = null;
            switch (foodType) {
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
            }

            System.out.println(animal.makeSound());

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println((e.getMessage()));
            }

            animals.add(animal);

            inputLine = scan.nextLine();
        }

        animals.forEach(System.out::println);
    }
}
