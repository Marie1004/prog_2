import java.util.Scanner;
import java.util.Arrays;


/**
 * Schreiben Sie ein Java-Programm mit den folgenden statischen Methoden (nutzen
 * Sie Ihre bisherigen Lösungen, ggf. schreiben Sie Ihren Code entsprechend um):
 * a) Berechnung des Durchschnitts der Elemente in einem Array;
 * b) Berechnung der Standardabweichung der Elemente in einem Array;
 * c) Berechnung des Maximalwerts in einem Array;
 * d) Berechnung des Minimalwerts in einem Array;
 * e) Berechnung der Statistik in einem Array;
 * f) Ermittlung des Index eines Elements in einem Array nach Wert;
 * g) Entfernen eines bestimmten Elements in einem Array;
 * h) Einfügen eines Elements an einer bestimmten Position in ein Array.
 * Verwenden Sie bei Bedarf weitere Methoden Ihrer Wahl aus der Arrays-Klassenbibliothek1.
 *
 */
public class Exercise1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int arrayLength;
        int elementIndex;


        System.out.println("\nWie lang ist das Array?");
        arrayLength = userInput.nextInt();
        int[] elements = new int[arrayLength];

        for(int i = 0; i < elements.length; i++) {
            System.out.println("\nWie lautet der Wert des Elements an Stelle " + i + "? (Ohne Komma)");
            elements[i] = userInput.nextInt();
        }

        // e) Berechnung der Statistik in einem Array
        task1e(elements);


        // f) Ermittlung des Index eines Elements in einem Array nach Wert
        elementIndex = task1f(elements, userInput);
        if(elementIndex < 0) {
            System.out.println("\nKeines der Elemente des Arrays besitzt diesen Wert.");
        } else {
            System.out.println("\nDas Element mit diesem Wert befindet sich an der Stelle (Index): " + elementIndex);
        }


        System.out.print("\nDie Elemente des Arrays lauten: " + Arrays.toString(elements));

        // g) Entfernen eines bestimmten Elements in einem Array;
        System.out.print("\nDie Elemente des neuen Arrays lauten: " + Arrays.toString(task1g(elements, userInput)));

        // h) Einfügen eines Elements an einer bestimmten Position in ein Array
        System.out.print("\nDie Elemente des neuen Arrays lauten: " + Arrays.toString(task1h(elements, userInput)));
    }

    /**
     * a) Berechnung des Durchschnitts der Elemente in einem Array
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @return average - der Durchschnittwert
     */
    public static double task1a(int[] elements) {
        double sum = 0;
        double average;

        for(int element: elements) {
            sum = sum + element;
        }

        average = sum / elements.length;

        return average;
    }

    /**
     * b) Berechnung der Standardabweichung der Elemente in einem Array
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @return standardDeviation - die Standardabweichung
     */
    public static double task1b(int[] elements) {
        double underSquareRoot = 0;
        int denominator;
        double counter;
        double standardDeviation;
        double average;

        average = task1a(elements);

        for(int element: elements) {
            underSquareRoot = underSquareRoot + Math.pow((element - average), 2);
        }

        denominator = elements.length - 1;

        counter = Math.sqrt(underSquareRoot);

        standardDeviation = counter / denominator;

        return standardDeviation;
    }

    /**
     * c) Berechnung des Maximalwerts in einem Array
     * Durch "Quicksort" werden die Werte des Arrays sortiert
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @return max - der hoechste Wert der Elemente im Array
     */
    public static int task1c(int[] elements) {
        int max;

        Arrays.sort(elements);
        max = elements[elements.length-1];

        return max;
    }

    /**
     * d) Berechnung des Minimalwerts in einem Array
     * Durch "Quicksort" werden die Werte des Arrays sortiert
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @return min - der niedrigste Wert der Elemente im Array
     */
    public static int task1d(int[] elements) {
        int min;

        Arrays.sort(elements);
        min = elements[0];

        return min;
    }

    /**
     * e) Berechnung der Statistik in einem Array
     *
     * @param elements - das originale Array durch Nutzereingabe
     */
    public static void task1e(int[] elements) {
        // a) Berechnung des Durchschnitts der Elemente in einem Array
        System.out.println("\nDer Durchschnitt der Elemente lautet: " + task1a(elements));

        // b) Berechnung der Standardabweichung der Elemente in einem Array
        System.out.println("\nDie Standardabweichung der Elemente lautet: " + task1b(elements));

        // c) Berechnung des Maximalwerts in einem Array
        System.out.println("\nDer Maximalwert der Elemente lautet: " + task1c(elements));

        // d) Berechnung des Minimalwerts in einem Array
        System.out.println("\nDer Minimalwert der Elemente lautet: " + task1d(elements));
    }

    /**
     * f) Ermittlung des Index eines Elements in einem Array nach Wert
     * Zunächst erfolgt eine Sortierung, welche für die binäre Suche wichtig ist.
     * Die binäre Suche nach dem Element bzw. seinem Index auf Grundlage der Sortierung.
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return searchedIndex - der Index des gesuchten Elements
     */
    public static int task1f(int[] elements, Scanner userInput) {
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
     * @param elements - das originale Array durch Nutzereingabe
     * @param searchedElement - das gesuchte Element
     * @return searchedIndex - der Index des gesuchten Elements
     */
    public static int findIndex(int[] elements, int searchedElement) {
        int searchedIndex;

        Arrays.sort(elements);
        searchedIndex = Arrays.binarySearch(elements, searchedElement); // Wenn Element nicht gefunden, dann ist der Rueckgabewert negativ

        return searchedIndex;
    }

    /**
     * g) Entfernen eines bestimmten Elements in einem Array
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return newArray - ein neues Array mit den verbleibenden Elementen
     */
    public static int[] task1g(int[] elements, Scanner userInput) {
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
     * h) Einfuegen eines Elements an einer bestimmten Position in ein Array
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return newArray - ein neues Array mit dem zusaetzlichen Element
     */
    public static int[] task1h(int[] elements, Scanner userInput) {
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