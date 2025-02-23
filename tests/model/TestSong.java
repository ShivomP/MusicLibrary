package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestSong {
	Song song = new Song("Pork Soda", "Glass Animals", "How to Be a Human Being");

    @Test
    void testCopyConstructor() {
        song.rate("5");
        song.favoriteSong();

        Song copy = new Song(song);
        assertEquals("Pork Soda", copy.getTitle());
        assertEquals("Glass Animals", copy.getArtist());
        assertEquals("How to Be a Human Being", copy.getAlbum());
        assertEquals(Rating.FIVE, copy.getRating());
        assertTrue(copy.getFavorite());
    }

    @Test
    void testRate() {

        song.rate("1");
        assertEquals(Rating.ONE, song.getRating());

        song.rate("2");
        assertEquals(Rating.TWO, song.getRating());

        song.rate("3");
        assertEquals(Rating.THREE, song.getRating());

        song.rate("4");
        assertEquals(Rating.FOUR, song.getRating());

        song.rate("5");
        assertEquals(Rating.FIVE, song.getRating());
        assertTrue(song.getFavorite());
    }

    @Test
    void testFavoriteSong() {
        assertFalse(song.getFavorite());

        song.favoriteSong();
        assertTrue(song.getFavorite());
    }

    @Test
    void testGetTitle() {
        assertEquals("Pork Soda", song.getTitle());
    }

    @Test
    void testGetArtist() {
        assertEquals("Glass Animals", song.getArtist());
    }

    @Test
    void testGetAlbum() {
        assertEquals("How to Be a Human Being", song.getAlbum());
    }

    @Test
    void testToString() {
        assertEquals("Pork Soda Glass Animals How to Be a Human Being", song.toString());
    }
}