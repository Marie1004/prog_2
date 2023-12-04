import java.util.Random; // Step 1
import java.util.Scanner; // Fuer den Input bzw. die Scanner-Klasse
import javax.swing.JOptionPane;

/**
 * Schreiben Sie ein Java-Programm, das eine Zufallszahl von 1 bis 10 generiert und
 * den Benutzer auffordert, diese zu erraten.
 * Schritt 1:
 *      Erzeugen Sie zunächst eine Zufallszahl.
 * Schritt 2:
 *      Nun muss nur noch ein Vergleich des geheimen Wertes mit dem vom Benutzer
 *      eingegebenen Wert durchgeführt werden. Die Aufforderung zur Eingabe eines Wertes muss so
 *      lange wiederholt werden, bis der Benutzer ihn errät.
 *      Da wir nicht wissen, wie oft die Frage gestellt werden muss, führen wir absichtlich eine "ewige"
 *      while-Schleife mit dem Servicewert true anstelle einer Bedingung aus. Bei jedem Durchlauf
 *      der Schleife wird die vom Benutzer eingegebene Zahl mit dem im Programm eingegebenen
 *      Wert verglichen. Wenn sie übereinstimmt, wird eine Meldung angezeigt und die Schleife
 *      zwangsweise beendet. Die Anzahl der Versuche kann zehn nicht überschreiten, daher gibt es
 *      keine anderen Möglichkeiten, das Programm zu beenden.
 * Schritt 3 (optional):
 *      Verwenden Sie Dateneingabe und -ausgabe in modalen Fenstern.
 * Schritt 4:
 *      Fügen Sie dem Schleifenkörper einen Versuchszähler hinzu. Lassen Sie sich den
 *      Zählerstand in einem Fenster anzeigen: "Sie haben die Zahl erraten! Anzahl der Versuche:".
 * Schritt 5:
 *      Beenden Sie das Programm, wenn die Zahl 99 eingegeben wird.
 */
public class Exercise_1_3 {
    public static void main(String[] args) {
        int secretNumber;
        int userNumber;
        int counter = 0;

        secretNumber = getRandomNumber();

        while(true) {
            userNumber = getUserNumber();
            counter++;

            if(userNumber == 99) {
                System.out.println("\nBis zum nächsten Mal.");
                break;
            }


            if (userNumber < 1) {
                System.out.println("\nBitte wähle eine Zahl zwischen 1 und 10.");
            }
            else if (userNumber > 10) {
                System.out.println("\nBitte wähle eine Zahl zwischen 1 und 10.");
            }
            else if(userNumber == secretNumber) {
                System.out.println("\nDas ist richtig! Die gesuchte Zahl lautet " + secretNumber + ".\n Anzahl der Versuche: " + counter);
                JOptionPane.showMessageDialog (null, "Sie haben die Zahl erraten! Anzahl der Versuche: " + counter);
                break;
            }
            else {
                System.out.println("\nDas ist leider nicht richtg.");
            }

            if(counter == 10) {
                System.out.println("\nLeider hast du diesmal die Zahl nicht erraten. Viel Glück beim nächsten Mal.");
                break;
            }
        }


    }

    /**
     * Erzeugen der Zufallszahl
     *
     * @return secret - Zufallszahl
     */
    public static int getRandomNumber() {
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);

        return secret;
    }

    /**
     * Abfrage der Zahl beim Benutzer
     *
     * @return num - die geratene Nummer
     */
    public static int getUserNumber() {
        Scanner userInput = new Scanner(System.in);
        int num;

        System.out.println("\nNenne mir eine Zahl zwischen 1 und 10.");
        num = userInput.nextInt();

        return num;
    }
}