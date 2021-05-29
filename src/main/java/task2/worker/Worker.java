package task2.worker;


import task2.animal.Animal;
import task2.food.Food;
import task2.interfaceAnimal.Voice;

public class Worker {
    public void feed(Animal animal, Food food){
        animal.eat(food);
    }
    public void getVoice(Voice animal){
            System.out.println(((Voice) animal).voice());
    }
}
