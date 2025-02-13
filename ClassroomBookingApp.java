import java.util.ArrayList;
import java.util.Scanner;

public class ClassroomBookingApp {

    public static Scanner input = new Scanner(System.in);
    public static Scanner inputone = new Scanner(System.in);
    public static ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
    public static ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();

    public static void main(String[] args) {

        //display welcome the user.
        System.out.println("Welcome to the Classroom Booking Application");

        //Start the application loop.
        while (true) {
            handleMainMenuInput();
        }
    }

    public static void handleMainMenuInput() {
        System.out.println();
        System.out.println("*** Main Menu ***");
        System.out.println("1. Manage Classrooms");
        System.out.println("2. Manage Lecturers");
        System.out.println("3. Manage Bookings");
        System.out.println("4. Generate Reports");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        String option = input.nextLine();

        //Process the option.
        switch (option.trim()) {
            case "1":
                manageClassrooms();
                break;
            case "2":
                manageLecturers();
                break;
            case "3":
                manageBookings();
                break;
            case "4":
                generateReports();
                break;
            case "0":
                System.out.print("Thank you for using the Classroom Booking Application!");
                System.exit(0);
            default:
                System.out.println();
                System.out.println("Invalid option. ");
                break;
        }
    }

    public static int getNextInt(String error) {
        int next = -1;
        try {
            next = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(error);

        }
        return next;
    }

    public static int getNextInt() {
        return getNextInt("Invalid input! Integer required.");
    }

    public static void manageClassrooms() {
        System.out.println();
        System.out.println("** Classroom Menu **");
        System.out.println("1. create classroom");
        System.out.println("2. Update classroom");
        System.out.println("3. Delete classroom");
        System.out.println("4. View all classrooms");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter option: ");

        String option = input.nextLine();
        //Process classroom input
        switch (option.trim()) {
            case "1":
                System.out.println();
                System.out.print("Enter classroom number: ");
//                try {
//                    int classNum = Integer.parseInt(input.nextLine());
//                } catch(NumberFormatException e) {
//                    System.out.println("Invalid input. Classroom number is an integer.");
//                    break;
//                }

                int classNum = input.nextInt();
                input.nextLine();

                //find the class number in array list
                Classroom classToCreate = null;
                for (Classroom c : classrooms) {
                    if (c.getNumber() == classNum) {
                        classToCreate = c;
                        break;
                    }
                }

                if (classToCreate == null) {
                    System.out.print("Enter classroom name: ");
                    String className = input.nextLine();
                    System.out.print("Enter classroom location: ");
                    String classLoc = input.nextLine();

                    // Create and save the classroom.
                    classrooms.add(new Classroom(classNum, className, classLoc));
                    System.out.print("New classroom created!");
                    System.out.println();
                } else {
                    System.out.printf("Error: Classroom number '%d' already exists!", classNum);
                    System.out.println();
                }


                manageClassrooms();
                break;

            case "2":
                System.out.println();
                System.out.print("Enter classroom number: ");
                int num = getNextInt();

                //Find the class number in the array list.
                Classroom classToUpdate = null;
                for (Classroom c : classrooms) {
                    if (c.getNumber() == num) {
                        classToUpdate = c;
                        break;
                    }
                }

                if (classToUpdate != null) {
                    System.out.print("Enter new classroom name: ");
                    classToUpdate.setName(inputone.nextLine());
                    System.out.print("Enter new classroom location: ");
                    classToUpdate.setLocation(input.nextLine());
                    System.out.println("Classroom '" + num + "' updated!");
                } else {
                    System.out.println("Error: Invalid classroom number!");
                }


                manageClassrooms();
                break;

            case "3":
                System.out.println();
                System.out.print("Enter classroom number: ");
                int n = getNextInt();

                //Find the class number in the array list.
                Classroom classToRemove = null;
                for (Classroom c : classrooms) {
                    if (c.getNumber() == n) {
                        classToRemove = c;
                        break;
                    }
                }
                // Remove the class or print an error message.
                if (classToRemove != null) {
                    classrooms.remove(classToRemove);
                    System.out.printf("Classroom '%d' deleted!%n", n);
                } else {
                    System.out.println("Error: Classroom number '" + n + "' does not exist!");
                }

                manageClassrooms();
                break;

            case "4":

                // Print out the all classrooms.
                System.out.println();
                for (Classroom c : classrooms) {
                    System.out.println(c);
                }
                manageClassrooms();
                break;

            case "5":
                return;

            default:
                System.out.println("Error: Invalid input.");
                manageClassrooms(); //collect input again.
                break;

        }
    }

