public class Exercise_6_2 {
    public static void main(String[] args) {
        PShape shape = new PShape();
        Creature creature = new Creature(10 ,2 , shape);
        Zombie zombie = new Zombie(10 ,2 , shape);
        Cat cat = new Cat(10 ,2 , shape);
        Fish fish = new Fish(10 ,2 , shape);

        creature.display();
        creature.move();
        creature.attack(cat);

        zombie.display();
        zombie.move();
        zombie.attack(creature);

        cat.display();
        cat.move();
        cat.attack(zombie);

        fish.display();
        fish.move();
        fish.glubGlub();
    }
}