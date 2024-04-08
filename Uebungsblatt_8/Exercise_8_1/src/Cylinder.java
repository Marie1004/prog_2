public class Cylinder extends SolidOfRevolution {
    double height;

    public Cylinder(double radius , double height) {
        //volume , radius
        super(radius);
        this.volume = Math.PI * Math.pow(radius , 2) * height;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}