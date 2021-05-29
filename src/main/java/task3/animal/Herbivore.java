package task3.animal;
// Травоядные


import task3.aviary.WrongFoodException;
import task3.food.Food;
import task3.food.Grass;

public abstract class Herbivore extends Animal {
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Grass) {
            System.out.println("Данное животное ест траву");
        } else
            throw new WrongFoodException("Данная еда не подходит животному");
    }
}
