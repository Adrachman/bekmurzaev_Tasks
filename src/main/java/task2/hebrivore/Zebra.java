package task2.hebrivore;


import task2.animal.Herbivore;
import task2.interfaceAnimal.Swim;

public class Zebra extends Herbivore implements Swim {
    public void swim(){
        System.out.println("Zebra swimming");
    }
}
