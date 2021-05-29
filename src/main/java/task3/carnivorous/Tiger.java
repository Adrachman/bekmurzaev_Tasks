package task3.carnivorous;


import task3.animal.Carnivorous;
import task3.aviary.AviaryType;
import task3.interfaceAnimal.Run;
import task3.interfaceAnimal.Swim;
import task3.interfaceAnimal.Voice;

public class Tiger extends Carnivorous implements Run, Voice, Swim {

    public void swim() {
        System.out.println("tiger swimming");
    }

    public void run() {
        System.out.println("Тигр бегает");
    }

    public String voice() {
        return "Тигр рычит";
    }

    public String eat() {
        return "I am Tiger, and eat meet";
    }

    @Override
    public AviaryType getAviaryType() {
        return AviaryType.LARGE;
    }
}
