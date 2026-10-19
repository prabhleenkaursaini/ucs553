import java.util.HashMap;
import java.util.HashSet;
public class CourseRegistrationPortal {
    private HashMap<String, Course> courses;
    private HashMap<String, HashSet<String>> studentCompletedCourses;
    public CourseRegistrationPortal() {
        courses = new HashMap<>();
        studentCompletedCourses = new HashMap<>();
    }
    public void addCourse(String courseCode, String courseName, int capacity) {
        Course course = new Course(courseCode, courseName, capacity);
        courses.put(courseCode, course);
        System.out.println("Added course: " + courseCode + " - " + courseName + " with capacity " + capacity);
    }
    public void addPrerequisite(String courseCode, String prereqCode) {
        Course course = courses.get(courseCode);
        if (course != null) {
            course.addPrerequisite(prereqCode);
            System.out.println("Added prerequisite " + prereqCode + " to " + courseCode);
        } else {
            System.out.println("Course " + courseCode + " not found.");
        }
    }
    public void addCompletedCourse(String studentId, String courseCode) {
        if (!studentCompletedCourses.containsKey(studentId)) {
            studentCompletedCourses.put(studentId, new HashSet<>());
        }
        studentCompletedCourses.get(studentId).add(courseCode);
        System.out.println("Recorded completed course " + courseCode + " for student " + studentId);
    }
    public boolean registerCourse(String studentId, String courseCode) {
        System.out.println("Attempting registration: Student " + studentId + " -> " + courseCode);
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Error: Course " + courseCode + " does not exist.");
            return false;
        }
        if (course.getEnrolledStudents().contains(studentId)) {
            System.out.println("Error: Student " + studentId + " is already enrolled in " + courseCode + ".");
            return false;
        }
        if (course.getWaitlist().contains(studentId)) {
            System.out.println("Error: Student " + studentId + " is already in the waitlist for " + courseCode + ".");
            return false;
        }
        HashSet<String> completed = studentCompletedCourses.get(studentId);
        for (int i = 0; i < course.getPrerequisites().size(); i++) {
            String prereq = course.getPrerequisites().get(i);
            if (completed == null || !completed.contains(prereq)) {
                System.out.println("Registration failed: Student " + studentId + " has not completed prerequisite " + prereq + ".");
                return false;
            }
        }
        if (course.getEnrolledStudents().size() < course.getCapacity()) {
            course.getEnrolledStudents().add(studentId);
            System.out.println("Success: Student " + studentId + " enrolled in " + courseCode + ".");
            return true;
        } else {
            course.getWaitlist().add(studentId);
            System.out.println("Course " + courseCode + " is full. Student " + studentId + " placed on waitlist (Position: " + course.getWaitlist().size() + ").");
            return false;
        }
    }
    public boolean dropCourse(String studentId, String courseCode) {
        System.out.println("Attempting drop: Student " + studentId + " -> " + courseCode);
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Error: Course " + courseCode + " does not exist.");
            return false;
        }
        if (course.getEnrolledStudents().contains(studentId)) {
            course.getEnrolledStudents().remove(studentId);
            System.out.println("Success: Student " + studentId + " dropped " + courseCode + ".");
            if (!course.getWaitlist().isEmpty()) {
                String promotedStudent = course.getWaitlist().poll();
                course.getEnrolledStudents().add(promotedStudent);
                System.out.println("Automated Waitlist Promotion: Student " + promotedStudent + " promoted from waitlist to enrolled in " + courseCode + ".");
            }
            return true;
        } else if (course.getWaitlist().contains(studentId)) {
            course.getWaitlist().remove(studentId);
            System.out.println("Success: Student " + studentId + " removed from waitlist for " + courseCode + ".");
            return true;
        } else {
            System.out.println("Error: Student " + studentId + " is neither enrolled nor waitlisted in " + courseCode + ".");
            return false;
        }
    }
    public void displayCourse(String courseCode) {
        Course course = courses.get(courseCode);
        if (course != null) {
            course.displayCourseDetails();
        } else {
            System.out.println("Course " + courseCode + " not found.");
        }
    }
    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();
        System.out.println("===== Setting Up Courses =====");
        portal.addCourse("CS101", "Introduction to Programming", 2);
        portal.addCourse("CS201", "Data Structures and Algorithms", 2);
        portal.addPrerequisite("CS201", "CS101");
        System.out.println("===== Adding Completed Prerequisites =====");
        portal.addCompletedCourse("S101", "CS101");
        portal.addCompletedCourse("S102", "CS101");
        portal.addCompletedCourse("S104", "CS101");
        System.out.println("===== Testing Registration with Prerequisites =====");
        portal.registerCourse("S103", "CS201");
        portal.registerCourse("S101", "CS201");
        portal.registerCourse("S102", "CS201");
        System.out.println("===== Testing Capacity and Waitlist Queue =====");
        portal.registerCourse("S104", "CS201");
        portal.registerCourse("S105", "CS101");
        portal.registerCourse("S106", "CS101");
        portal.registerCourse("S107", "CS101");
        System.out.println("===== Course Status Before Drop =====");
        portal.displayCourse("CS201");
        portal.displayCourse("CS101");
        System.out.println("===== Testing Automated Waitlist Promotion =====");
        portal.dropCourse("S101", "CS201");
        System.out.println("===== Course Status After Drop and Promotion =====");
        portal.displayCourse("CS201");
    }
}
