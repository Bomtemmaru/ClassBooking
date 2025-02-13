public class Classroom {

    private int number;
    private String name, location;

    public Classroom(int classNum, String className, String classLoc) {
        number = classNum;
        name = className;
        location = classLoc;
    }

    public int getNumber() { return number; }
    public String getName() { return name; }
    public String getLocation() { return location; }

    public void setNumber(int num) { number = num;}
    public void setName(String name) { this.name = name;}
    public void setLocation(String loc) { location = loc;}


    public String toString() {
        return String.format(
                "Classroom Number: %d, Name: %s, Location: %s",
                number, name, location
        );
    }

}
