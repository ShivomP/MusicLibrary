package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// File: Playlist.java
// Author: Shivom Paudel
// Purpose: This file defines the Playlist class and preforms the 
// desired actions on a playlist.

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist (String name) {
		this.name = name;
		this.songs = new ArrayList<Song>();
	}
	
	public List<Song> getSongs() {
		return Collections.unmodifiableList(this.songs);
	}
	
	public ArrayList<String> getSongAndArtistNames() {
		ArrayList<String> songNames = new ArrayList<String>();
		for (int i = 0; i < this.songs.size(); i++) {
			String songTitle = songs.get(i).getTitle().toLowerCase();
			String artistName = songs.get(i).getArtist().toLowerCase();
			
			songNames.add(songTitle + " " + artistName); 
		}
		
		return songNames;
	}
	
	public void insertSongBeginning(Song song) {
		songs.add(0, song);
	}
	
	public void removeLastSong() {
		songs.remove(songs.size() - 1);
	}
	
	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void removeSong(Song song) {
		songs.remove(song);
	}
	
	public String getPlaylistName() {
		return this.name;
	}
	
	public void printPlaylist() {
		for (int i = 0; i < this.songs.size(); i++) {
			System.out.println(this.songs.get(i).getTitle() + " - " + this.songs.get(i).getArtist());
		}
	}
}
