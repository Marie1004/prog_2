public class Ticket extends Author {
    private int teamsize;
    public Ticket(String name, String surname, int numberOfTickets) {
        super(name, surname);
        this.teamsize = numberOfTickets;
    }

    public int getTeamsize() {
        return teamsize;
    }
}
