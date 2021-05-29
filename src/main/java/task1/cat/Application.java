package task1.cat;


import task1.cat.model.Kotik;

public class Application {

    public static void main(String[] args) {
        Kotik barsik = new Kotik("Barsik", 18, 15, "May", 5);
        Kotik garfild = new Kotik();
        garfild.setKotik("garfild", -3, 40, "May");
        barsik.liveAnotherDay();
        System.out.println(barsik.getName() + "\t" + barsik.getWeight());
        System.out.println(barsik.getMeow().equals(garfild.getMeow()));
    }
}
