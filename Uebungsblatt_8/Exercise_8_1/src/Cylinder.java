public class Cylinder extends SolidOfRevolution {
    double height;

    public Cylinder(double radius , double height) {
        //volume , radius
        super(Math.PI * Math.pow(radius , 2) * height, radius);
    }
}