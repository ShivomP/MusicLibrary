package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// File: Album.java
// Author: Viswa Sushanth Karuturi
// Purpose: The purpose of this file is to define the Album class
// and retrieve desired information about an instance of the class.

public class Album {

	private String title;
	private String artist;
	private String genre;
	private String year;
	private ArrayList<Song> songs;
	
	public Album(String title, String artist, String genre, String year) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.songs = new ArrayList<>();
    }
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs); 
    }
    
    public String toString() {
        return title + "," + artist + "," + genre + "," + year;
    }
    
    public void printSongs() { 
    	// Prints each song title
    	for(int i = 0; i < this.songs.size(); i++) {
    		System.out.println(songs.get(i).getTitle());
    	}
    }
}

