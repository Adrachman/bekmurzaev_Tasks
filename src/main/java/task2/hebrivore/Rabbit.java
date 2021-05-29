package task2.hebrivore;


import task2.animal.Herbivore;
import task2.interfaceAnimal.Run;

public class Rabbit extends Herbivore implements Run {

    public void run(){
        System.out.println("Кролик бегает");
    }

    public String eat(){
        return "Rabbit eat grass";
    }
}
