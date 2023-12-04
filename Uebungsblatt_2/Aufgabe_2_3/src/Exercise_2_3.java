import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Lesen Sie eine beliebige Spalte, z.B. int, als Array aus einer csv-Datei und testen
 * Sie Ihr Programm erneut.
 */
public class Exercise_2_3 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] ageArray;

        System.out.println("Start");

        ageArray = readAgeFromFile();
        System.out.println("Die Alter der Patienten lauten: " + Arrays.toString(ageArray));

    }

    public static int[] readAgeFromFile() throws FileNotFoundException {
        int[] age;
        int i = 0;

        // Verweis auf die Datei
        File file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_2/Aufgabe_2_3/inc/insurance.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();

        // Zaehlen der Zeilen der CSV-Datei
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            i++;
        }

        // Erstellen des Arrays in der benoetigten Groesse entsprechend der Zeilenzahl
        age = new int[i];
        i = 0;

        scanner = new Scanner(file);
        scanner.nextLine();

        // Einlesen der Daten in das Array
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Zerlegen des Strings in Teilstrings
            String[] values = line.split(",");

            // Konvertiert einen String in einen Int-Wert
            age[i] = Integer.parseInt(values[0]);

            i++;
        }
        scanner.close();
        return age;
    }
}