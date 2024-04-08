import java.util.ArrayList;
import java.util.Collections;

public class Exercise_8_2 {
    public static void main(String[] args) {
        testCode();
    }

   public static void testCode() {
        Sphere sphere = new Sphere(4.5);
        System.out.println("Sphere: " + sphere.volume);
        Cylinder cylinder = new Cylinder(2, 2);
       System.out.println("Cylinder: " + cylinder.volume);
        Pyramid pyramid = new Pyramid(100, 100);
        Box box = new Box(1000);
        System.out.println(box.add(sphere)); // true
        System.out.println(box.add(cylinder)); // true
        System.out.println(box.add(pyramid)); // false
        ArrayList<Shape> shapes = box.getShapes();
        Collections.sort(shapes); // sorted by Volume!
        for (Shape shape: shapes) {
            System.out.println(shape.getVolume()); // 25.132741228718345 286.2776305583699
        }
    }
}