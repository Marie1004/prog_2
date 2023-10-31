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
     * @param args - Standard
     */

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int arrayLength;
        int elementIndex;
        int[] newElements;



        System.out.println("\nWie lang ist das Array?");
        arrayLength = userInput.nextInt();
        int[] elements = new int[arrayLength];

        for(int i = 0; i < elements.length; i++) {
            System.out.println("\nWie lautet der Wert des Elements an Stelle " + i + "? (Ohne Komma)");
            elements[i] = userInput.nextInt();
        }

        // a) Berechnung des Durchschnitts der Elemente in einem Array
        System.out.println("\nDer Durchschnitt der Elemente lautet: " + task2a(elements));

        // b) die Standardabweichung der Elemente im Array berechnet
        System.out.println("\nDie Standardabweichung der Elemente lautet: " + task2b(elements));

        // c) den Maximalwert der Elemente im Array berechnet
        System.out.println("\nDer Maximalwert der Elemente lautet: " + task2c(elements));

        // d) den Minimalwert der Elemente im Array berechnet
        System.out.println("\nDer Minimalwert der Elemente lautet: " + task2d(elements));

        // e) den Index eines Elements im Array nach Wert bestimmt
        elementIndex = task2e(elements, userInput);
        if(elementIndex == -1) {
            System.out.println("\nKeines der Elemente des Arrays besitzt diesen Wert.");
        } else {
            System.out.println("\nDas Element mit diesem Wert befindet sich an der Stelle (Index): " + elementIndex);
        }

        // f) ein bestimmtes Element im Array entfernt
        // Output original Array
        arrayOutput(elements, false);

        newElements = task2f(elements, userInput);
        arrayOutput(newElements, true);

        // g) ein Element an einer bestimmten Position im Array hinzufuegt
        newElements = task2g(elements, userInput);
        arrayOutput(newElements, true);
    }

    /**
     * Output der Elemente des Arrays
     * @param array - das jeweilige Array
     * @param newArray - Boolean, der aussagt, ob das array das Original oder ein neu erstelltes ist
     */
    public static void arrayOutput(int[] array, boolean newArray) {
        if(!newArray) {
            System.out.print("\nDie Elemente des Arrays lauten: ");
        } else {
            System.out.print("\nDie Elemente des neuen Arrays lauten: ");
        }
        for (int element: array) {
            System.out.print(element + "; ");
        }
    }

    /**
     * Berechnung des Durchschnitts
     *
     * @param elements - das originale Array
     * @return average - den Durchschnittswert der Elemente im Array
     */
    public static double task2a(int[] elements) {
        double sum = 0;
        double average;

        for(int element: elements) {
            sum = sum + element;
        }

        average = sum / elements.length;

        return average;
    }

    /**
     * Berechnung der Standardabweichung
     *
     * @param elements - das originale Array
     * @return standardDeviation - die Standardabweichung
     */
    public static double task2b(int[] elements) {
        double underSquareRoot = 0;
        int denominator;
        double counter;
        double standardDeviation;
        double average;

        average = task2a(elements);

        for(int element: elements) {
            underSquareRoot = underSquareRoot + Math.pow((element - average),2);
        }

        denominator = elements.length - 1;

        counter = Math.sqrt(underSquareRoot);

        standardDeviation = counter / denominator;

        return standardDeviation;
    }

    /**
     * Berechnung des Maximalwerts der Elemente
     *
     * @param elements - das originale Array
     * @return max - der hoechste im Array enthaltene Wert
     */
    public static int task2c(int[] elements) {
        int max = elements[0];

        if(elements.length > 1) {
            for(int element: elements) {
                if(max < element) {
                    max = element;
                }
            }
        }

        return max;
    }

    /**
     * Berechnung des Minimalwerts der Elemente
     *
     * @param elements - das originale Array
     * @return min - der niedrigste im Array enthaltene Wert
     */
    public static int task2d(int[] elements) {
        int min = elements[0];

        if(elements.length > 1) {
            for(int element: elements) {
                if (min > element) {
                    min = element;
                }
            }
        }

        return min;
    }

    /**
     * Bestimmen des Indexes eines Elements im Array
     *
     * @param elements - das originale Array
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return searchedIndex - der Index des vom Nutzer gesuchten Elements
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
     * @param elements - das originale Array
     * @param searchedElement - das vom Nutzer gesuchte Element
     * @return i / -1 - der gesuchte Index
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
     * Loeschen eines Elements aus dem Array
     *
     * @param elements - das originale Array
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return newArray - ein neues Array mit den verbleibenden Elementen
     */
    public static int[] task2f(int[] elements, Scanner userInput) {
        int searchedElement;
        int searchedIndex = -1;

        System.out.println("\nWelches Element soll aus dem Array entfernt werden?");

        while(searchedIndex == -1) {
            searchedElement = userInput.nextInt();

            searchedIndex = findIndex(elements, searchedElement);

            if(searchedIndex == -1) {
                System.out.println("Diese Zahl ist kein Element der Liste. Bitte wähle eines der folgenden Elemente aus.");
                for(int element: elements) {
                    System.out.print(element + "; ");
                    System.out.println();
                }
            }
        }

        int[] newArray = new int[elements.length - 1];

        for(int i = 0; i < searchedIndex; i++) {
            newArray[i] = elements[i];
        }

        for(int j = searchedIndex + 1; j < elements.length; j++) {
            newArray[(j-1)] = elements[j];
        }

        return newArray;
    }

    /**
     * Hinzufuegen eines Elements
     *
     * @param elements - das originale Array
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return newArray - ein neues Array mit dem zusaetzlichen Element
     */
    public static int[] task2g(int[] elements, Scanner userInput) {
        int newElement;
        int newIndex;

        System.out.println("\nWelches Element soll dem Array hinzugefügt werden?");
        newElement = userInput.nextInt();

        System.out.println("\nAn welchen Index soll das Element hinzugefügt werden?");
        newIndex = userInput.nextInt();

        while(newIndex < 0 || newIndex > (elements.length + 1)) {
            System.out.println("\nDieser Index kann nicht gewählt werden. Bitte wähle einen Index zwischen 0 und " + (elements.length + 1));
            newIndex = userInput.nextInt();
        }

        int newArrayLength = elements.length + 1;

        int[] newArray = new int[newArrayLength];

        for(int i = 0; i < newIndex; i++) {
            newArray[i] = elements[i];
        }

        newArray[newIndex] = newElement;

        for(int j = newIndex; j < elements.length; j++) {
            newArray[(j + 1)] = elements[j];
        }

        return newArray;
    }
}