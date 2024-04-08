public class Zombie extends Creature{

    Zombie(float x , float y , PShape s) {
        super(x , y , s);
    }

    @Override
    public void display() {
        //super.display();
        System.out.println("Zombie display");
    }

    @Override
    public void move() {
        //super.move();
        System.out.println("Zombie move");
    }

    @Override
    public void attack(Creature c) {
        //super.attack(c);
        System.out.println("Zombie attacks " + c);
    }
}
