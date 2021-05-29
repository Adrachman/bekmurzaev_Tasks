package task3.carnivorous;

import task3.animal.Carnivorous;
import task3.aviary.AviaryType;
import task3.interfaceAnimal.Swim;

public class Fish extends Carnivorous implements Swim {

    public void swim(){
        System.out.println("Рыба плавает");
    }

    public String eat(){
        return "I am fish, a eating Meet";
    }

    @Override
    public AviaryType getAviaryType() {
        return AviaryType.WATER;
    }
}
