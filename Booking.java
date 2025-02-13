public class Booking {
    private static int idCounter = 50001;
    private int id;
    private String date;
    private Lecturer lecturer;
    private Classroom classroom;


    public Booking (String date, Lecturer lecturer, Classroom classroom) { //, ArrayList<Classroom> classroom
        //this.bookingId = ID_GENERATOR.incrementAndGet();
        this.id = idCounter++;
        this.date = date;
        this.lecturer = lecturer;
        this.classroom = classroom;
    }


    public int getId() { return id;}
    public String getDate() { return date;}
    public Lecturer getLecturer() { return lecturer;}
    public Classroom getClassroom() { return classroom;}


    public static Classroom findEmptyClassroom(String date) {
        for(Classroom c : ClassroomBookingApp.classrooms) {
            boolean isBooked = false;
            for(Booking b : ClassroomBookingApp.bookings) {
                if(b.getDate().equals(date) && b.getClassroom().getNumber() == c.getNumber()) {
                    isBooked = true;
                    break;
                }
            }
            if(!isBooked) {
                return c;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Booking ID: " + id + ", Date: " + date  + ", Classroom: " + classroom.getNumber() + ", Lecturer ID: " + lecturer.getId();
    }
}


