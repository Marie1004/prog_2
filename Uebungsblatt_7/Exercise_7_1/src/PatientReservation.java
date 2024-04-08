public class PatientReservation extends Ticket{
    private String hospital;

    public PatientReservation(String name , String surname , int teamsize , String hospital) {
        super(name , surname , teamsize);
        this.hospital = hospital;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public int getTeamsize() {
        return super.getTeamsize();
    }

    public String getHospital() {
        return hospital;
    }
}
