package wildFarm.animals;

import wildFarm.food.Food;
import wildFarm.food.Meat;

public class Tiger extends Feline {
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            this.foodEaten += food.getQuantity();
        } else {
            String message = String.format("%ss are not eating that type of food!", this.getClass().getSimpleName());
            throw new IllegalArgumentException(message);
        }
    }
}
