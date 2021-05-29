package task2.animal;
// Травоядные


import task2.food.Food;
import task2.food.Grass;

public abstract class Herbivore extends Animal {
    public void eat(Food food){
        if (food instanceof Grass){
            System.out.println("Данное животное ест траву");
        } else {
            System.out.println("Данное животное не ест мясо");
        }
    }
}
