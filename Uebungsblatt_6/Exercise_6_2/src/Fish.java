public class Fish extends Creature{
    public Fish(float x , float y , PShape s) {
        super(x , y , s);
    }

    @Override
    public void display() {
        //super.display();
        System.out.println("Fish display");
    }

    @Override
    public void move() {
        //super.move();
        System.out.println("Fish swim");
    }

    public void glubGlub() {
        System.out.println("Glub glub!");
    }
}
