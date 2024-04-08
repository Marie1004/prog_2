public class Hospital {
    private String name;

    private int numberOfRooms;

    private int numberOfReservedRooms;

    public Hospital(String name, int numberOfRooms , int numberOfReservedRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfReservedRooms = numberOfReservedRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfReservedRooms() {
        return numberOfReservedRooms;
    }

    public void setNumberOfReservedRooms(int numberOfReservedRooms) {
        this.numberOfReservedRooms = numberOfReservedRooms;
    }
}
