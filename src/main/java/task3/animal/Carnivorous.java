package task3.animal;
//Хищные


import task3.aviary.WrongFoodException;
import task3.food.Food;
import task3.food.Meat;

public abstract class Carnivorous extends Animal {
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            System.out.println("Данное животное ест мясо");
        } else
            throw new WrongFoodException("Данная еда не подходит животному");
    }
}
