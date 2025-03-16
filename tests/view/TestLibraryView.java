package view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestLibraryView {
    InputStream originalIn = System.in;
    String command;
    ByteArrayInputStream inputStream;
    
    @AfterEach 
    void cleanUp() {
    	System.setIn(originalIn);
    }

    @Test
    void testSearchStoreSongByTitle() {
    	command = "1\n tired\n "
    			+ "1\n shivom\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    @Test
    void testSearchStoreSongByArtist() {
    	command = "2\n adele\n "
    			+ "2\n shivom\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    @Test
    void testSearchStoreAlbumByTitle() {
    	command = "3\n 19\n "
    			+ "3\n shivom\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    @Test
    void testSearchStoreAlbumByArtist() {
    	command = "4\n coldplay\n "
    			+ "4\n shivom\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    @Test
    void testAddAndSearchSongLibrary() {
    	command = "10\n my heart is full\n norah jones\n "
    			+ "10\n my heart is full\n norah jones\n "
    			+ "10\n shivom\n norah jones\n "
    			+ "5\n my heart is full\n "
    			+ "5\n shivom\n "
    			+ "6\n Norah Jones\n "
    			+ "6\n shiv\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    @Test
    void testAddAndSearchAlbumLibrary() {
    	command = "12\n "
    			+ "13\n "
    			+ "14\n "
    			+ "11\n old ideas\n "
    			+ "11\n 19\n "
    			+ "11\n old ideas\n "
    			+ "11\n shivom\n "
    			+ "7\n old ideas\n "
    			+ "7\n shivom\n "
    			+ "8\n leonard cohen\n "
    			+ "8\n shiv\n "
    			+ "12\n "
    			+ "13\n "
    			+ "14\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    
    @Test
    void testPlaylistFunctionality() {
    	command = "15\n "
    			+ "17\n another one\n"
    			+ "17\n shivom's music\n "
    			+ "17\n shivom's music\n "
    			+ "18\n shiv\n tired\n adele\n "
    			+ "18\n shivom's music\n dsjf\n  adele\n "
    			+ "18\n shivom's music\n tired\n adele\n "
    			+ "18\n shivom's music\n tired\n adele\n "
    			+ "18\n shivom's music\n cold shoulder\n adele\n "
    			+ "9\n shivom's music\n "
    			+ "9\n kiv\n "
    			+ "15\n "
    			+ "19\n shiv\n tired\n adele\n "
    			+ "19\n shivom's music\n fake\n fake\n "
    			+ "19\n shivom's music\n tired\n adele\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    }
    
    @Test
    void testRatingAndFavoriting() {
    	command = "16\n "
    			+ "10\n tired\n adele\n "
    			+ "10\n cold shoulder\n adele\n "
    			+ "20\n tired\n adele\n "
    			+ "20\n ww\n adele\n "
    			+ "21\n cold shoulder\n adele\n 3\n "
    			+ "21\n cold shoulder\n adele\n 0\n "
    			+ "21\n skdfj\n adele\n 4\n "
    			+ "21\n cold shoulder\n adele\n 5\n "
    			+ "16\n "
    			+ "22\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    } 
} 
