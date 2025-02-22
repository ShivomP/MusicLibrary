package model;

import java.util.ArrayList;

// File: Playlist.java
// Author: Shivom Paudel
// Purpose: This file defines the Playlist class and preforms the 
// desired actions on a playlist.

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist (String name, ArrayList<Song> songs) {
		this.name = name;
		this.songs = new ArrayList<Song>();
	}
	
	public void addSong(Song song) {
		if (songs.contains(song)) {
			System.out.println("This song is already in this playlist");
		} else {
			songs.add(song);
		}
	}
	
	public void removeSong(Song song) {
		if (!songs.contains(song)) {
			System.out.println("This song does not exist in this playlist");
		} else {
			songs.remove(song);
		}
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
