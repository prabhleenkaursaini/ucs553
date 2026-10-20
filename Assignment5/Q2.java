import java.util.Optional;
public class Q2 {
    public static void main(String[] args) {
        Optional<String> studentEmail = Optional.of("student@example.com");
        Optional<String> emptyEmail = Optional.empty();
        studentEmail.ifPresent(email -> System.out.println("Email: " + email));
        String defaultEmail = emptyEmail.orElse("default@example.com");
        System.out.println("Default email: " + defaultEmail);
        try {
            String missingEmail = emptyEmail.orElseThrow(() -> new RuntimeException("Email is missing"));
            System.out.println("Email: " + missingEmail);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}