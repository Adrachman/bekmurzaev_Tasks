package task2.carnivorous;


import task2.animal.Carnivorous;
import task2.interfaceAnimal.Swim;

public class Fish extends Carnivorous implements Swim {
    public String getAnimalName(){
        return "fish";
    }
    public void swim(){
        System.out.println("Рыба плавает");
    }

    public String eat(){
        return "I am fish, a eating Meet";
    }
}
