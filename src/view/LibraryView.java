package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;

//File: LibraryView.java
//Author: Viswa Sushanth Karuturi && Shivom Paudel
//Purpose: The purpose of this file is to define the View of this project.


public class LibraryView {
	private LibraryModel libraryModel;
	private Scanner scanner;
	
	public LibraryView(LibraryModel libraryModel) {
		this.libraryModel = libraryModel;
		this.scanner = new Scanner(System.in);	
	} 
	
	public void menuView() {
		System.out.println("Welcome to the Music Library");
		System.out.println("Menu:");
		System.out.println("1. Search for a song by title type: '1'");
		System.out.println("2. Search for a song by artist type: '2'");
		System.out.println("3. Search for an album by title type: '3'");
		System.out.println("4. Search for an album by artist type: '4'");
		System.out.println("5. Search for a song by title in your library type: '5'");
		System.out.println("6. Search for a song by artist in your library type: '6'");
		System.out.println("7. Search for an album by title in your library type: '7'");
		System.out.println("8. Search for an album by artist in your library type: '8'");
		System.out.println("9. Search for a playlist by name in your library type: '9'");
		System.out.println("10. Add a song to the library type: '10'");
		System.out.println("11. Add an album to the library type: '11'");
		System.out.println("12. List of all songs in your library type: '12'");
		System.out.println("13. List of all artists in your library type: '13'");
		System.out.println("14. List of all albums in your library type: '14'");
		System.out.println("15. List of all playlists in your library type: '15'");
		System.out.println("16. List of all favorite songs in your library type: '16'");
		System.out.println("17. Create a playlist in your library type: '17'");
		System.out.println("18. Add a song to your playlist type: '18'");
		System.out.println("19. Remove a song from your playlist type: '19'");
		System.out.println("20. Mark a song as favorite in your library type: '20'");
		System.out.println("21. Rate a song in your library type: '21'");
		System.out.println("22. EXIT type: '22'");		
	}
	
	private void searchStoreSongByTitle() {
		System.out.println("Enter the song name: ");
        String title = scanner.nextLine().trim().toLowerCase();
        ArrayList<Song> songs = libraryModel.songByTitle(title);
        if (!songs.isEmpty()) {
        	for (int i = 0; i < songs.size(); i++) {
        		System.out.println(songs.get(i).toString());
        	}
        } else {
            System.out.println("Song not found in music store.");
        }
    }
	
	
	private void searchStoreSongByArtist() {
        System.out.println("Enter the artist name: ");
        String artist = scanner.nextLine().trim().toLowerCase();
        ArrayList<Song> songs = libraryModel.songByArtist(artist);
        if (!songs.isEmpty()) {
            for (Song song : songs) {
                System.out.println(song.toString());
            }
        } else {
            System.out.println("Artist not found in music store");
        }
    }
	
	private void searchStoreAlbumByTitle() {
		System.out.println("Enter the album name: ");
		String title = scanner.nextLine().trim().toLowerCase();
		Album album = libraryModel.albumByTitle(title);
		if (album != null) {
			System.out.println(album.toString());
			album.printSongs();
		} else {
			System.out.println("Album not found in music store");
		}	
	}
	
	private void searchStoreAlbumByArtist() {
        System.out.println("Enter the artist name: ");
        String artist = scanner.nextLine().trim().toLowerCase();
        ArrayList<Album> albums = libraryModel.albumByArtist(artist);
        if (!albums.isEmpty()) {
            for (Album album : albums) {
                System.out.println(album.toString());
                album.printSongs();
            }
        } else {
            System.out.println("Artist not found in music store");
        }
    }
	
	private void searchLibrarySongByTitle() {
		System.out.println("Enter the song name: ");
        String title = scanner.nextLine().trim().toLowerCase();
        ArrayList<Song> songs = libraryModel.mySongByTitle(title);
        if (!songs.isEmpty()) {
        	for(int i = 0; i <songs.size(); i++) {
        		System.out.println(songs.get(i).toString());
        	}
        } else {
            System.out.println("Song not found in your library");
        }
    }
	
	private void searchLibrarySongByArtist() {
        System.out.println("Enter the artist name: ");
        String artist = scanner.nextLine().trim().toLowerCase();
        ArrayList<Song> songs = libraryModel.mySongByArtist(artist);
        if (!songs.isEmpty()) {
            for (Song song : songs) {
                System.out.println(song.toString());
            }
        } else {
            System.out.println("Artist not found in your library");
        }
    }
	
