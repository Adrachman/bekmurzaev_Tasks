package task3;

import task3.animal.Carnivorous;
import task3.animal.Herbivore;
import task3.aviary.Aviary;
import task3.aviary.AviaryType;
import task3.aviary.WrongAviaryTypeException;
import task3.carnivorous.Tiger;
import task3.food.Grass;
import task3.hebrivore.Duck;
import task3.hebrivore.Zebra;
import task3.worker.Worker;

public class Main {

    public static void main(String[] args){
        Tiger tiger = new Tiger();
        Grass grass = new Grass();
        Duck duck = new Duck();
        Zebra zebra = new Zebra();
        Aviary<Herbivore> herbAviary = new Aviary<>(AviaryType.MEDIUM);
        Aviary<Carnivorous> carnAviary = new Aviary<>(AviaryType.WATER);
        Worker worker = new Worker();
        worker.feed(tiger,grass);
        try {
            herbAviary.putAnimal(duck);
        } catch (WrongAviaryTypeException e){
            System.out.println(e.getMessage());
        }
        try {
            herbAviary.putAnimal(zebra);
        } catch (WrongAviaryTypeException e){
            System.out.println(e.getMessage());
        }
        try {
            carnAviary.putAnimal(tiger);
        } catch (WrongAviaryTypeException e){
            System.out.println(e.getMessage());
        }

    }
}
