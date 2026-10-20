import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String name = sc.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.print("Enter start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());
        System.out.print("Enter venue (press Enter to skip): ");
        String venueInput = sc.nextLine();
        Optional<String> venue = venueInput.trim().isEmpty() ? Optional.empty() : Optional.of(venueInput);
        System.out.println("--- Event Details ---");
        System.out.println("Event Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + startTime);
        System.out.println("Venue: " + venue.orElse("Venue not specified"));
        LocalDate today = LocalDate.now();
        if (date.isAfter(today)) {
            System.out.println("Event date is in the future.");
        } else if (date.isEqual(today)) {
            System.out.println("Event date is today.");
        } else {
            System.out.println("Event date is in the past.");
        }
        long daysRemaining = ChronoUnit.DAYS.between(today, date);
        System.out.println("Days remaining: " + daysRemaining);
        LocalTime endTime = startTime.plusHours(2);
        System.out.println("End Time: " + endTime);
        sc.close();
    }
}