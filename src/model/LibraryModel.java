package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
	private Playlist mostRecent;
	private Playlist mostFrequent;
	private String username;
	private String password;
	private HashMap genreFrequency;
	
	public LibraryModel(String username, String password) {
		MusicStore store = new MusicStore();
		this.allAlbums = store.getAlbumsList();
		this.allSongs = store.getSongsList();
		this.playlists = new ArrayList<Playlist>();
		this.mySongs = new ArrayList<Song>();
		this.myAlbums = new ArrayList<Album>();
		this.mostRecent = new Playlist("Recently Played");
		this.mostFrequent = new Playlist("Frequently Played");
		this.setUsername(username);
		this.setPassword(password);
		this.genreFrequency = new HashMap<String, ArrayList<Song>>();
		this.playlists.add(mostRecent);
		this.playlists.add(mostFrequent);
	}
	
	public ArrayList<Song> songByTitle(String songName) {
		ArrayList<Song> songsWithName = new ArrayList<Song>();
		
		for (int i = 0; i < allSongs.size(); i++) {
			if (allSongs.get(i).getTitle().toLowerCase().equals(songName.toLowerCase())) {
				songsWithName.add(new Song(allSongs.get(i)));
			}
		}
		
		return songsWithName;
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
	
	public ArrayList<Song> mySongByTitle(String songName) {
		ArrayList<Song> songsWithName = new ArrayList<Song>();
		
		for (int i = 0; i < mySongs.size(); i++) {
			if (mySongs.get(i).getTitle().toLowerCase().equals(songName)) {
				songsWithName.add(new Song(mySongs.get(i)));
			}
		}
		
		return songsWithName;
	}
	
	public Song songByNameAndArtist(String song, String artist) {
		for (int i = 0; i < allSongs.size(); i++) {
			String curSongName = this.allSongs.get(i).getTitle().toLowerCase();
			String curSongArtist = this.allSongs.get(i).getArtist().toLowerCase();
			
			if (curSongName.equals(song.toLowerCase()) && curSongArtist.equals(artist.toLowerCase())) {
				return this.allSongs.get(i);
			}
		}
		
		return null;
	}
	 
	public Song mySongByNameAndArtist(String songName, String artist) {
		for (int i = 0; i < mySongs.size(); i++) {
			String curSongName = this.mySongs.get(i).getTitle().toLowerCase();
			String curSongArtist = this.mySongs.get(i).getArtist().toLowerCase();
			
			if (curSongName.equals(songName.toLowerCase()) && curSongArtist.equals(artist.toLowerCase())) {
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
	
	public boolean addSong(String song, String artistName) {
		for (int i = 0; i < this.allSongs.size(); i++) {
			String curSongName = this.allSongs.get(i).getTitle().toLowerCase();
			String curSongArtist = this.allSongs.get(i).getArtist().toLowerCase();
			
			if (song.toLowerCase().equals(curSongName) && artistName.toLowerCase().equals(curSongArtist)) {
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
						this.addSong(albumSongs.get(j).getTitle(), albumSongs.get(j).getArtist());
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
	
	public boolean addSongToPlaylist(String playlistName, String songName, String artistName) {
		Playlist playlist = searchPlaylists(playlistName);
		Song song = songByNameAndArtist(songName, artistName);
		if (playlist != null && song != null) {
			playlist.addSong(song);
			if(mySongByNameAndArtist(songName, artistName) == null) {
				this.addSong(song.getTitle(), song.getArtist());
			}
			return true;
		}
		
		return false;
	}
	
	public boolean removeSongFromPlaylist(String playlistName, String songName, String artistName) {
		Playlist playlist = searchPlaylists(playlistName);
		Song song = mySongByNameAndArtist(songName, artistName);
		if (playlist != null && song != null) {
			boolean songInPlaylist = playlist.getSongAndArtistNames().contains(songName.toLowerCase() + " " + artistName.toLowerCase());
			if (songInPlaylist) {
				playlist.removeSong(song);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean markSongFavorite(String songName, String songArtist) {
		Song song = mySongByNameAndArtist(songName, songArtist);
		if (song != null) {
			song.favoriteSong();
			return true;
		}
		
		return false;
	} 
	
	public boolean rateSong(String songName, String artistName, String rating) {
		Song song = mySongByNameAndArtist(songName, artistName);
		if (song != null) {
			song.rate(rating);
			return true;
		}
		
		return false;
	}
	
	public boolean playSong(String songName, String artistName) {
		Song song = mySongByNameAndArtist(songName, artistName);
		if(song != null) {
			song.increasePlayCount();
			mostRecent.insertSongBeginning(song);
			if (mostRecent.getSongs().size() > 10) {
				mostRecent.removeLastSong();
			}
			return true;
		}
		
		return false;
	}
	
	public boolean removeSong(String songName, String artistName) {
		Song song = mySongByNameAndArtist(songName, artistName);
		if (song != null) {
			this.mySongs.remove(song);
			return true;
		}
		
		return false;
	}
	
	public boolean removeAlbum(String albumName) {
		Album album = myAlbumByTitle(albumName);
		if (album != null) {
			this.myAlbums.remove(album);
			
			List<Song> albumSongs = album.getSongs();
			for (Song song : this.mySongs) {
				if (albumSongs.contains(song)) {
					mySongs.remove(song);
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	public List<Song> searchSongsByGenre(String genre) {
		if (this.genreFrequency.containsKey(genre)) {
			return Collections.unmodifiableList((List<Song>) this.genreFrequency.get(genre));
		}
		
		return null;
	}
	
	public void shuffle() {
		Collections.shuffle(this.mySongs);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