	private void searchLibraryAlbumByTitle() {
		System.out.println("Enter the album name: ");
		String title = scanner.nextLine().trim().toLowerCase();
		Album album = libraryModel.myAlbumByTitle(title);
		if (album != null) {
			System.out.println(album.toString());
			album.printSongs();
		} else {
			System.out.println("Album not found in your library");
		}	
	}
	
	private void searchLibraryAlbumByArtist() {
        System.out.println("Enter the artist name: ");
        String artist = scanner.nextLine().trim().toLowerCase();
        ArrayList<Album> albums = libraryModel.myAlbumByArtist(artist);
        if (!albums.isEmpty()) {
            for (Album album : albums) {
                System.out.println(album.toString());
                album.printSongs();
            }
        } else {
            System.out.println("Artist not found in your library");
        }
    }
	
	private void searchLibraryPlaylistByName() {
		System.out.println("Enter the playlist name: ");
		String name = scanner.nextLine().trim().toLowerCase();
		Playlist playlist = libraryModel.searchPlaylists(name);
		if (playlist != null) {
			playlist.printPlaylist();
		} else {
			System.out.println("Playlist not found in the library");
		}
	}
	
	private void addSongToLibrary() {
	    System.out.println("Enter the song name: ");
	    String songName = scanner.nextLine().trim().toLowerCase();
	    System.out.println("Enter the song artist: ");
	    String artistName = scanner.nextLine().trim().toLowerCase();
	    
	    if (libraryModel.mySongByNameAndArtist(songName, artistName) != null) {
	        System.out.println("Song already exists in your library");
	    } else {
	    	boolean songAdded = libraryModel.addSong(songName, artistName);
		    if (songAdded) {
		        System.out.println("Song added to your library.");
		    } else {
		        System.out.println("Song not found in the music store");
		    } 	
	   }
	}

	private void addAlbumToLibrary() {
		System.out.println("Enter the album name: ");
	    String albumName = scanner.nextLine().trim().toLowerCase();
	    if (libraryModel.myAlbumByTitle(albumName) != null) {
	        System.out.println("Album already exists in your library");
	    } else {
	    	boolean albumAdded = libraryModel.addAlbum(albumName);
		    if (albumAdded) {
		        System.out.println("Album added to your library.");
		    } else {
		        System.out.println("Album not found in the music store");
		    } 	
	   }
	}
	
	private void mySongs() {
		ArrayList<String> songs = libraryModel.getSongTitles();
		if (!songs.isEmpty()) {
			for (String song : songs) {
	            System.out.println(song);
			}
		} else {
			System.out.println("No songs found in your library");
		}
	}
	
	private void myArtists() {
		ArrayList<String> artists = libraryModel.getArtist();
		if (!artists.isEmpty()) {
			for (String artist : artists) {
	            System.out.println(artist);
			}
		} else {
			System.out.println("No artists found in your library");
		}
	}
	
	private void myAlbums() {
		ArrayList<String> albums = libraryModel.getAlbums();
		if (!albums.isEmpty()) {
			for (String album : albums) {
	            System.out.println(album);
			}
		} else {
			System.out.println("No albums found in your library");
		}
	}
	
	private void myPlaylists() {
		ArrayList<String> playlists = libraryModel.getPlaylists();
		if (!playlists.isEmpty()) {
			for (String playlist : playlists) {
	            System.out.println(playlist);
			}
		} else {
			System.out.println("No playlists found in your library");
		}
	}
	
	private void myFavoriteSongs() {
		ArrayList<String> favSongs = libraryModel.getFavoriteSongs();
		if (!favSongs.isEmpty()) {
			for (String favSong : favSongs) {
	            System.out.println(favSong);
			}
		} else {
			System.out.println("No favorite songs found in your library");
		}
	}
	
	private void createMyPlaylist() {
		System.out.println("Enter the playlist name: ");
		String playlistName = scanner.nextLine().trim().toLowerCase();
		boolean playlistCreated = libraryModel.createPlaylist(playlistName);
		
		if(playlistCreated) {
			System.out.println("Playlist created");		
		} else {
			System.out.println("Playlist already exits");
		}	
	}
	
