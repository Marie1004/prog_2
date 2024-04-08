public class Creature {
    float x;
    float y;
    float lifeforce;
    PShape s;

    public Creature(float x , float y , PShape s) {}

    public void display() {
        System.out.println("Creature display");
    }

    public void move() {
        System.out.println("Creature move");
    }

    public void attack(Creature c) {
        System.out.println("Creature attacks " + c);
    }
}
