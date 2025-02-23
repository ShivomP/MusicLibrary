package model;

import java.util.ArrayList;
import java.util.List;

// File: LibraryModel.java
// Author: Shivom Paudel
// Purpose: The purpose of this file is to define the Library Model which
// represents a single users music library. This will essentially be the
// backend that allows to user to modify their music library.

public class LibraryModel {
	private List<Album> allAlbums;
	private List<Song> allSongs;
	private ArrayList<Playlist> playlists;
	private ArrayList<Song> mySongs;
	private ArrayList<Album> myAlbums;
	
	public LibraryModel() {
		MusicStore store = new MusicStore();
		this.allAlbums = store.getAlbumsList();
		this.allSongs = store.getSongsList();
		this.playlists = new ArrayList<Playlist>();
		this.mySongs = new ArrayList<Song>();
		this.myAlbums = new ArrayList<Album>();
	}
	
	public Song songByTitle(String songName) {
		for (int i = 0; i < allSongs.size(); i++) {
			if (allSongs.get(i).getTitle().toLowerCase().equals(songName)) {
				return new Song(allSongs.get(i));
			}
		}
		
		return null;
	}
	
	public ArrayList<Song> songByArtist(String artist) {
		ArrayList<Song> artistSongs = new ArrayList<Song>();
		
		for (int i = 0; i < allSongs.size(); i++) {
			if (allSongs.get(i).getArtist().toLowerCase().equals(artist)) {
				artistSongs.add(new Song(allSongs.get(i)));
			}
		}
		
		return artistSongs;
	}
	
	public Album albumByTitle(String albumName) {
		for (int i = 0; i < allAlbums.size(); i++) {
			if (allAlbums.get(i).getTitle().toLowerCase().equals(albumName)) {
				return new Album(allAlbums.get(i));
			}
		}
		
		return null;
	}
	
	public ArrayList<Album> albumByArtist(String artist) {
		ArrayList<Album> artistAlbums = new ArrayList<Album>();
		
		for (int i = 0; i < allAlbums.size(); i++) {
			if (allAlbums.get(i).getArtist().toLowerCase().equals(artist)) {
				artistAlbums.add(new Album(allAlbums.get(i)));
			}
		}
		
		return artistAlbums;
	}
	
	public Song mySongByTitle(String songName) {
		for (int i = 0; i < mySongs.size(); i++) {
			if (mySongs.get(i).getTitle().toLowerCase().equals(songName)) {
				return new Song(mySongs.get(i));
			}
		}
		
		return null;
	}
	 
	private Song mySongByName(String songName) {
		for (int i = 0; i < mySongs.size(); i++) {
			if (mySongs.get(i).getTitle().toLowerCase().equals(songName)) {
				return mySongs.get(i);
			}
		}
		
		return null;
	}
	
	public ArrayList<Song> mySongByArtist(String artist) {
		ArrayList<Song> artistSongs = new ArrayList<Song>();
		
		for (int i = 0; i < mySongs.size(); i++) {
			if (mySongs.get(i).getArtist().toLowerCase().equals(artist)) {
				artistSongs.add(new Song(mySongs.get(i)));
			}
		}
		
		return artistSongs;
	}
	
	public Album myAlbumByTitle(String albumName) {
		for (int i = 0; i < myAlbums.size(); i++) {
			if (myAlbums.get(i).getTitle().toLowerCase().equals(albumName)) {
				return new Album(myAlbums.get(i));
			}
		}
		
		return null;
	}
	
	public ArrayList<Album> myAlbumByArtist(String artist) {
		ArrayList<Album> artistAlbums = new ArrayList<Album>();
		
		for (int i = 0; i < myAlbums.size(); i++) {
			if (myAlbums.get(i).getArtist().toLowerCase().equals(artist)) {
				artistAlbums.add(new Album(myAlbums.get(i)));
			}
		}
		
		return artistAlbums;
	}
	
