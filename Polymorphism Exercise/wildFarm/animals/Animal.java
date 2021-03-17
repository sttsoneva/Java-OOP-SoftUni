package wildFarm.animals;

import wildFarm.food.Food;

public abstract class Animal {
    private static final Integer DEFAULT_FOOD_EATEN = 0;

    String animalName;
    String animalType;
    Double animalWeight;
    Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = DEFAULT_FOOD_EATEN;

    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public static Integer getDefaultFoodEaten() {
        return DEFAULT_FOOD_EATEN;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public abstract String makeSound();

    public abstract void eat(Food food);

}
