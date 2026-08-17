package library.model;
public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;
    public static String libraryName = "City Central Library";
    private static int resourceCount = 0;
    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        resourceCount++;
    }
    public abstract double calculateFine(int overdueDays);
    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public static int getResourceCount() {
        return resourceCount;
    }
    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + resourceCount);
    }
}
