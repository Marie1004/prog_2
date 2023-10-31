import java.util.Random; // Step 1
import java.util.Scanner; // Fuer den Input bzw. die Scanner-Klasse
import javax.swing.JOptionPane;

public class Exercise3 {
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
                System.out.println("\nLeider hast du diemal die Zahl nicht erraten. Viel Glück beim nächsten Mal.");
                break;
            }
        }


    }

    /**
     * Erzeugen der Zufallszahl
     *
     * @return
     */
    public static int getRandomNumber() {
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);

        return secret;
    }

    /**
     * Abfrage der Zahl beim Benutzer
     *
     * @return
     */
    public static int getUserNumber() {
        Scanner userInput = new Scanner(System.in);
        int num;

        System.out.println("\nNenne mir eine Zahl zwischen 1 und 10.");
        num = userInput.nextInt();

        return num;
    }
}