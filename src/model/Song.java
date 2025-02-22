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
	
	public void rate(String userRate) {
		switch (userRate) {
			case "1":
				this.rating = Rating.ONE;
			case "2":
				this.rating = Rating.TWO;
			case "3":
				this.rating = Rating.THREE;
			case "4":
				this.rating = Rating.FOUR;
			case "5":
				this.rating = Rating.FIVE;
				favorite = true;
		}
	}
	
	public void favoriteSong() {
		if (this.favorite) {
			System.out.println("This song is already favorited.");
		} else {
			this.favorite = true;
		}
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
		return this.getAlbum();
	}
	
	public String toString() {
		return this.title + " " + this.artist + " " + this.album;
	}
}