	public Playlist searchPlaylists(String playlistName) {
		for (int i = 0; i < this.playlists.size(); i++) {
			if (this.playlists.get(i).getPlaylistName().toLowerCase().equals(playlistName)) {
				return this.playlists.get(i);
			}
		}
		
		return null;
	}
	
	public boolean addSong(String song) {
		for (int i = 0; i < this.allSongs.size(); i++) {
			if (song.toLowerCase().equals(this.allSongs.get(i).getTitle().toLowerCase())) {
				mySongs.add(new Song(this.allSongs.get(i)));
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addAlbum(String album) {
		for (int i = 0; i < this.allAlbums.size(); i++) {
			if (this.allAlbums.get(i).getTitle().toLowerCase().equals(album)) {
				myAlbums.add(new Album(this.allAlbums.get(i)));
				List<Song> albumSongs = this.allAlbums.get(i).getSongs();
				
				for (int j = 0; j < albumSongs.size(); j++) {
					if(!(this.getSongTitles().contains(albumSongs.get(j).getTitle()))) {
						this.addSong(albumSongs.get(j).getTitle());
					}
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<String> getSongTitles(){ 
		ArrayList<String> songs = new ArrayList<String>();
		for (int i = 0; i < this.mySongs.size(); i++) {
			songs.add(this.mySongs.get(i).getTitle());
		}
		
		return songs;
	}
	
	public ArrayList<String> getArtist(){
		ArrayList<String> artist = new ArrayList<String>();
		for (int i = 0; i < this.mySongs.size(); i++) {
			if(!artist.contains(this.mySongs.get(i).getArtist())) {
				artist.add(this.mySongs.get(i).getArtist());
			}
		}
		
		return artist;
	}
	
	public ArrayList<String> getAlbums(){
		ArrayList<String> albums = new ArrayList<String>();
		for (int i = 0; i < this.mySongs.size(); i++) {
			if (!albums.contains(this.mySongs.get(i).getAlbum())) {
				albums.add(this.mySongs.get(i).getAlbum());
			}
		}
		
		return albums;
	}
	
	public ArrayList<String> getPlaylists() {
		ArrayList<String> playlistNames = new ArrayList<String>();
		for (int i = 0; i < this.playlists.size(); i++) {
			playlistNames.add(this.playlists.get(i).getPlaylistName());
		}
		
		return playlistNames;
	}
	
	public ArrayList<String> getFavoriteSongs(){
		ArrayList<String> songs = new ArrayList<String>();
		for (int i = 0; i < this.mySongs.size(); i++) {
			if(this.mySongs.get(i).getFavorite()) {
				songs.add(this.mySongs.get(i).getTitle());
			}
		}
		
		return songs;
	}
	
	public boolean createPlaylist(String name) {
		for (int i = 0; i < this.playlists.size(); i++) {
			if (this.playlists.get(i).getPlaylistName().toLowerCase().equals(name)) {
				return false;
			}
		}
		Playlist playlist = new Playlist(name);
		playlists.add(playlist);
		return true;
	}
	
	public boolean addSongToPlaylist(String playlistName, String songName) {
		Playlist playlist = searchPlaylists(playlistName);
		Song song = songByTitle(songName);
		if (playlist != null && song != null) {
			playlist.addSong(song);
			this.addSong(song.getTitle());
			return true;
		}
		
		return false;
	}
	
	public boolean removeSongFromPlaylist(String playlistName, String songName) {
		Playlist playlist = searchPlaylists(playlistName);
		Song song = mySongByTitle(songName);
		if (playlist != null && song != null && playlist.getSongNames().contains(song.getTitle())) {
			playlist.removeSong(song);
			return true;
		}
		
		return false;
	}
	
	public boolean markSongFavorite(String songName) {
		Song song = mySongByName(songName);
		if (song != null) {
			song.favoriteSong();
			return true;
		}
		
		return false;
	}
	
	public boolean rateSong(String songName, String rating) {
		Song song = mySongByName(songName);
		if (song != null) {
			song.rate(rating);
			return true;
		}
		
		return false;
	}
}
