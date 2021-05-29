package task2.carnivorous;


import task2.animal.Carnivorous;
import task2.interfaceAnimal.Run;
import task2.interfaceAnimal.Voice;

public class Lion extends Carnivorous implements Run, Voice {
    public void run(){
        System.out.println("Лев бегает");
    }

    public String voice(){
        return "Лев рычит";
    }

    public String eat(){
        return "eat";
    }
}
