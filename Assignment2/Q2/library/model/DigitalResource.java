package library.model;
public class DigitalResource extends LibraryResource implements Printable {
    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
    @Override
    public void printDetails() {
        System.out.println("--------------------------------------------------");
        System.out.println("Type       : Digital Resource");
        System.out.println("Resource ID: " + getResourceId());
        System.out.println("Title      : " + getTitle());
        System.out.println("Author     : " + getAuthor());
        System.out.println("--------------------------------------------------");
    }
}
