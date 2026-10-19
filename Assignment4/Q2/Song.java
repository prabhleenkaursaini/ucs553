public class Song {
    private String title;
    private String artist;
    private double duration;
    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public double getDuration() {
        return duration;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Song other = (Song) obj;
        return title.equalsIgnoreCase(other.title) && artist.equalsIgnoreCase(other.artist);
    }
    @Override
    public int hashCode() {
        return title.toLowerCase().hashCode() + artist.toLowerCase().hashCode();
    }
    @Override
    public String toString() {
        return title + " - " + artist + " (" + duration + " mins)";
    }
}
