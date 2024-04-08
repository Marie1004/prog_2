import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Exercise_7_1 {
    public static void main(String[] args) throws FileNotFoundException {
        // Erstellen der Listen
        ArrayList<Ticket> teamList = new ArrayList<Ticket>();
        ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
        ArrayList<PatientReservation> patientReservationList = new ArrayList<PatientReservation>();

        teamList = createTicketList();
        hospitalList = createHospitalList();

        // Terminal-Ausgabe der Listen
        //outputOfTeamList(teamList);
        outputOfHospitalList(hospitalList);

        // Überweisung der Teams ins jeweilige Krankenhaus
        patientReservationList = bringAuthorTeamToHospital(teamList , hospitalList);
    }

    private static ArrayList<PatientReservation> bringAuthorTeamToHospital(ArrayList<Ticket> teamList , ArrayList<Hospital> hospitalList) {
        String name;
        String surname;
        int teamsize;
        boolean foundHospital;
        int counter;
        int reservedRooms;
        int freeRooms;
        PatientReservation patientReservation;

        // Erstellen der ArrayList
        ArrayList<PatientReservation> patientReservationArrayList = new ArrayList<PatientReservation>();

        for(Ticket t: teamList) {
            name = t.getName();
            surname = t.getSurname();
            teamsize = t.getTeamsize();

            // Parameter (zurueck)setzen
            counter = 0;
            foundHospital = false;
            while(!foundHospital) {
                //System.out.println("counter: " + counter);
                reservedRooms = hospitalList.get(counter).getNumberOfReservedRooms();
                freeRooms = hospitalList.get(counter).getNumberOfRooms() - reservedRooms;
                //System.out.println("freeRooms: " + freeRooms);
                if(teamsize < freeRooms) {
                    foundHospital = true;
                    hospitalList.get(counter).setNumberOfReservedRooms(reservedRooms + teamsize);
                    patientReservation = new PatientReservation(name , surname , teamsize , hospitalList.get(counter).getName());
                    System.out.println("Reservation at "
                            + patientReservation.getHospital()
                            + " for " + patientReservation.getName()
                            + " " + patientReservation.getSurname()
                            + "(number of patients " + patientReservation.getTeamsize() + ")"
                    );

                    // Einfuegen des Ticket-Objekts in die Liste
                    patientReservationArrayList.add(patientReservation);
                } else {
                    counter ++;
                }
            }
        }

        return patientReservationArrayList;
    }

    private static void outputOfTeamList(ArrayList<Ticket> teamList) {
        for(Ticket t: teamList) {
            System.out.println("Name: " + t.getName());
            System.out.println("Surname: " + t.getSurname());
            System.out.println("Teamsize: " + t.getTeamsize() + "\n\n");
        }
    }

    private static void outputOfHospitalList(ArrayList<Hospital> hospitalList) {
        for(Hospital h: hospitalList) {
            //System.out.println("Name: " + h.getName());
            //System.out.println("Number of rooms: " + h.getNumberOfRooms());
            //System.out.println("Number of reservated Rooms: " + h.getNumberOfReservedRooms());
        }
    }

    private static ArrayList<Ticket> createTicketList() throws FileNotFoundException {
        String name;
        String surname;
        Ticket ticket;

        // Erstellen der ArrayList
        ArrayList<Ticket> ticketArrayList = new ArrayList<Ticket>();

        // Verweis auf die Datei
        File file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_7/Exercise_7_1/inc/nutrition_publications.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();

        // Auslesen aus der Datei
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Zerlegen des Strings in Teilstrings
            String[] values = line.split(";");
            //System.out.println("String mit allen Autoren: " + values[1]);
            String authors = values[1];
            String[] authorName = authors.split(", ");

            // Namen des "Teamleisters"
            String[] authorNamePart = authorName[0].split(" ");
            name = authorNamePart[0];
            for(int j = 1; j < (authorNamePart.length - 1); j++) {
                name = name.concat(" " + authorNamePart[j]);
            }
            //System.out.println("name: " + name);

            surname = authorNamePart[authorNamePart.length-1];
            //System.out.println("surname: " + authorNamePart[authorNamePart.length-1]);

            // Anzahl der Teilnehmenden im Team
            //System.out.println("tickets: " + authorName.length);

            // Erstellen des Listeneintrags als Ticket-Objekt
            ticket = new Ticket(name, surname, authorName.length);

            // Einfuegen des Ticket-Objekts in die Liste
            ticketArrayList.add(ticket);
        }

        scanner.close();

        return ticketArrayList;
    }

    private static ArrayList<Hospital> createHospitalList() throws FileNotFoundException {
        Hospital hospital;

        // Erstellen der ArrayList
        ArrayList<Hospital> hospitalArrayList = new ArrayList<Hospital>();

        // Verweis auf die Datei
        File file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_7/Exercise_7_1/inc/hospitals.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();

        // Auslesen aus der Datei
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Zerlegen des Strings in Teilstrings
            String[] values = line.split(",");

            hospital = new Hospital(values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
            //System.out.println("Name: " + hospital.getName());
            //System.out.println("Number of rooms: " + hospital.getNumberOfRooms());
            //System.out.println("Number of reservated rooms: " + hospital.getNumberOfReservedRooms());

            // Einfuegen des Krankenhaus-Objekts in die Liste
            hospitalArrayList.add(hospital);
        }

        return hospitalArrayList;
    }
}