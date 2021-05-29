package task1.cat.model;

public class Kotik {
    public static int catsAmount = 0;

    private String name;
    private int prettiness;
    private int weight;
    private String meow;
    private int satiety;


    public Kotik() {
        catsAmount++;
    }

    public Kotik(String name, int prettiness, int weight, String meow, int satiety) {
        this.name = name;
        this.prettiness = prettiness;
        this.weight = weight;
        this.meow = meow;
        this.satiety = satiety;
        catsAmount++;
    }

    public void setKotik(String name, int prettiness, int weight, String meow) {
        this.name = name;
        this.prettiness = prettiness;
        this.weight = weight;
        this.meow = meow;
    }

    public void eat(int foodSatiety) {
        System.out.print("Кот ест");
        satiety += foodSatiety;
    }

    public void eat(int foodSatiety, String foodsName) {
        System.out.print("Кот ест -> ");
        satiety += foodSatiety;
        System.out.print("Коту нравится " + foodsName);
    }

    public void eat() {
        eat(2, "KiteKat");
    }

    public boolean play() {
        System.out.print("Кот играй -> ");
        if (satiety > 0) {
            System.out.print("Кот играется");
            satiety--;
            return true;
        } else {
            System.out.print("Кот хочет есть -> ");
            eat();
            return false;
        }
    }

    public boolean sleep() {
        System.out.print("Кот иди спать -> ");
        if (satiety > 0) {
            System.out.print("Кот спит");
            satiety--;
            return true;
        } else {
            System.out.print("Кот хочет есть -> ");
            eat();
            return false;
        }
    }

    public boolean chaseMouse() {
        System.out.print("Кот лови мышей! -> ");
        if (satiety > 0) {
            System.out.print("Кот ловит мышей");
            satiety--;
            return true;
        } else {
            System.out.print("Кот хочет есть -> ");
            eat();
            return false;
        }
    }

    public boolean fawn() {
        System.out.print("Кот ласкайся! -> ");
        if (satiety > 0) {
            System.out.print("Кот ласкается");
            satiety--;
            return true;
        } else {
            System.out.print("Кот хочет есть -> ");
            eat();
            return false;
        }
    }

    public boolean bite() {
        System.out.print("Кот кусайся! -> ");
        if (satiety > 0) {
            System.out.print("Кот кусается");
            satiety--;
            return true;
        } else {
            System.out.print("Кот хочет есть -> ");
            eat();
            return false;
        }
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            switch ((int) (Math.random() * 5)) {
                case 0 -> play();
                case 1 -> sleep();
                case 2 -> chaseMouse();
                case 3 -> fawn();
                case 4 -> bite();
            }
            System.out.println();
        }

    }


    public int getPrettiness() {
        return prettiness;
    }

    public void setPrettiness(int prettiness) {
        this.prettiness = prettiness;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

}
