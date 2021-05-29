package task3.worker;


import task3.animal.Animal;
import task3.aviary.WrongFoodException;
import task3.food.Food;
import task3.interfaceAnimal.Voice;

public class Worker {
    public void feed(Animal animal, Food food){
        try {
            animal.eat(food);
        } catch (WrongFoodException e){
            System.out.println(e.getMessage());
        }
    }
    public void getVoice(Voice animal){
            System.out.println(((Voice) animal).voice());
    }
}
