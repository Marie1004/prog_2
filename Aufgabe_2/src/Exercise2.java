import java.util.Scanner; // Fuer den Input bzw. die Scanner-Klasse

public class Exercise2 {
    /**
     * Schreiben Sie ein Java-Programm, das:
     * - die Länge eines Arrays,
     * - die Werte der Elemente und möglicherweise weitere Werte (z. B. den Index, den Wert eines bestimmten
     * Elements, den Index einer bestimmten Position)
     * vom Benutzer erhält und:
     * a) den Durchschnitt der Elemente im Array berechnet;
     * b) die Standardabweichung der Elemente im Array berechnet;
     * c) den Maximalwert der Elemente im Array berechnet;
     * d) den Minimalwert der Elemente im Array berechnet;
     * e) den Index eines Elements im Array nach Wert bestimmt;
     * f) ein bestimmtes Element im Array entfernt;
     * g) ein Element an einer bestimmten Position im Array hinzufügt.
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int arrayLength;
        double average;
        double standardDeviation;
        int min;
        int max;
        int elementIndex;


        System.out.println("\nWie lang ist das Array?");
        arrayLength = userInput.nextInt();
        int[] elements = new int[arrayLength];

        for(int i = 0; i < elements.length; i++) {
            System.out.println("\nWie lautet der Wert des Elements an Stelle " + i + "? (Ohne Komma)");
            elements[i] = userInput.nextInt();
        }

        average = task2a(elements);
        System.out.println("\nDer Durchschnitt der Elemente lautet: " + average);

        standardDeviation = task2b(elements, average);
        System.out.println("\nDie Standardabweichung der Elemente lautet: " + standardDeviation);

        max = task2c(elements);
        System.out.println("\nDer Maximalwert der Elemente lautet: " + max);

        min = task2d(elements);
        System.out.println("\nDer Minimalwert der Elemente lautet: " + min);

        elementIndex = task2e(elements, userInput);
        if(elementIndex == -1) {
            System.out.println("\nKeines der Elemente des Arrays besitzt diesen Wert.");
        } else {
            System.out.println("\nDas Element mit diesem Wert befindet sich an der Stelle (Index): " + elementIndex);
        }

        System.out.print("\nDie Elemente des Arrays lauten: ");
        for(int j = 0; j < elements.length; j++) {
            System.out.print(elements[j] + "; ");
        }
        int[] newShorterElements = task2f(elements, userInput);

        System.out.print("\nDie Elemente des neuen Arrays lauten: ");
        for(int k = 0; k < newShorterElements.length; k++) {
            System.out.print(newShorterElements[k] + "; ");
        }

        int[] newLongerElements = task2g(elements, userInput);

        System.out.print("\nDie Elemente des neuen Arrays lauten: ");
        for(int l = 0; l < newLongerElements.length; l++) {
            System.out.print(newLongerElements[l] + "; ");
        }
    }

    /**
     * Berechnung des Durchschnitts
     *
     * @param elements
     * @return
     */
    public static double task2a(int[] elements) {
        double sum = 0;
        double average;

        for(int i = 0; i < elements.length; i++) {
            sum = sum + elements[i];
        }

        average = sum / elements.length;

        return average;
    }

    /**
     * Berechnung der Standardabweichung
     *
     * @param elements
     * @param average
     * @return
     */
    public static double task2b(int[] elements, double average) {
        double underSquareRoot = 0;
        int denominator;
        double counter;
        double standardDeviation;

        for(int i = 0; i < elements.length; i++) {
            underSquareRoot = underSquareRoot + Math.pow((elements[i] - average),2);
        }

        denominator = elements.length - 1;

        counter = Math.sqrt(underSquareRoot);

        standardDeviation = counter / denominator;

        return standardDeviation;
    }

    /**
     * Berechnung des Maximalwerts der Elemente
     *
     * @param elements
     * @return
     */
    public static int task2c(int[] elements) {
        int max = elements[0];

        if(elements.length > 1) {
            for(int i = 0; i < elements.length; i++) {
                if(max < elements[i]) {
                    max = elements[i];
                }
            }
        }

        return max;
    }

    /**
     * Berechnung des Minimalwerts der Elemente
     *
     * @param elements
     * @return
     */
    public static int task2d(int[] elements) {
        int min = elements[0];

        if(elements.length > 0) {
            for(int i = 0; i < elements.length; i++) {
                if(min > elements[i]) {
                    min = elements[i];
                }
            }
        }

        return min;
    }

    /**
     * Bestimmen des Indexes eines Elements im Array
     *
     * @param elements
     * @param userInput
     * @return
     */
    public static int task2e(int[] elements, Scanner userInput) {
        int searchedElement;
        int searchedIndex;

        System.out.println("\nWie lautet das gesuchte Element? (Ohne Komma)");
        searchedElement = userInput.nextInt();

        searchedIndex = findIndex(elements, searchedElement);

        return searchedIndex;
    }

    /**
     * Finden des Indexes vom gesuchten Element
     *
     * @param elements
     * @param searchedElement
     * @return
     */
    public static int findIndex(int[] elements, int searchedElement) {
        for(int i = 0; i < elements.length; i++) {
            if(elements[i] == searchedElement) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Löschen eines Elements aus dem Array
     *
     * @param elements
     * @param userInput
     * @return
     */
    public static int[] task2f(int[] elements, Scanner userInput) {
        int searchedElement;
        int searchedIndex;

        System.out.println("\nWelches Element soll aus dem Array entfernt werden?");
        searchedElement = userInput.nextInt();

        searchedIndex = findIndex(elements, searchedElement);

        if(searchedIndex == -1) {
            return elements;
        } else {
            int[] newArray = new int[elements.length - 1];

            for(int i = 0; i < searchedIndex; i++) {
                newArray[i] = elements[i];
            }

            for(int j = searchedIndex + 1; j < elements.length; j++) {
                newArray[(j-1)] = elements[j];
            }

            return newArray;
        }
    }

    /**
     * Hinzufuegen eines Elements
     *
     * @param elements
     * @param userInput
     * @return
     */
    public static int[] task2g(int[] elements, Scanner userInput) {
        int newElement;
        int newIndex;

        System.out.println("\nWelches Element soll dem Array hinzugefügt werden?");
        newElement = userInput.nextInt();

        System.out.println("\nAn welchen Index soll das Element hinzugefügt werden?");
        newIndex = userInput.nextInt();

        int newArrayLength = elements.length + 1;

        int[] newArray = new int[newArrayLength];

        for(int i = 0; i < newIndex; i++) {
            newArray[i] = elements[i];
        }

        newArray[newIndex] = newElement;

        for(int j = newIndex; j < elements.length; j++) {
            newArray[(j+1)] = elements[j];
        }

        return newArray;
    }
}