    public static void manageLecturers() {
        System.out.println();
        System.out.println("** Lecturer Menu **");
        System.out.println("1. Add lecturer");
        System.out.println("2. Edit lecturer");
        System.out.println("3. Remove lecturer");
        System.out.println("4. View all lecturers");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter option: ");

        String option = input.nextLine();
        switch (option.trim()) {
            case "1":
                System.out.println();
                System.out.print("Enter lecturer ID: ");
                int lecturerId = input.nextInt();
                input.nextLine();
                System.out.print("Enter lecturer full name: ");
                String lecturerFullName = input.nextLine();
                System.out.print("Enter lecturer contact: ");
                int lecturerContact = input.nextInt();
                input.nextLine();
                System.out.print("Enter lecturer email: ");
                String lecturerMail = input.nextLine();

                // Create and save the lecturer.
                lecturers.add(new Lecturer(lecturerId, lecturerFullName, lecturerContact, lecturerMail));
                System.out.println("New lecturer added!");

                manageLecturers();
                break;

            case "2":
                System.out.println();
                System.out.print("Enter lecturer ID to edit: ");
                int id = getNextInt();

                //Find the class number in the array list.
                Lecturer lecturerToUpdate = null;
                for (Lecturer l : lecturers) {
                    if (l.getId() == id) {
                        lecturerToUpdate = l;
                        break;
                    }
                }

                if (lecturerToUpdate != null) {
                    System.out.print("Enter new lecturer full name: ");
                    //String setName = input.nextLine();
                    lecturerToUpdate.setName(inputone.nextLine());
                    System.out.print("Enter new lecturer contact: ");
                    lecturerToUpdate.setContact(input.nextInt());
                    input.nextLine();
                    System.out.print("Enter new lecturer email: ");
                    lecturerToUpdate.setMail(input.nextLine());
                    System.out.printf("Lecturer '%d' edited!", id);
                    System.out.println();
                } else {
                    System.out.println("Error: Invalid lecturer ID!");
                }
                manageLecturers();
                break;

            case "3":
                System.out.println();
                System.out.print("Enter lecturer ID to remove: ");
                int i = getNextInt();

                //Find the class number in the array list.
                Lecturer lecturerToRemove = null;
                for (Lecturer l : lecturers) {
                    if (l.getId() == i) {
                        lecturerToRemove = l;
                        break;
                    }
                }
                // Remove the class or print an error message.
                if (lecturerToRemove != null) {
                    lecturers.remove(lecturerToRemove);
                    System.out.printf("Lecturer '%d' removed!", i);
                    System.out.println();
                } else {
                    System.out.printf("Error: Lecturer '%d' does not exist!", i);
                    System.out.println();
                }

                manageLecturers();
                break;

            case "4":

                // Print out the all classrooms.
                System.out.println();
                for (Lecturer c : lecturers) {
                    System.out.println(c);
                }

                manageLecturers();
                break;

            case "5":
                return;

            default:
                System.out.println("Error: Invalid input.");
                manageLecturers();
                break;
        }
    }

