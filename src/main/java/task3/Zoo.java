package task3;

import task3.carnivorous.Fish;
import task3.carnivorous.Lion;
import task3.carnivorous.Tiger;
import task3.food.Grass;
import task3.food.Meat;
import task3.hebrivore.Duck;
import task3.hebrivore.Rabbit;
import task3.hebrivore.Zebra;
import task3.interfaceAnimal.Swim;
import task3.worker.Worker;

public class Zoo {

    public static void main(String[] args) {
        Fish fish = new Fish();
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Duck duck = new Duck();
        Rabbit rabbit = new Rabbit();
        Zebra zebra = new Zebra();
        Meat meat = new Meat();
        Grass grass = new Grass();
        Worker worker = new Worker();

        Swim[] pond = new Swim[4];
        pond[0] = tiger;
        pond[1] = fish;
        pond[2] = duck;
        pond[3] = zebra;
        for (int i = 0; i < pond.length; i++){
            pond[i].swim();
        }

        worker.getVoice(lion);
        worker.feed(tiger,meat);
        worker.feed(duck,meat);
        worker.feed(rabbit,grass);
        worker.feed(fish,grass);

    }
}
