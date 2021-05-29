package task3.hebrivore;


import task3.animal.Herbivore;
import task3.aviary.AviaryType;
import task3.interfaceAnimal.Run;

public class Rabbit extends Herbivore implements Run {

    public void run(){
        System.out.println("Кролик бегает");
    }

    public String eat(){
        return "Rabbit eat grass";
    }


    @Override
    public AviaryType getAviaryType() {
        return AviaryType.SMALL;
    }

}
