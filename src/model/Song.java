package model;

// File: Song.java
// Author: Shivom Paudel
// Purpose: The purpose of this file is to define the Song class and 
// retrieve information about an instance of the class.

public class Song {
	private String title;
	private String artist;
	private String album;
	private Rating rating;
	private boolean favorite;
	
	public Song(String title, String artist, String album) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.rating = null;
		this.favorite = false;
	}
	
	public Song(Song song) {
		this.title = song.title;
		this.artist = song.artist;
		this.album = song.album;
		this.rating = song.rating;
		this.favorite = song.favorite;
	}

	public void rate(String userRate) {
		switch (userRate) {
			case "1":
				this.rating = Rating.ONE;
				this.favorite = false;
				break;
			case "2":
				this.rating = Rating.TWO;
				this.favorite = false;
				break;
			case "3":
				this.rating = Rating.THREE;
				this.favorite = false;
				break;
			case "4":
				this.rating = Rating.FOUR;
				this.favorite = false;
				break;
			case "5":
				this.rating = Rating.FIVE;
				favorite = true;
				break;
			default:
				System.out.println("Invalid input try again!");
		}
	}
	
	public void favoriteSong() {
		this.favorite = true;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public boolean getFavorite() {
		return this.favorite;
	}
	
	public String getAlbum() {
		return this.album;
	}
	
	public Rating getRating() {
		return this.rating;
	}
	
	public String toString() {
		return this.title + " " + this.artist + " " + this.album;
	}
}
