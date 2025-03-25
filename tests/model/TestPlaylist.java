package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TestPlaylist {
	Playlist playlist = new Playlist("Shivom's Playlist");
	Song song = new Song("Pork Soda", "Glass Animals", "How to Be a Human Being", "Alternative");


    @Test
    void testAddSong() {
        playlist.addSong(song);
        List<Song> songs = playlist.getSongs();
        
        assertEquals(1, songs.size());
        assertEquals(song, songs.get(0));
    }

    @Test
    void testRemoveSong() {
        playlist.removeSong(song);
        assertTrue(playlist.getSongs().isEmpty());
    }

    @Test
    void testGetPlaylistName() {
        assertEquals("Shivom's Playlist", playlist.getPlaylistName());
    }

    @Test
    void testGetSongs() {
        playlist.addSong(song);

        List<Song> songs = playlist.getSongs();
        assertEquals(1, songs.size());
        assertEquals(song, songs.get(0));
    }

    @Test
    void testPrintPlaylist() {
    	playlist.addSong(song);
        playlist.printPlaylist();
    }
    
    @Test
    void testInsertSongBeginning() {
    	playlist.insertSongBeginning(song);
    	assertEquals(song, playlist.getSongs().get(0));
    }
    
    @Test
    void testRemoveLast() {
    	playlist.addSong(song);
    	playlist.removeLastSong();
    	assertEquals(0, playlist.getSongs().size());
    }
    
    @Test
    void testUpdateMostFrequent() {
    	ArrayList<Song> stuff = new ArrayList<Song>();
    	for (int i = 0; i < 20; i++) {
    		String str = Integer.toString(i);
    		Song cur = new Song(str, str, str, str);
    		for (int j = 0; j < i; j++) {
    			cur.increasePlayCount();
    		}
    		stuff.add(cur);
    	}
    	
    	playlist.updateMostFrequent(stuff);
    }
}