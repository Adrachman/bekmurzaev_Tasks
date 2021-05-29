package task2.carnivorous;


import task2.animal.Carnivorous;
import task2.interfaceAnimal.Run;
import task2.interfaceAnimal.Swim;
import task2.interfaceAnimal.Voice;

public class Tiger extends Carnivorous implements Run, Voice, Swim {
    public void swim(){
        System.out.println("tiger swimming");
    }

    public void run(){
        System.out.println("Тигр бегает");
    }

    public String voice(){
        return "Тигр рычит";
    }

    public String eat(){
        return "I am Tiger, and eat meet";
    }
}
