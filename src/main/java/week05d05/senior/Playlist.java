package week05d05.senior;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final List<Song> songs;

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        int secs = mins * 60;
        List<Song> lengthGreaterThan = new ArrayList<>();

        for (Song song : songs) {
            if (song.getLengthInSeconds() > secs) {
                lengthGreaterThan.add(song);
            }
        }

        return lengthGreaterThan;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public String
    toString() {
        StringBuilder sb = new StringBuilder();

        for (Song song : songs) {
            sb.append(song).append("\n");
        }

        return sb.toString();
    }
}
