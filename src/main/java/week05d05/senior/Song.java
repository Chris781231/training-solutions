package week05d05.senior;

public class Song {

    private final String name;
    private final long lengthInSeconds;
    private final String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name) || isEmpty(artist) || lengthInSeconds <= 0) {
            throw new IllegalArgumentException("Invalid parameter(s): " + name + lengthInSeconds + artist);
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", artist, name, getLength());
    }

    private String getLength() {
        return String.format("%d:%d", lengthInSeconds / 60, lengthInSeconds % 60);
    }
}
