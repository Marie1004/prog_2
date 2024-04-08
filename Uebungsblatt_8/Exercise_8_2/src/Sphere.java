public class Sphere extends SolidOfRevolution {
    public Sphere(double radius) {
        super(radius);
        this.volume = (4.0/3.0) * (Math.PI * Math.pow(radius, 3));
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
