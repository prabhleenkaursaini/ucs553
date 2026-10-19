import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
public class Course {
    private String courseCode;
    private String courseName;
    private int capacity;
    private HashSet<String> enrolledStudents;
    private ArrayList<String> prerequisites;
    private LinkedList<String> waitlist;
    public Course(String courseCode, String courseName, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new HashSet<>();
        this.prerequisites = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCapacity() {
        return capacity;
    }
    public HashSet<String> getEnrolledStudents() {
        return enrolledStudents;
    }
    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }
    public LinkedList<String> getWaitlist() {
        return waitlist;
    }
    public void addPrerequisite(String prereqCode) {
        prerequisites.add(prereqCode);
    }
    public void displayCourseDetails() {
        System.out.println("--------------------------------------------------");
        System.out.println("Course Code       : " + courseCode);
        System.out.println("Course Name       : " + courseName);
        System.out.println("Capacity          : " + enrolledStudents.size() + "/" + capacity);
        System.out.println("Prerequisites     : " + prerequisites);
        System.out.println("Enrolled Students : " + enrolledStudents);
        System.out.println("Waitlist Queue    : " + waitlist);
        System.out.println("--------------------------------------------------");
    }
}
