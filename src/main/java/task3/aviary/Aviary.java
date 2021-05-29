package task3.aviary;


import task3.animal.Animal;

import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animal> {
    private AviaryType aviaryType;
    private Map<T, String> map;

    public Aviary(AviaryType aviaryType) {
        this.aviaryType = aviaryType;
        this.map = new HashMap<>();
    }

    public void putAnimal(T animal) throws WrongAviaryTypeException {
        if (animal.getAviaryType().equals(aviaryType))
            map.put(animal, animal.getName());
        else
            throw new WrongAviaryTypeException("Тип вольера не подходит животному");
    }

    public void removeAnimal(T animal) {
        map.remove(animal);
    }

    public T getAnimal(String name) {
        for (T animal : map.keySet())
            if (animal.getName().equals(name))
                return animal;
        return null;
    }
}


