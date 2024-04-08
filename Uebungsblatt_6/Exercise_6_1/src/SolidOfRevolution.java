public class SolidOfRevolution extends Shape {
    double radius;

    public SolidOfRevolution(double volume , double radius) {
        super();
        this.volume = volume;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
