public class InsuranceClient {
    // Instanzvariablen
    private int children;
    private double charges;

    // Konstruktor
    public InsuranceClient(int _children, double _charges) {
        this.children = _children;
        this.charges = _charges;
    }

    public int getChildren() {
        return children;
    }

    public double getCharges() {
        return charges;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }
}
