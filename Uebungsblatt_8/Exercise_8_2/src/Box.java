import java.util.ArrayList;

public class Box extends Shape {
    ArrayList<Shape> shapes = new ArrayList<Shape>(); // Create an ArrayList object

    double innerVolume;

    public Box(double volume) {
        super();
        this.volume = volume;
        this.innerVolume = innerVolume;
        this.shapes = shapes;
    }

    public boolean add(Shape shape) {
        boolean free = false;
        double remainingVolume = calculateRemainingVolume();
        //System.out.println("\nremaining volume of the box = " + remainingVolume);

        if(shape.volume < remainingVolume) {
            this.shapes.add(shape);
            free = true;
        }

        return free;
    }

    public double calculateRemainingVolume() {
        double remainingVolume = this.volume;

        for(int i = 0; i < this.shapes.size(); i++) {
            //Shape shapeInBox = this.shapes.get(i);
            remainingVolume -= this.shapes.get(i).volume;
        }

        return remainingVolume;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
