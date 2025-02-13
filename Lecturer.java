package BookingApp;

public class Lecturer {

    private int id, contact;
    private String fullName, email;

    public Lecturer(int lecturerId, String lecturerFullName, int lecturerContact, String lecturerMail) {
        id = lecturerId;
        fullName = lecturerFullName;
        contact = lecturerContact;
        email = lecturerMail;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public int getContact() { return contact; }
    public String getMail() { return email; }

    public void setNumber(int id) { this.id = id;}
    public void setName(String fullName) { this.fullName = fullName;}
    public void setContact(int con) { contact = con;}
    public void setMail(String mail) { email = mail;}

    public String toString() {
        return String.format(
                "Lecturer ID: %d, Full Name: %s, Contact: %d, Address: %s",
                id, fullName, contact, email
        );
    }

    public static Lecturer findBYId(int id) {
        Lecturer l = null;
        for(Lecturer c : ClassroomBookingApp.lecturers) {
            if(c.getId() == id) {
                l = c;
                break;
            }
        }
        return l;
    }
}
