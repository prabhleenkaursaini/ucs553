import java.util.Objects;
import java.util.Optional;
class Result<T extends Number> {
    private String studentName;
    private T marks;
    private Double totalMarks;
    public Result(String studentName, T marks, Double totalMarks) {
        this.studentName = Objects.requireNonNull(studentName, "Student name cannot be null");
        this.totalMarks = Objects.requireNonNull(totalMarks, "Total marks cannot be null");
        this.marks = marks;
    }
    public double calculatePercentage() {
        if (marks == null) {
            return 0.0;
        }
        return (marks.doubleValue() / totalMarks) * 100.0;
    }
    public boolean isPassed(double threshold) {
        return calculatePercentage() >= threshold;
    }
    public void displayResult(double threshold) {
        Optional<T> optionalMarks = Optional.ofNullable(marks);
        if (optionalMarks.isPresent()) {
            System.out.println("Student: " + studentName);
            System.out.println("Marks: " + optionalMarks.get() + " / " + totalMarks);
            System.out.println("Percentage: " + calculatePercentage() + "%");
            if (isPassed(threshold)) {
                System.out.println("Status: Passed");
            } else {
                System.out.println("Status: Failed");
            }
        } else {
            System.out.println("Marks not available for " + studentName);
        }
    }
}
public class Q3 {
    public static void main(String[] args) {
        Result<Integer> student1 = new Result<>("Rahul", 85, 100.0);
        student1.displayResult(40.0);
        Result<Double> student2 = new Result<>("Priya", 35.5, 100.0);
        student2.displayResult(40.0);
        Result<Integer> student3 = new Result<>("Aman", null, 100.0);
        student3.displayResult(40.0);
        try {
            Result<Integer> student4 = new Result<>(null, 90, 100.0);
        } catch (NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}