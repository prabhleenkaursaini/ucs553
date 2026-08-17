package library.service;
import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;
public class LibraryService {
    public void displayResource(LibraryResource resource) {
        if (!InputValidator.validateResourceId(resource.getResourceId())) {
            System.out.println("Invalid resource ID: " + resource.getResourceId());
            return;
        }
        if (resource instanceof Printable) {
            ((Printable) resource).printDetails();
        }
    }
    public double getFine(LibraryResource resource, int overdueDays) {
        if (!InputValidator.validateFineDays(overdueDays)) {
            System.out.println("Invalid overdue days for resource: " + resource.getTitle());
            return 0;
        }
        return resource.calculateFine(overdueDays);
    }
}