	private void addSongsToPlaylist() {
		System.out.println("Enter the playlist name: ");
		String playlistName = scanner.nextLine().trim().toLowerCase();
		System.out.println("Enter the song name: ");
		String songTitle = scanner.nextLine().trim().toLowerCase();
		System.out.println("Enter the artist name: ");
		String artistName = scanner.nextLine().trim().toLowerCase();
		
		if (libraryModel.searchPlaylists(playlistName) != null) {
			
			if(!libraryModel.searchPlaylists(playlistName).getSongAndArtistNames().contains(songTitle + " " + artistName)) {
				
				boolean songAdded = libraryModel.addSongToPlaylist(playlistName, songTitle, artistName);
				if (songAdded) {
					System.out.println("Song added to playlist");
				} else {
					System.out.println("Could not add song to playlist. Song does not exist in music store");
				}
				
			} else {
				System.out.println("This song is already in your playlist");
			}
		} else {
			System.out.println("Playlist does not exist");
		}    
	}
	
	private void removeSongFromPlaylist() {
        System.out.println("Enter the playlist name: ");
        String playlistName = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter the song name: ");
        String songTitle = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter the artist name: ");
        String artistName = scanner.nextLine().trim().toLowerCase();
        
        boolean songRemoved = libraryModel.removeSongFromPlaylist(playlistName, songTitle, artistName);
        if (songRemoved) {
            System.out.println("Song removed from playlist");
        } else {
            System.out.println("Could not remove song from playlist. Check if playlist is in your library and song is in your playlist");
        }
    }

	
	private void markSongFavorite() {
        System.out.println("Enter the song name: ");
        String songTitle = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter the artist name: ");
        String artistName = scanner.nextLine().trim().toLowerCase();
        
        
        boolean favMarked = libraryModel.markSongFavorite(songTitle, artistName);
        if (favMarked) {
            System.out.println("Song marked as favorite");
        } else {
            System.out.println("Song not found in your library");
        }
    }
	
	private void rateSong() {
        System.out.println("Enter the song name: ");
        String songTitle = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter the artist name: ");
        String artistName = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter the rating (1-5): ");
        String songRating = scanner.nextLine().trim();
        
        try { 
        	Integer.parseInt(songRating); 
        	
        	if (Integer.parseInt(songRating) < 1 || Integer.parseInt(songRating) > 5) {
        		System.out.println("Enter a valid rating (1-5)");
        	} else {
        		boolean songRated = libraryModel.rateSong(songTitle, artistName, songRating);
        		if (songRated) {
        			System.out.println("Song rated");
        		} else {
        			System.out.println("Song not found in your library.");
        		}
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Enter a valid rating (1-5)");
        }
    }
	
	private void run() {
		boolean running = true;
		while(running) {
			menuView();
			System.out.println("Enter your choice! ");
			String input = scanner.nextLine();
			
			switch(input.trim()) {
				case "1":
					searchStoreSongByTitle();
					break;
				case "2":
					searchStoreSongByArtist();
					break;
				case "3":
					searchStoreAlbumByTitle();
					break;
				case "4":
					searchStoreAlbumByArtist();
					break;
				case "5":
					searchLibrarySongByTitle();
					break;
				case "6":
					searchLibrarySongByArtist();
					break;
				case "7":
					searchLibraryAlbumByTitle();
					break;
				case "8":
					searchLibraryAlbumByArtist();
					break;
				case "9":
					searchLibraryPlaylistByName();
					break;
				case "10":
					addSongToLibrary();
					break;
				case "11":
					addAlbumToLibrary();
					break;
				case "12":
					mySongs();
					break;
				case "13":
					myArtists();
					break;
				case "14":
					myAlbums();
					break;
				case "15":
					myPlaylists();
					break;
				case "16":
					myFavoriteSongs();
					break;
				case "17":
					createMyPlaylist();
					break;
				case "18":
					addSongsToPlaylist();
					break;
				case "19":
					removeSongFromPlaylist();
					break;
				case "20":
					markSongFavorite();
					break;
				case "21":
					rateSong();
					break;
				case "22":
					System.out.println("Goodbye!");
					running = false;
					break;
				default:
					System.out.println("Invalid input try again!");
			}
		}
	}
	
	public static void main(String[] args) {
        LibraryModel libraryModel = new LibraryModel();
        LibraryView view = new LibraryView(libraryModel);
        view.run();   
    }
	
}
 