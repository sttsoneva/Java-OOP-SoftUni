package wildFarm.animals;

import wildFarm.food.Food;
import wildFarm.food.Vegetable;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.foodEaten += food.getQuantity();
        } else {
            String message = "Mice are not eating that type of food!";
            throw new IllegalArgumentException(message);
        }
    }
}
