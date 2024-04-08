public class Pyramid extends Shape {
    double height;

    double baseArea;

    public Pyramid(double height , double baseArea) {
        super();
        this.height = height;
        this.baseArea = baseArea;
        this.volume = (1.0/3.0) * baseArea * height;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
