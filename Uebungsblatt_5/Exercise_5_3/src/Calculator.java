public class Calculator {
    Floor floor;
    Carpet carpet;

    public Calculator(Floor floor , Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public Floor getFloor() {
        return floor;
    }

    public Carpet getCarpet() {
        return carpet;
    }

    // Rückgabe der Gesamtkosten fuer das Verlegen des Teppichs
    public double getTotalCost() {
        Floor floor = getFloor();
        Carpet carpet = getCarpet();

        double totalCost;

        totalCost = floor.getArea() * carpet.cost;

        return totalCost;
    }
}
