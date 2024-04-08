import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Exercise_6_3 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Author> authorList = new ArrayList<Author>();
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

        ticketList = createTicketList();
        authorList = createAuthorList(ticketList);

        // Ausgabe der Author-Namen
        outputOfAuthors(authorList);

        // Ermitteln der Anzahl an Autoren
        findNumberOfAuthors(authorList);

        // Verlosung der Tickets
        findWinner(ticketList);
    }

    public static void outputOfAuthors(ArrayList<Author> authorList) {
        String name;
        String surname;

        for(Author a: authorList) {
            name = a.getName();
            surname = a.getSurname();


            System.out.println("Name: " + name + "\nNachname: " + surname + "\n\n");
        }
    }

    public static void findNumberOfAuthors(ArrayList<Author> authorList) {
        int numberOfAuthors;

        numberOfAuthors = authorList.size();
        System.out.println("Die Anzahl der Autoren lautet : " + numberOfAuthors);
    }

    public static void findWinner(ArrayList<Ticket> ticketList) {
        Ticket winner;

        winner = Ticket.raffleTickets(ticketList);
        System.out.println(winner.getName() + " " + winner.getSurname() + " gewinnt " + winner.getNumberOfTickets() + " Tickets.");
    }


    public static ArrayList<Author> createAuthorList(ArrayList<Ticket> ticketArrayList) {
        String name;
        String surname;
        Author author;

        // Erstellen der ArrayList
        ArrayList<Author> authorArrayList = new ArrayList<Author>();

        for (Ticket ticket : ticketArrayList) {
            author = new Author(ticket.getName(), ticket.getSurname());
            authorArrayList.add(author);
        }

        return authorArrayList;
    }

    public static ArrayList<Ticket> createTicketList() throws FileNotFoundException {
        String name;
        String surname;
        Ticket ticket;

        // Erstellen der ArrayList
        ArrayList<Ticket> ticketArrayList = new ArrayList<Ticket>();

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
                //System.out.println("tickets: " + authorName.length);

                ticket = new Ticket(name, surname, authorName.length);

                // Einfuegen des Ticket-Objekts in die Liste
                ticketArrayList.add(ticket);
            }
        }

        scanner.close();

        return ticketArrayList;
    }
}