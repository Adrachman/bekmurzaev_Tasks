package task3.carnivorous;

import task3.animal.Carnivorous;
import task3.aviary.AviaryType;
import task3.interfaceAnimal.Run;
import task3.interfaceAnimal.Voice;

public class Lion extends Carnivorous implements Run, Voice {
    public void run() {
        System.out.println("Лев бегает");
    }

    public String voice() {
        return "Лев рычит";
    }

    public String eat() {
        return "eat";
    }

    @Override
    public AviaryType getAviaryType() {
        return AviaryType.LARGE;
    }
}
