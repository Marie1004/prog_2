import java.util.Arrays;
import java.util.Scanner;

/**
 * Schreiben Sie ein Programm in Java,
 * das von dem/der Benutzer/in die Nummer der Operation erhält, die auf einem Array ausgeführt werden soll,
 * und ggf. die entsprechenden Parameter (bspw. Ausgabe des aktuellen Arrays, Ausgabe von Statistiken, Suchen eines
 * Elements, Löschen eines Elements, Hinzufügen eines Elements) und das entsprechende Ergebnis ausgibt.
 * Die Frage nach der gewünschten Operation soll unendlich oft gestellt werden.
 * Dafür können Sie eine "ewige" while-Schleife mit dem Servicewert true anstelle einer Bedingung ausführen.
 * Das Programm soll nur im Falle einer falschen Eingabe abgebrochen werden.
 */
public class Exercise_2_2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int[] userArray;
        boolean go = true;
        int operation;
        int elementIndex;

        // Erfragen des Arrays beim Nutzer
        userArray = getArrayFromUser(userInput);


        while(go) {
            System.out.println("\nDas aktuelle Array lautet: " + Arrays.toString(userArray));
            System.out.println("Welche der folgenden Operationen soll ausgeführt werden?");
            System.out.println("\n1) Berechnung des Durchschnitts");
            System.out.println("2) Berechnung der Standardabweichung");
            System.out.println("3) Berechnung des Maximalwerts");
            System.out.println("4) Berechnung des Minimalwerts");
            System.out.println("5) Berechnung der Statistik");
            System.out.println("6) Ermittlung des Index eines Elements");
            System.out.println("7) Entfernen eines bestimmten Elements");
            System.out.println("8) Einfügen eines Elements an einer bestimmten Position");

            // Abfrage nach der Nummer der entsprechenden Operation
            operation = userInput.nextInt();

            switch(operation) {
                case 1:
                    // Berechnung des Durchschnitts der Elemente in einem Array
                    System.out.println("\nDer Durchschnitt der Elemente lautet: " + operation1(userArray));
                    break;
                case 2:
                    // Berechnung der Standardabweichung der Elemente in einem Array
                    System.out.println("\nDie Standardabweichung der Elemente lautet: " + operation2(userArray));
                    break;
                case 3:
                    // Berechnung des Maximalwerts in einem Array
                    System.out.println("\nDer Maximalwert der Elemente lautet: " + operation3(userArray));
                    break;
                case 4:
                    // Berechnung des Minimalwerts in einem Array
                    System.out.println("\nDer Minimalwert der Elemente lautet: " + operation4(userArray));
                    break;
                case 5:
                    operation5(userArray);
                    break;
                case 6:
                    elementIndex = operation6(userArray, userInput);
                    if(elementIndex < 0) {
                        System.out.println("\nKeines der Elemente des Arrays besitzt diesen Wert.");
                    } else {
                        System.out.println("\nDas Element mit diesem Wert befindet sich an der Stelle (Index): " + elementIndex);
                    }
                    break;
                case 7:
                    // g) Entfernen eines bestimmten Elements in einem Array;
                    System.out.print("\nDie Elemente des neuen Arrays lauten: " + Arrays.toString(operation7(userArray, userInput)));
                    break;
                case 8:
                    // h) Einfügen eines Elements an einer bestimmten Position in ein Array
                    System.out.print("\nDie Elemente des neuen Arrays lauten: " + Arrays.toString(operation8(userArray, userInput)));
                    break;
                default:
                    System.out.print("\nLeider ist dies eine ungültige Eingabe.\nStarten Sie das Programm erneut, um eine Berechnung durchführen zu lassen.");
                    go = false;
                    break;
            }
        }
    }

    /**
     * Das Array vom Nutzer erhalten
     * @param userInput - fuer Nutzereingaben im Terminal
     * @return elements - das vom Nutzer angegebene Array
     */
    public static int[] getArrayFromUser(Scanner userInput) {
        int arrayLength;
        int[] elements;


        System.out.println("\nWie lang ist das Array?");
        arrayLength = userInput.nextInt();
        elements = new int[arrayLength];

        for(int i = 0; i < elements.length; i++) {
            System.out.println("\nWie lautet der Wert des Elements an Stelle " + i + "? (Ohne Komma)");
            elements[i] = userInput.nextInt();
        }

        return elements;
    }

    /**
     * a) Berechnung des Durchschnitts der Elemente in einem Array
     *
     * @param elements - das originale Array durch Nutzereingabe
     * @return average - der Durchschnittwert
     */
    public static double operation1(int[] elements) {
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
    public static double operation2(int[] elements) {
        double underSquareRoot = 0;
        int denominator;
        double counter;
        double standardDeviation;
        double average;

        average = operation1(elements);

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
    public static int operation3(int[] elements) {
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
    public static int operation4(int[] elements) {
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
    public static void operation5(int[] elements) {
        // a) Berechnung des Durchschnitts der Elemente in einem Array
        System.out.println("\nDer Durchschnitt der Elemente lautet: " + operation1(elements));

        // b) Berechnung der Standardabweichung der Elemente in einem Array
        System.out.println("\nDie Standardabweichung der Elemente lautet: " + operation2(elements));

        // c) Berechnung des Maximalwerts in einem Array
        System.out.println("\nDer Maximalwert der Elemente lautet: " + operation3(elements));

        // d) Berechnung des Minimalwerts in einem Array
        System.out.println("\nDer Minimalwert der Elemente lautet: " + operation4(elements));
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
    public static int operation6(int[] elements, Scanner userInput) {
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
    public static int[] operation7(int[] elements, Scanner userInput) {
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
    public static int[] operation8(int[] elements, Scanner userInput) {
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