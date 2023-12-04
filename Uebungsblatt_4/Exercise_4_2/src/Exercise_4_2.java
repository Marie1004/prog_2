import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Die Krankenversicherung plant nun eine Erhöhung der individuellen Prämien um
 * 1% pro Monat im Jahr 2024. Versicherte mit mehr als 2 Kindern sollen eine 50%ige
 * Ermäßigung erhalten. Berechnen Sie die Prämieneinnahmen des Unternehmens im nächsten
 * Jahr.
 */
public class Exercise_4_2 {
    public static void main(String[] args) throws FileNotFoundException {
        BigDecimal newChargesInTotal;

        newChargesInTotal = new BigDecimal(calculateNewCharges());

        System.out.println("Die Prämieneinnahmen des Unternehmens im nächsten Jahr: " + newChargesInTotal);
    }

    /*
     * Der Vorteil einer ArrayList:
     * - die Groeße der Liste muss noch nicht endgültig feststehen, sondern ist flexibel
     * - kann nur Objekttypen in die Sammlung aufnehmen, was auch geplant ist
     */

    /**
     * Erstellen der ArrayList aus der CSV-Datei
     * 1. Die Datei Zeile fuer Zeile durchgehen
     * 2. Die Daten fuer den jeweiligen Kunden in einem Objekt sichern
     * 3. Das Objekt in einer ArrayList sichern
     *
     * @return clientList – Eine ArrayList mit relevanten Daten der Kunden
     * @throws FileNotFoundException
     */
    public static ArrayList<InsuranceClient> getClientList() throws FileNotFoundException {
        int children;
        double charges;

        // Erzeugen des Kunden-Objekts
        InsuranceClient insuranceClient = new InsuranceClient(0,0);
        // Erstellen der ArrayList
        ArrayList<InsuranceClient> clientList = new ArrayList<InsuranceClient>();

        // Verweis auf die Datei
        File file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_4/Exercise_4_2/inc/insurance.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Zerlegen des Strings in Teilstrings
            String[] values = line.split(",");

            // Konvertiert einen String in einen Int-Wert
            children = Integer.parseInt(values[3]);
            charges = Double.parseDouble(values[6]);

            insuranceClient = new InsuranceClient(children,charges);
            // Einfuegen des Kunden-Objekts in die Liste
            clientList.add(insuranceClient);
        }
        scanner.close();
        return clientList;
    }

    /**
     * Kalkulieren der neuen Gebühren und der neuen Gebühreneinnahmen der Versicherung im kommenden Jahr
     * @return newChargesInTotal – Die neuen Gebühreneinnahmen der Versicherung im kommenden Jahr
     * @throws FileNotFoundException
     */
    public static double calculateNewCharges() throws FileNotFoundException {
        ArrayList<InsuranceClient> clientList = new ArrayList<InsuranceClient>();
        int children;
        double charges;
        double chargesIncrease;
        double newCharges;
        double newChargesInTotal = 0;
        double chargesIncreasePercentage = 0.01;
        double benefitsForTwoChildren = 0.5;


        // Auslesen der CSV-Datei
        clientList = getClientList();


        for(InsuranceClient c: clientList) {
            children = c.getChildren();
            charges = c.getCharges();

            chargesIncrease = charges * chargesIncreasePercentage;

            if(children > 2) {
                chargesIncrease *= benefitsForTwoChildren;
            }

            newCharges = charges + chargesIncrease;


            newChargesInTotal += newCharges;
        }

        return newChargesInTotal;
    }
}