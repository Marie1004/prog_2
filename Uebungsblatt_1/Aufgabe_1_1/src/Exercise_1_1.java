import java.util.Scanner; // Fuer den Input / die Scanner-Klasse

/**
 * Schreiben Sie ein Java-Programm, das vom Benutzer
 * a) den Namen erhält und eine personalisierte Begrüßung ausgibt.
 * b) eine Zahl erhält und ausgibt, ob sie positiv, gleich Null oder negativ ist.
 * c) zwei Zahlen erhält und die Summe (Addition), Multiplikation, Subtraktion, Division ausgibt.
 * d) drei Zahlen erhält und die höchste Zahl ausgibt.
 * e) a, b und c erhält und die entsprechende quadratische Gleichung löst.
 */
public class Exercise_1_1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        task1a(userInput);
        task1b(userInput);
        task1c(userInput);
        task1d(userInput);
        task1e(userInput);
    }

    /**
     * Eine Funktion, welche den Namen des Users abfragt und in einer personalisierten Begrueßung ausgibt
     *
     * @param userInput  - fuer Nutzereingaben im Terminal
     */
    public static void task1a(Scanner userInput) {
        String userName;

        System.out.println("Wie lautet dein Name?");
        userName = userInput.next();

        System.out.println("\nHallo " + userName + "!\nEs ist schön dich kennenzulernen.");
    }

    /**
     * Eine Funktion, die eine Zahl vom User abfragt und ausgibt, ob sie positiv, gleich Null oder negativ ist
     *
     * @param userInput
     */
    public static void task1b(Scanner userInput) {
        double num;
        String resultString;

        System.out.println("\nGib bitte eine beliebige Zahl ein?\n(Verwende bitte ein Komma im Falle einer Gleitkommazahl).");
        num = userInput.nextDouble();

        System.out.println("\nDie von Ihnen angegebene Zahl lautet: " + num);

        if(num > 0) { resultString = "positiv"; }
        else if(num == 0) { resultString = "gleich Null";}
        else { resultString = " negativ";}

        System.out.println("\nDie von Ihnen angegebene Zahl ist: " + resultString);
    }

    /**
     * Eine Funktion, die zwei Zahlen vom User abfragt und die Summe (Addition), Multiplikation, Subtraktion, Division ausgibt
     *
     * @param userInput  - fuer Nutzereingaben im Terminal
     */
    public static void task1c(Scanner userInput) {
        double num1;
        double num2;
        double addition;
        double multiplication;
        double subtraction;
        double division;

        System.out.println("\nGib bitte zwei beliebige Zahlen für die Berechnungen ein.\n(Verwende bitte ein Komma im Falle einer Gleitkommazahl).\nZahl 1 lautet?");
        num1 = userInput.nextDouble();

        System.out.println("\nZahl 2 lautet?");
        num2 = userInput.nextDouble();

        addition = num1 + num2;
        multiplication = num1 * num2;
        subtraction = num1 - num2;
        division = num1 / num2;

        System.out.println("\n" + num1 + " + " + num2 + " = " + addition);

        System.out.println("\n" + num1 + " * " + num2 + " = " + multiplication);

        System.out.println("\n" + num1 + " - " + num2 + " = " + subtraction);

        System.out.println("\n" + num1 + " / " + num2 + " = " + division);
    }

    /**
     * Eine Funktion, die drei Zahlen vom User abfragt und die hoechste Zahl ausgibt
     *
     * @param userInput - fuer Nutzereingaben im Terminal
     */
    public static void task1d(Scanner userInput) {
        double num1;
        double num2;
        double num3;
        double highestNum;

        System.out.println("\nGib bitte drei Zahlen ein.\n(Verwende bitte ein Komma im Falle einer Gleitkommazahl).");

        System.out.println("\nZahl 1 lautet?");
        num1 = userInput.nextDouble();

        System.out.println("\nZahl 2 lautet?");
        num2 = userInput.nextDouble();

        System.out.println("\nZahl 3 lautet?");
        num3 = userInput.nextDouble();


        double[] numbers = {num1, num2, num3};

        highestNum = getHighestNumber(numbers);
        System.out.println("\nDie Höchste der drei angegebenen Zahlen lautet: " + highestNum);
    }

    /**
     * Ermitteln der höchsten Zahl
     *
     * @param numbers - das Array mit den Zahlen
     * @return highestNum - die hoechste Nummer
     */
    public static double getHighestNumber(double[] numbers) {
        double highestNum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > highestNum) {
                highestNum = numbers[i];
            }
        }

        return highestNum;
    }

    /**
     * Eine Funktion, die für a, b und c jeweils Zahlen vom User abfragt und mit diesen die entsprechende quadratische Gleichung löst
     *
     * @param userInput - fuer Nutzereingaben im Terminal
     */
    public static void task1e(Scanner userInput) {
        double a;
        double b;
        double c;
        int arrayLength;
        double denominator;
        double bHoch2;
        double underSquareRoot;
        double squareRoot;
        double counter1;
        double counter2;

        System.out.println("\nGib bitte jeweils den Wert für a, b und c ein.\n(Verwende bitte ein Komma im Falle einer Gleitkommazahl).");

        // Abfrage der drei Werte
        System.out.println("\nDer Wert für a lautet?");
        a = userInput.nextDouble();

        System.out.println("\nDer Wert für b lautet?");
        b = userInput.nextDouble();

        System.out.println("\nDer Wert für c lautet?");
        c = userInput.nextDouble();

        // Berechnen des Nenners
        denominator = 2 * a;

        // Ermitteln des Wertes unter der Wurzel im Zaehler
        bHoch2 = Math.pow(b, 2);
        underSquareRoot = bHoch2 - (4 * a * c);
        System.out.println("underSquareRoot = " + underSquareRoot);

        arrayLength = determineNumberOfSolutions(underSquareRoot);

        // Prüfen, ob ein Wert fuer x existieren kann
        if (arrayLength == 0) {
            System.out.println("\nEs existiert keine Lösung für x.");
            // Ermitteln der Loesungsmenge anhand der des Wertes unter der Wurzel
            arrayLength = determineNumberOfSolutions(underSquareRoot);
            System.out.println("arrayLength = " + arrayLength);

            // Erstellen der Loesungsmenge
            double[] x = new double[arrayLength];

            // Berechnen der Quadratwurzel des Zaehlers
            squareRoot = Math.sqrt(underSquareRoot);
            System.out.println("\nsquareRoot = " + squareRoot);

            counter1 = ((-1) * b) + squareRoot;
            System.out.println("\ncounter1 = " + counter1);

            x[0] = (-1) * (counter1 / denominator);
            System.out.println("x[0] = " + x[0]);

            if (arrayLength == 2) {
                counter2 = ((-1) * b) - squareRoot;
                x[1] = (-1) * (counter2 / denominator);
                System.out.println("x[1] = " + x[1]);

                System.out.print("Die Ergebnisse der Gleichung lauten: x1 = " + x[0] + "; x2 = " + x[1]);
            } else {
                System.out.print("Das Ergebnis der Gleichung lautet: x = " + x[0]);
            }
        } else {
            // Ermitteln der Loesungsmenge anhand der des Wertes unter der Wurzel
            arrayLength = determineNumberOfSolutions(underSquareRoot);
            System.out.println("arrayLength = " + arrayLength);

            // Erstellen der Loesungsmenge
            double[] x = new double[arrayLength];

            // Berechnen der Quadratwurzel des Zaehlers
            squareRoot = Math.sqrt(underSquareRoot);
            System.out.println("\nsquareRoot = " + squareRoot);

            counter1 = ((-1) * b) + squareRoot;
            System.out.println("\ncounter1 = " + counter1);

            x[0] = (-1) * (counter1 / denominator);
            System.out.println("x[0] = " + x[0]);

            if (arrayLength == 1) {
                System.out.print("Das Ergebnis der Gleichung lautet: x = " + x[0]);
            } else {
                counter2 = ((-1) * b) - squareRoot;
                x[1] = (-1) * (counter2 / denominator);
                System.out.println("x[1] = " + x[1]);

                System.out.print("Die Ergebnisse der Gleichung lauten: x1 = " + x[0] + "; x2 = " + x[1]);
            }
        }
    }

    /**
     * Ermitteln der Loesungsmenge von x
     *
     * @param underSquareRoot - die Werte unter der Wurzel
     * @return foundArrayLength - die Array-Laenge
     */
    public static int determineNumberOfSolutions(double underSquareRoot) {
        int foundArrayLength;

        if (underSquareRoot < 0) {
            foundArrayLength = 0;
        } else if (underSquareRoot == 0) {
            foundArrayLength = 1;
        } else {
            foundArrayLength = 2;
        }

        return foundArrayLength;
    }
}