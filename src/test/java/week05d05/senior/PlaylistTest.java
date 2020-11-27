package week05d05.senior;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    Playlist pl = new Playlist(new ArrayList<>());

    @Test
    void createPlaylistSample() {
        pl.addSong(new Song("Cry Baby",238, "Janis Joplin"));
        pl.addSong(new Song("Don't cry", 314,"Guns'N'Roses"));
        assertEquals("Janis Joplin - Cry Baby (3:58)\nGuns'N'Roses - Don't cry (5:14)\n", pl.toString());

        assertEquals("[Guns'N'Roses - Don't cry (5:14)]", pl.findByLengthGreaterThan(5).toString());
    }


}