    public static void manageBookings() {
        System.out.println();
        System.out.println("** Booking Menu **");
        System.out.println("1. Make a booking");
        System.out.println("2. Cancel a booking");
        System.out.println("3. View all bookings");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter option: ");

        String option = input.nextLine();
        switch(option.trim()) {
            case "1":

                System.out.println();
                System.out.print("Enter booking date (dd/mm/yyyy): ");
                String date = input.nextLine();

                //Find am empty classroom
                Classroom c = Booking.findEmptyClassroom(date);
                if(c == null) {
                    System.out.printf("Error: No available classroom on '%s'!", date);
                    System.out.println();
                    manageBookings();
                    break;
                }

                //Check if the date is valid.
                String[] dateComponents = date.split("/");
                if(dateComponents.length != 3) {
                    System.out.println("Error: Date format is invalid.");
                    manageBookings();
                }

                //Check if the value in the date are valid.
                try {
                    int d = Integer.parseInt(dateComponents[0]);
                    int m = Integer.parseInt(dateComponents[1]);
                    int y = Integer.parseInt(dateComponents[2]);
                } catch(NumberFormatException e) {
                    System.out.println("Error: Date format is invalid.");
                    manageBookings();
                } catch(IllegalArgumentException e) {
                    System.out.println("Error: Date is invalid.");
                    manageBookings();
                    break;
                }


                // Do not continue if getNextIt() fails
                // from invalid input
                System.out.print("Enter lecture ID: ");
                int id = getNextInt();
                if(id < 0) {
                    manageBookings();
                    break;
                }

                //Check if the lecturer is valid
                Lecturer l = Lecturer.findBYId(id);
                if(l == null) {
                    System.out.println("Error: Lecturer not found");
                    System.out.println();
                    manageBookings();
                    break;
                }

                //Create and save the classroom
                Booking newBooking = new Booking(date, l, c);
                bookings.add( newBooking);
                System.out.printf("Classroom '%d' booked, booking ID is %d%n" +
                                  "Your lecture name is '%s'%n", c.getNumber(), newBooking.getId(), l.getFullName());

                manageBookings();
                break;



            case "2":
                System.out.println();
                System.out.print("Enter booking ID: ");
                int bookingId = input.nextInt();
                input.nextLine();

                //Find the booking Id in array list
                Booking bookingToRemove = null;
                for(Booking b : bookings) {
                    if(b.getId() == bookingId) {
                        bookingToRemove = b;
                        break;
                    }
                }

                if(bookingToRemove != null) {
                    bookings.remove(bookingToRemove);

                    //Subtract 40000 from booking Id.
                    int displayId = bookingId - 40000;

                    // Remove the booking or print error message.
                    System.out.printf("Booking '%d' canceled!", displayId);
                    System.out.println();
                } else {
                    System.out.printf("Error: Booking '%d' does not exist!", bookingId);
                    System.out.println();
                }

                manageBookings();
                break;

            case "3":
                System.out.println();
                for(Booking b : bookings) {
                    System.out.println(b);
                }

                manageBookings();
                break;

            case "4":
                return;

            default:
                System.out.println("Error: Invalid input.");
                manageBookings();
                break;

        }
    }

    public static void generateReports(){
        System.out.println();
        System.out.println("*Reports Menu*");
        System.out.println("1. Generate bookings report by date");
        System.out.println("2. Generate bookings report by classroom");
        System.out.println("3. Generate bookings report by lecturer");
        System.out.println("4. Generate total number of booking");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter Option: ");

        String option = input.nextLine();

        switch (option.trim()){
            case "1":
                System.out.println();
                System.out.print("Enter date (dd/mm/yyyy): ");
                String date = input.nextLine();
                for(Booking b : bookings) {
                    if(b.getDate().equals(date)) {
                        System.out.println("Booking ID: " + b.getId() + ", Classroom number: " + b.getClassroom().getNumber() + ", Lecturer ID: " + b.getLecturer().getId());
                    }
                }
                generateReports();
                break;

            case "2":
                System.out.println();
                System.out.print("Enter classroom number: ");
                int classroomNumber = input.nextInt();
                input.nextLine();
                for(Booking b : bookings) {
                    if(b.getClassroom().getNumber() == classroomNumber) {
                        System.out.println("Booking ID: " + b.getId() + ", Date: " + b.getDate() + ", Lecturer ID: " + b.getLecturer().getId());
                    }
                }
                generateReports();
                break;

            case "3":
                System.out.println();
                System.out.print("Enter lecturer ID: ");
                int lecturerID = input.nextInt();
                input.nextLine();
                for(Booking b : bookings) {
                    if(b.getLecturer().getId() == lecturerID) {
                        System.out.println("Booking ID: " + b.getId() + ", Date: " + b.getDate() + ", Classroom number: " + b.getClassroom().getNumber());
                    }
                }
                generateReports();
                break;

            case "4":
                System.out.println();
                System.out.println("Total number of bookings: " + bookings.size());
                generateReports();
                break;

            case "5":
                return;

            default:
                System.out.println("Error: Invalid input.");
                generateReports();
                break;
        }
    }


}
