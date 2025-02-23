package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestLibraryModel {
    LibraryModel libraryModel = new LibraryModel();

    @Test
    void testSongByTitle() {
    	assertEquals("Cold Shoulder", libraryModel.songByTitle("cold shoulder").getTitle());
    	Assert.assertNull(libraryModel.songByTitle("sdkfhsa"));
    }
    
    @Test
    void testSongByArtist() {
    	assertEquals("Cold Shoulder", libraryModel.songByArtist("adele").get(3).getTitle());
    	assertTrue(libraryModel.songByArtist("Juice WRLD").isEmpty());
    }
    
    @Test
    void testAlbumByTitle() {
    	assertEquals("19", libraryModel.albumByTitle("19").getTitle());
    	Assert.assertNull(libraryModel.albumByTitle("lsldndfl"));
    }
    
    @Test
    void testAlbumByArtist() {
    	assertEquals("21", libraryModel.albumByArtist("adele").get(1).getTitle());
    	assertTrue(libraryModel.albumByArtist("Juice WRLD").isEmpty());
    }
    
    @Test
    void testMySongByTitle() {
    	libraryModel.addSong("cold shoulder");
    	assertEquals("Cold Shoulder", libraryModel.mySongByTitle("cold shoulder").getTitle());
    	Assert.assertNull(libraryModel.mySongByTitle("sdkfhsa"));
    }
    
    @Test
    void testMySongByArtist() {
    	libraryModel.addSong("cold shoulder");
    	libraryModel.addSong("tired");
    	assertEquals("Adele", libraryModel.mySongByArtist("adele").get(1).getArtist());
    	assertTrue(libraryModel.mySongByArtist("Juice WRLD").isEmpty());
    }
    
    @Test
    void testMyAlbumByTitle() {
    	libraryModel.addAlbum("19");
    	assertEquals("19", libraryModel.myAlbumByTitle("19").getTitle());
    	Assert.assertNull(libraryModel.myAlbumByTitle("sdkfhsa"));
    }
    
    @Test
    void testMyAlbumByArtist() {
    	libraryModel.addAlbum("19");
    	libraryModel.addAlbum("21");
    	assertEquals("21", libraryModel.myAlbumByArtist("adele").get(1).getTitle());
    	assertTrue(libraryModel.myAlbumByArtist("sdkfhsa").isEmpty());
    }
    
    @Test
    void testSearchPlaylists() {
    	libraryModel.createPlaylist("Shivom's Music");
    	assertEquals("Shivom's Music", libraryModel.searchPlaylists("shivom's music").getPlaylistName());
    	Assert.assertNull(libraryModel.searchPlaylists("s;odojfj"));
    }
    
    @Test
    void testAddSong() {
    	assertFalse(libraryModel.addSong("not a song"));
    }
    
    @Test
    void testAddAlbum() {
    	assertFalse(libraryModel.addAlbum("not an album"));
    }
    
    @Test
    void testGetSongTitles() {
    	assertTrue(libraryModel.getSongTitles().isEmpty());
    	libraryModel.addSong("tired");
    	libraryModel.addSong("cold shoulder");
    	assertEquals("Cold Shoulder", libraryModel.getSongTitles().get(1));
    }
    
    @Test
    void testGetArtist() {
    	assertTrue(libraryModel.getArtist().isEmpty());
    	libraryModel.addAlbum("19");
    	libraryModel.addAlbum("boys & girls");
    	assertEquals("Adele", libraryModel.getArtist().get(0));
    }
    
    @Test
    void testGetAlbums() {
    	assertTrue(libraryModel.getAlbums().isEmpty());
    	libraryModel.addAlbum("19");
    	libraryModel.addAlbum("boys & girls");
    	assertEquals("19", libraryModel.getAlbums().get(0));
    }
    
    @Test
    void testGetPlaylists() {
    	assertTrue(libraryModel.getPlaylists().isEmpty());
    	libraryModel.createPlaylist("New Music");
    	libraryModel.createPlaylist("Old Music");
    	assertEquals("Old Music", libraryModel.getPlaylists().get(1));
    }
    
    @Test
    void testGetFavoriteSongs() {
    	assertTrue(libraryModel.getFavoriteSongs().isEmpty());
    	libraryModel.addSong("tired");
    	libraryModel.addSong("cold shoulder"); 
    	libraryModel.markSongFavorite("cold shoulder");
    	assertEquals("Cold Shoulder", libraryModel.getFavoriteSongs().get(0));
    }
    
    @Test
    void testCreatePlaylist() {
    	libraryModel.createPlaylist("shivom");
    	assertTrue(libraryModel.createPlaylist("paudel"));
    	assertFalse(libraryModel.createPlaylist("shivom"));
     }
    
    @Test
    void testAddSongToPlaylist() {
    	libraryModel.createPlaylist("shivom");
    	assertTrue(libraryModel.addSongToPlaylist("shivom", "tired"));
    	assertFalse(libraryModel.addSongToPlaylist("water", "tired"));
    	assertFalse(libraryModel.addSongToPlaylist("shivom", "sdkfsad"));
     }
    
    @Test
    void testRemoveSongFromPlaylist() {
    	libraryModel.createPlaylist("shivom");
    	libraryModel.addSongToPlaylist("shivom", "tired");
    	assertTrue(libraryModel.removeSongFromPlaylist("shivom", "tired"));
    	assertFalse(libraryModel.removeSongFromPlaylist("shivom", "sdkfsad"));
    	libraryModel.addSongToPlaylist("shivom", "tired");
    	assertFalse(libraryModel.removeSongFromPlaylist("hello", "tired"));
     }
    
    @Test
    void testMarkSongFavorite() {
    	libraryModel.addSong("tired");
    	libraryModel.addSong("cold shoulder"); 
    	assertTrue(libraryModel.markSongFavorite("cold shoulder"));
    	assertFalse(libraryModel.markSongFavorite("shivom"));
     }
    
    @Test
    void testRateSong() {
    	libraryModel.addSong("Tired");
    	libraryModel.addSong("Cold Shoulder"); 
    	assertTrue(libraryModel.rateSong("cold shoulder", "3"));
    	assertFalse(libraryModel.rateSong("Shivom", "5"));
     }
}