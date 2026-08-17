package library.main;
import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.LibraryService;
public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = new LibraryResource[5];
        resources[0] = new Book(1, "Java Programming", "James Gosling");
        resources[1] = new Book(2, "Data Structures", "Mark Allen Weiss");
        resources[2] = new Book(3, "Operating Systems", "Abraham Silberschatz");
        resources[3] = new DigitalResource(4, "Cloud Computing Basics", "John Smith");
        resources[4] = new DigitalResource(5, "Machine Learning Intro", "Andrew Ng");
        int[] overdueDays = {3, 0, 7, 5, 2};
        System.out.println("Library: " + LibraryResource.libraryName);
        System.out.println();
        LibraryService service = new LibraryService();
        System.out.println("All Library Resources:");
        for (int i = 0; i < resources.length; i++) {
            service.displayResource(resources[i]);
        }
        System.out.println();
        System.out.println("Fine Details:");
        double totalFine = 0;
        for (int i = 0; i < resources.length; i++) {
            double fine = service.getFine(resources[i], overdueDays[i]);
            if (overdueDays[i] > 0) {
                System.out.println(resources[i].getTitle() + " -> Overdue Days: " + overdueDays[i] + ", Fine: Rs. " + fine);
                totalFine = totalFine + fine;
            } else {
                System.out.println(resources[i].getTitle() + " -> No overdue");
            }
        }
        System.out.println();
        System.out.println("Total Fine of All Overdue Resources: Rs. " + totalFine);
        System.out.println();
        LibraryResource.displayTotalResources();
    }
}
