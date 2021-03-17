package wildFarm.animals;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String bread) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = bread;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), this.getAnimalName(), this.getBreed(), df.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
