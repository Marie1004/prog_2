import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicketWinner extends Author {
    int numberOfTickets;
    public TicketWinner(String name, String surname, int numberOfTickets) {
        super(name, surname);
    }

    // Ermitteln der Tickets, die verlost werden
    public static TicketWinner raffleTickets(ArrayList<Author> authorList , int numberOfAuthors , int numberOfTickets) {
        // Es wird zufällig ein Gewinner ausgewählt
        Random r = new Random();
        int low = 0;
        int high = numberOfAuthors;
        int winnerNumber = r.nextInt(high-low) + low;
        // TODO: Hier die 0 gegen den richitgen Wert ersetzen
        TicketWinner winner = new TicketWinner(authorList.get(winnerNumber).getName(), authorList.get(winnerNumber).getSurname(), 0);


        return winner;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        // Verweis auf die Datei
        File file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_6/Exercise_6_3/inc/nutrition_publications.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Zerlegen des Strings in Teilstrings
            String[] values = line.split(";");
            //System.out.println("String mit allen Autoren: " + values[1]);
            String authors = values[1];
            String[] authorName = authors.split(", ");

            for(int i = 0; i < authorName.length; i++) {
                //System.out.println("String mit dem jeweiligen Autor: " + authorName[i]);
                String[] authorNamePart = authorName[i].split(" ");
                name = authorNamePart[0];
                for(int j = 1; j < (authorNamePart.length - 1); j++) {
                    name = name.concat(" " + authorNamePart[j]);
                    //System.out.println("j: " + j);
                }
                //System.out.println("end of loop");

                //System.out.println("name: " + name);

                surname = authorNamePart[authorNamePart.length-1];
                //System.out.println("surname: " + authorNamePart[authorNamePart.length-1]);

                author = new Author(name, surname);

                // Einfuegen des Author-Objekts in die Liste
                authorList.add(author);
            }
        }

        scanner.close();;
        // TODO: Ermitteln, wie viele Mitarbeiter diese Person hat und entsprechend die Ticketanzahl festlegen
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
