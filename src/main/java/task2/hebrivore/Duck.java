package task2.hebrivore;


import task2.animal.Herbivore;
import task2.interfaceAnimal.Fly;
import task2.interfaceAnimal.Run;
import task2.interfaceAnimal.Swim;
import task2.interfaceAnimal.Voice;

public class Duck extends Herbivore implements Fly, Run, Swim, Voice {

    public String voice() {
        return "Утка кричит Кря-кря";
    }

    public void swim(){
        System.out.println("Утка плавает");
    }

    public void flying(){
        System.out.println("Утка летает махая крылья");
    }

    public void run(){
        System.out.println("Утка бегат");
    }

    public String eat(){
        return "Duck eat grass";
    }
}
