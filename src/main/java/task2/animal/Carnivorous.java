package task2.animal;
//Хищные


import task2.food.Food;
import task2.food.Meat;

public abstract class Carnivorous extends Animal{
    public void eat(Food food){
        if (food instanceof Meat){
            System.out.println("Данное животное ест мясо");
        } else {
            System.out.println("Данное животное не ест траву");
        }
    }
}
