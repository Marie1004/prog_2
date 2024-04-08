abstract class Shape implements Comparable<Shape> {
    protected double volume;

    public abstract double getVolume();

    @Override
    public int compareTo(Shape o) {
        if(this.volume < o.volume) {
            return -1;
        } else if(this.volume == o.volume) {
            return 0;
        } else {
            return 1;
        }
    }
}
