package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// File: TestAlbum.java
// Author: Viswa Sushanth Karuturi
// Purpose: Unit tests for the Album class

public class TestAlbum {

    Album album = new Album("After Hours", "The Weeknd", "R&B", "2020");
    Song song1 = new Song("Blinding Lights", "The Weeknd", "After Hours");
    Song song2 = new Song("Save Your Tears", "The Weeknd", "After Hours");

    @Test
    public void testCopyConstructor() {
        album.addSong(song1);
        Album copiedAlbum = new Album(album);

        assertEquals(album.getTitle(), copiedAlbum.getTitle());
        assertEquals(album.getArtist(), copiedAlbum.getArtist());
        assertEquals(1, copiedAlbum.getSongs().size());
    }

    @Test
    public void testAddSong() {
        album.addSong(song1);
        album.addSong(song2);

        List<Song> songs = album.getSongs();
        assertEquals(2, songs.size());
        assertEquals("Blinding Lights", songs.get(0).getTitle());
        assertEquals("Save Your Tears", songs.get(1).getTitle());
    }

    @Test
    public void testGetTitle() {
        assertEquals("After Hours", album.getTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals("The Weeknd", album.getArtist());
    }

    @Test
    public void testToString() {
        String expected = "After Hours,The Weeknd,R&B,2020";
        assertEquals(expected, album.toString());
    }

    @Test
    public void testPrintSongs() {
        album.addSong(song1);
        album.addSong(song2);

        album.printSongs();
    }
}