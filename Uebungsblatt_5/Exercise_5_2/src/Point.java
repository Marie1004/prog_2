class Point {
    // Instanzvariablen
    private int x;
    private int y;

    // Konstruktoren
    public Point() {}

    public Point(int x , int y) {
        this.x = x;
        this.y = y;
    }

    // Instanzmethoden
    public int getX() {
        return x;
    };

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        int pointOneX = getX();
        int pointOneY = getY();
        int pointTwoX = 0;
        int pointTwoY = 0;

        double result;

        result = calculateDistance(pointOneX , pointOneY , pointTwoX , pointTwoY);

        return result;
    }

    public double distance(int x , int y) {
        int pointOneX = getX();
        int pointOneY = getY();
        int pointTwoX = x;
        int pointTwoY = y;

        double result;

        result = calculateDistance(pointOneX , pointOneY , pointTwoX , pointTwoY);

        return result;
    }

    public double distance(Point pointTwo) {
        int pointOneX = getX();
        int pointOneY = getY();
        int pointTwoX = pointTwo.getX();
        int pointTwoY = pointTwo.getY();

        double result;

        result = calculateDistance(pointOneX , pointOneY , pointTwoX , pointTwoY);

        return result;
    }

    private double calculateDistance(int pointOneX , int pointOneY , int pointTwoX , int pointTwoY) {
        int differenceOne;
        int differenceTwo;
        double addendOne;
        double addendTwo;
        double result;

        differenceOne = pointOneX - pointTwoX;
        differenceTwo = pointOneY - pointTwoY;

        addendOne = Math.pow(differenceOne, 2);
        addendTwo = Math.pow(differenceTwo, 2);

        result = Math.sqrt(addendOne + addendTwo);

        return result;
    }
}