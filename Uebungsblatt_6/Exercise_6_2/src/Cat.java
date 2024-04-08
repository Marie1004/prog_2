public class Cat extends Creature {
    public Cat(float x , float y , PShape s) {
        super(x , y , s);
    }

    @Override
    public void display() {
        //super.display();
        System.out.println("Cat display");
    }

    @Override
    public void move() {
        //super.move();
        System.out.println("Cat move");
    }

    @Override
    public void attack(Creature c) {
        //super.attack(c);
        System.out.println("Cat attacks " + c);
    }
}
