package task3.hebrivore;


import task3.animal.Herbivore;
import task3.aviary.AviaryType;
import task3.interfaceAnimal.Fly;
import task3.interfaceAnimal.Run;
import task3.interfaceAnimal.Swim;
import task3.interfaceAnimal.Voice;

public class Duck extends Herbivore implements Fly, Run, Swim, Voice {

    public String voice() {
        return "Утка кричит Кря-кря";
    }

    public void swim() {
        System.out.println("Утка плавает");
    }

    public void flying() {
        System.out.println("Утка летает махая крылья");
    }

    public void run() {
        System.out.println("Утка бегат");
    }

    public String eat() {
        return "Duck eat grass";
    }

    @Override
    public AviaryType getAviaryType() {
        return AviaryType.SMALL;
    }
}
