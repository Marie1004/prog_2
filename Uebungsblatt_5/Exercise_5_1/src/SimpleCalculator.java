class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }


    public double getAdditionResult() {
        double result = getFirstNumber() + getSecondNumber();
        return result;
    }

    public double getSubtractionResult() {
        double result = getFirstNumber() - getSecondNumber();
        return result;
    }

    public double getMultiplicationResult() {
        double result = getFirstNumber() * getSecondNumber();
        return result;
    }

    public double getDivisionResult() {
        double result;

        double divisor = getSecondNumber();

        if (divisor == 0) {
            result = 0;
        } else {
            result = getFirstNumber() / divisor;
        }

        return result;
    }
}
