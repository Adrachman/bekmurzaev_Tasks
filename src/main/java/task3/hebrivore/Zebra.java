package task3.hebrivore;

import task3.animal.Herbivore;
import task3.aviary.AviaryType;
import task3.interfaceAnimal.Swim;

public class Zebra extends Herbivore implements Swim {

    public void swim(){
        System.out.println("Zebra swimming");
    }

    @Override
    public AviaryType getAviaryType() {
        return AviaryType.MEDIUM;
    }

}
