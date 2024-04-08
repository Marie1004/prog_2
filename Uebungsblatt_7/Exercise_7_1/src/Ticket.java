import java.util.ArrayList;
import java.util.Random;

public class Ticket extends Author {
    int numberOfTickets;
    public Ticket(String name, String surname, int numberOfTickets) {
        super(name, surname);
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    // Ermitteln der Tickets, die verlost werden
    public static Ticket raffleTickets(ArrayList<Ticket> ticketArrayList) {
        Random r;
        int low;
        int high;
        int winnerNumber;
        Ticket winner;

        // Es wird zufällig ein Gewinner ausgewählt
        r = new Random();
        low = 0;
        high = ticketArrayList.size();
        winnerNumber = r.nextInt(high-low) + low;

        winner = new Ticket(ticketArrayList.get(winnerNumber).getName(), ticketArrayList.get(winnerNumber).getSurname(), ticketArrayList.get(winnerNumber).getNumberOfTickets());

        return winner;
    }
}
