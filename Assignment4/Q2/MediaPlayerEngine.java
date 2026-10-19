import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
public class MediaPlayerEngine {
    private LinkedList<Song> playlist;
    private LinkedList<Song> history;
    private ListIterator<Song> navIterator;
    private boolean movingForward;
    public MediaPlayerEngine() {
        playlist = new LinkedList<>();
        history = new LinkedList<>();
        navIterator = null;
        movingForward = true;
    }
    public void addSong(Song song) {
        playlist.addLast(song);
        navIterator = null;
        System.out.println("Added: " + song);
    }
    public void addToFront(Song song) {
        playlist.addFirst(song);
        navIterator = null;
        System.out.println("Priority added to front: " + song);
    }
    public void insertAtPosition(int position, Song song) {
        if (position < 0 || position > playlist.size()) {
            System.out.println("Invalid position: " + position);
            return;
        }
        ListIterator<Song> iterator = playlist.listIterator(position);
        iterator.add(song);
        navIterator = null;
        System.out.println("Inserted at position " + position + ": " + song);
    }
    public void removeDuplicates() {
        System.out.println("Removing duplicate songs...");
        HashSet<Song> seen = new HashSet<>();
        ListIterator<Song> iterator = playlist.listIterator();
        int count = 0;
        while (iterator.hasNext()) {
            Song current = iterator.next();
            if (seen.contains(current)) {
                iterator.remove();
                count++;
                System.out.println("Removed duplicate: " + current);
            } else {
                seen.add(current);
            }
        }
        navIterator = null;
        System.out.println("Duplicate cleanup finished. Total removed: " + count);
    }
    private void recordHistory(Song song) {
        history.addFirst(song);
        if (history.size() > 5) {
            history.removeLast();
        }
    }
    public void playNext() {
        if (navIterator == null) {
            navIterator = playlist.listIterator();
            movingForward = true;
        }
        if (!movingForward) {
            if (navIterator.hasNext()) {
                navIterator.next();
            }
            movingForward = true;
        }
        if (navIterator.hasNext()) {
            Song current = navIterator.next();
            recordHistory(current);
            System.out.println("Playing Next: " + current);
        } else {
            System.out.println("Reached the end of the playlist.");
        }
    }
    public void playPrevious() {
        if (navIterator == null) {
            navIterator = playlist.listIterator(playlist.size());
            movingForward = false;
        }
        if (movingForward) {
            if (navIterator.hasPrevious()) {
                navIterator.previous();
            }
            movingForward = false;
        }
        if (navIterator.hasPrevious()) {
            Song current = navIterator.previous();
            recordHistory(current);
            System.out.println("Playing Previous: " + current);
        } else {
            System.out.println("Reached the beginning of the playlist.");
        }
    }
    public void traverseForward() {
        System.out.println("--- Traversing Playlist Forward ---");
        ListIterator<Song> iterator = playlist.listIterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println(count + ". " + iterator.next());
            count++;
        }
    }
    public void traverseBackward() {
        System.out.println("--- Traversing Playlist Backward ---");
        ListIterator<Song> iterator = playlist.listIterator(playlist.size());
        int count = playlist.size();
        while (iterator.hasPrevious()) {
            System.out.println(count + ". " + iterator.previous());
            count--;
        }
    }
    public void displayHistory() {
        System.out.println("--- Recent Playback History ---");
        if (history.isEmpty()) {
            System.out.println("No songs in history.");
            return;
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }
    public static void main(String[] args) {
        MediaPlayerEngine engine = new MediaPlayerEngine();
        System.out.println("===== Adding Songs to Queue =====");
        engine.addSong(new Song("Shape of You", "Ed Sheeran", 3.53));
        engine.addSong(new Song("Blinding Lights", "The Weeknd", 3.20));
        engine.addSong(new Song("Levitating", "Dua Lipa", 3.23));
        System.out.println("===== Priority Queueing (Adding to Front) =====");
        engine.addToFront(new Song("Bohemian Rhapsody", "Queen", 5.55));
        System.out.println("===== Fast Insertion at Arbitrary Position =====");
        engine.insertAtPosition(2, new Song("Hotel California", "Eagles", 6.30));
        System.out.println("===== Adding Duplicate Songs =====");
        engine.addSong(new Song("Blinding Lights", "The Weeknd", 3.20));
        engine.addSong(new Song("Shape of You", "Ed Sheeran", 3.53));
        System.out.println("===== Current Playlist Before Cleanup =====");
        engine.traverseForward();
        System.out.println("===== Removing Duplicates Efficiently =====");
        engine.removeDuplicates();
        System.out.println("===== Traversal Forward with ListIterator =====");
        engine.traverseForward();
        System.out.println("===== Traversal Backward with ListIterator =====");
        engine.traverseBackward();
        System.out.println("===== Testing Bidirectional Playback and History Tracking =====");
        engine.playNext();
        engine.playNext();
        engine.playNext();
        engine.playPrevious();
        engine.playNext();
        System.out.println("===== Displaying Recent History =====");
        engine.displayHistory();
    }
}
