package BookingApp;

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


//package BookingApp;
//
//
//public class Booking {
//    private int bookingId;
//    private String date;
//    private int lecturerId;
//    private Classroom classroom;
//    private Lecturer lecturer;
//
//
//    public Booking (int bookingId, String date, int lecturerId, Classroom classroom, Lecturer lecturer) {
//        this.bookingId = bookingId;
//        this.date = date;
//        this.lecturerId = lecturerId;
//        this.classroom = classroom;
//        this.lecturer = lecturer;
//    }
//
//    public int getBookingId() { return bookingId;}
//    public String getDate() { return date;}
//    public int getLecturerId() { return lecturerId;}
//    public Lecturer getLecturer() { return lecturer;}
//    public Classroom getClassroom() { return classroom;}
//
//    public void setBookingId(int bookingId) { this.bookingId = bookingId;}
//    public void setDate(String date) { this.date = date;}
//    public void setLecturerId(int lecturerId) { this.lecturerId = lecturerId;}
//    public void setClassroom(Classroom classroom) { this.classroom = classroom;}
//    public void setLecturer(Lecturer lecturer) { this.lecturer = lecturer;}
//
//
//    public String toString() {
//        return "Booking ID: " + bookingId + ", Date: " + date + ", Lecturer ID: " + lecturer.getId() + ", Classroom: " + classroom.getNumber();
//    }
//
//    public static Classroom findEmptyClassroom(String date) {
//        //Check if classroom is already booked.
//        for(Classroom c : ClassroomBookingApp.classrooms) {
//            //If there are no bookings, we can immediately return classroom.
//            if(ClassroomBookingApp.bookings.size() <= 0) {
//                return c;
//            }
//
//            //Check if the classroom is already booked.
//            for(Booking b : ClassroomBookingApp.bookings) {
//                if(b.getClassroom() == c) {
//                    if(b.getDate().equals(date)) {
//                        // Stop checking if we find a matching booking.
//                        break;
//                    }
//                }
//
//                // Code only gets here if we find an empty classroom.
//                return c;
//            }
//        }
//        return null;
//    }
//
//
//}


//Check if classroom is already booked.
//        for(Classroom c : ClassroomBookingApp.classrooms) {
//            //If there are no bookings, we can immediately return classroom.
//            if(ClassroomBookingApp.bookings.size() <= 0) {
//                return c;
//            }
//
//            //Check if the classroom is already booked.
//            for(Booking b : ClassroomBookingApp.bookings) {
//                if(b.getClassroom() == c) {
//                    if(b.getDate().equals(date)) {
//                        // Stop checking if we find a matching booking.
//                        break;
//                    }
//                }
//
//                // Code only gets here if we find an empty classroom.
//                return c;
//            }
//        }
//        return null;