public class Sphere extends SolidOfRevolution {
    public Sphere(double radius) {
        super((4.0/3.0) * (Math.PI * Math.pow(radius, 3)) , radius);
    }
}
