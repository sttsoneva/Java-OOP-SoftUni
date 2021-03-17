package wildFarm.animals;

import wildFarm.food.Food;
import wildFarm.food.Vegetable;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
       return "Zs";
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.foodEaten += food.getQuantity();
        } else {
            String message = String.format("%ss are not eating that type of food!", this.getClass().getSimpleName());
            throw new IllegalArgumentException(message);
        }
    }
}
