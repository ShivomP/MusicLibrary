package view;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.*;

//File: LibraryView.java
//Author: Viswa Sushanth Karuturi && Shivom Paudel
//Purpose: The purpose of this file is to define the View of this project.


public class LibraryView {
	private LibraryModel libraryModel;
	private Scanner scanner;
	private String path;
	
	public LibraryView(String username) {
		this.libraryModel = new LibraryModel();
		this.scanner = new Scanner(System.in);	
		this.path = "src/model/" + username + ".txt";
		loadUserData();
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
		System.out.println("22. Get list of songs sorted by title type: '22'");
		System.out.println("23. Get list of songs sorted by artist type: '23'");
		System.out.println("24. Get list of songs sorted by rating type: '24'");
		System.out.println("25. Remove song from library type: '25'");
		System.out.println("26. Remove album from library type: '26'");
		System.out.println("27. Search for songs by genre type: '27'");
		System.out.println("28. Shuffle songs in your library type: '28'");
		System.out.println("29. Shuffle songs in a playlist type: '29'");
		System.out.println("30. Play a song type: '30'");
		System.out.println("31. EXIT type: '31'");		
	}
	
	private void searchStoreSongByTitle() {
		System.out.println("Enter the song name: ");
        String title = scanner.nextLine().trim().toLowerCase();
        ArrayList<Song> songs = libraryModel.songByTitle(title);
        if (!songs.isEmpty()) {
        	for (int i = 0; i < songs.size(); i++) {
        		Song curSong = songs.get(i);
        		System.out.println(curSong.toString());
        		
        		System.out.println("Would you like the album information of this song: 'Y' or 'N'");
        		String answer = scanner.nextLine().trim().toLowerCase();
        		if (answer.equals("y")) {
        			Album album = libraryModel.albumByTitle(curSong.getAlbum());
        			System.out.println(album);
        			album.printSongs();
        			
        			ArrayList<String> result = libraryModel.getAlbums();
        			
        			if(result != null && result.contains(album.getTitle())) {
        				System.out.println("Your library contains this album");
        			} else {
        				System.out.println("Your library does not contain this album");
        			}
        		}
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
		        saveUserData("10");
		        saveUserData(songName);
		        saveUserData(artistName);
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
		        saveUserData("11");
		        saveUserData(albumName);
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
			saveUserData("17");
			saveUserData(playlistName);
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
					saveUserData("18");
					saveUserData(playlistName);
					saveUserData(songTitle);
					saveUserData(artistName);
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
            saveUserData("19");
            saveUserData(playlistName);
            saveUserData(songTitle);
            saveUserData(artistName);
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
            saveUserData("20");
            saveUserData(songTitle);
            saveUserData(artistName);
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
        			saveUserData("21");
        			saveUserData(songTitle);
        			saveUserData(artistName);
        			saveUserData(songRating);
        		} else {
        			System.out.println("Song not found in your library.");
        		}
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Enter a valid rating (1-5)");
        }
    }
	
	private void sortSongsByTitle() {
		List<Song> sorted = libraryModel.sortBySongTitle();
		
		if (sorted == null) {
			System.out.println("No songs in your library.");
		} else {
			for (Song song : sorted) {
				System.out.println(song);
			}
		}
	}
	
	private void sortSongsByArtist() {
		List<Song> sorted = libraryModel.sortBySongArtist();
		
		if (sorted == null) {
			System.out.println("No songs in your library.");
		} else {
			for (Song song : sorted) {
				System.out.println(song);
			}
		}
	}
	
	private void sortSongsByRating() {
		List<Song> sorted = libraryModel.sortBySongRating();
		
		if (sorted == null) {
			System.out.println("No rated songs in your library.");
		} else {
			for (Song song : sorted) {
				System.out.println(song + " " + song.getRating());
			}
		}
	}
	
	private void removeSongFromLibrary() {
		System.out.println("Enter the song name: ");
		String songTitle = scanner.nextLine().trim().toLowerCase();
		System.out.println("Enter the artist name: ");
		String artistName = scanner.nextLine().trim().toLowerCase();
		
		boolean result = libraryModel.removeSong(songTitle, artistName);
		if(result) {
			System.out.println("Song removed from library!");
			saveUserData("25");
			saveUserData(songTitle);
			saveUserData(artistName);
		} else {
			System.out.println("Song does not exist in library!");
		}
	}
	
	private void removeAlbumFromLibrary() {
		System.out.println("Enter the album name: ");
		String albumTitle = scanner.nextLine().trim().toLowerCase();
		
		boolean result = libraryModel.removeAlbum(albumTitle);
		if(result) {
			System.out.println("Album removed from library!");
			saveUserData("26");
			saveUserData(albumTitle);
		} else {
			System.out.println("Album does not exist in library!");
		}
	}
	
	private void searchSongsByGenre() {
		System.out.println("Enter the genre name: ");
		String genre = scanner.nextLine().trim().toLowerCase();
		
		List <Song> genreSongs = libraryModel.searchSongsByGenre(genre);
		
		if(genreSongs == null) {
			System.out.println("Genre does not exist in your library.");
		} else {
			for (Song song : genreSongs) {
				System.out.println(song);
			}
		}
	}
	
	private void shuffleAllSongs() {
		if (libraryModel.shuffleAllSongs()) {
			Iterator<Song> songIterator = libraryModel.getSongIterator();
			while (songIterator.hasNext()) {
				System.out.println(songIterator.next());
			}
		} else {
			System.out.println("Not enough songs to shuffle");
		}
	}
	
	private void shufflePlaylist() {
		System.out.println("Enter the playlist name: ");
		String playlistName = scanner.nextLine().trim().toLowerCase();
		
		boolean shuffled = libraryModel.shufflePlaylist(playlistName);
		
		if (shuffled) {
			Iterator<Song> playlistIterator = libraryModel.getPlaylistIterator(libraryModel.searchPlaylists(playlistName));
			while (playlistIterator.hasNext()) {
				System.out.println(playlistIterator.next());
			}
		} else {
			System.out.println("Playlist doesn't exist");
		}
		
		
	}
	
	private void playSong() {
		System.out.println("Enter the song name: ");
		String songName = scanner.nextLine().trim().toLowerCase();
		System.out.println("Enter the artist name: ");
		String artistName = scanner.nextLine().trim().toLowerCase();
		
		boolean result = libraryModel.playSong(songName, artistName);
		
		if (result) {
			System.out.println("Song is playing...");
			saveUserData("30");
			saveUserData(songName);
			saveUserData(artistName);
		} else {
			System.out.println("Song does not exist in your library");
		}
	}
	
	private void saveUserData(String data) {
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write(data + System.lineSeparator());
			writer.close();
		} catch (Exception e) {
		      e.printStackTrace();
		}
		
	}
	
	public void loadUserData() {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String command = line.trim();
	            switch (command) {
	                case "10": 
	                    String songTitle = reader.readLine();
	                    String artistName = reader.readLine();
	                    libraryModel.addSong(songTitle, artistName);
	                    break;
	                case "11":
	                    String albumName = reader.readLine();
	                    libraryModel.addAlbum(albumName);
	                    break;
	                case "17": 
	                    String playlistName = reader.readLine();
	                    libraryModel.createPlaylist(playlistName);
	                    break;
	                case "18": 
	                    String playlist = reader.readLine();
	                    String song = reader.readLine();
	                    String artist = reader.readLine();
	                    libraryModel.addSongToPlaylist(playlist, song, artist);
	                    break;
	                case "19": 
	                    String playlistTitle = reader.readLine();
	                    String sTitle = reader.readLine();
	                    String aName = reader.readLine();
	                    libraryModel.removeSongFromPlaylist(playlistTitle, sTitle, aName);
	                    break;
	                case "20": 
	                    String favSongTitle = reader.readLine();
	                    String favArtist = reader.readLine();
	                    libraryModel.markSongFavorite(favSongTitle, favArtist);
	                    break;
	                case "21": 
	                    String rateSongTitle = reader.readLine();
	                    String rateArtist = reader.readLine();
	                    String rating = reader.readLine();
	                    libraryModel.rateSong(rateSongTitle, rateArtist, rating);
	                    break;
	                case "25": 
	                    String removeSongTitle = reader.readLine();
	                    String removeArtist = reader.readLine();
	                    libraryModel.removeSong(removeSongTitle, removeArtist);
	                    break;
	                case "26": 
	                    String album = reader.readLine();
	                    libraryModel.removeAlbum(album);
	                    break;
	                case "30":
	                	String songPlayed = reader.readLine();
	                	String artistPlayed = reader.readLine();
	                	libraryModel.playSong(songPlayed, artistPlayed);
	                case "31": 
	                    break;
	                default:
	                	System.out.println("Invalid input try again!");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void run() {
		boolean running = true;
		while(running) {
			menuView();
			System.out.println("Enter your choice! ");
			String input = scanner.nextLine().trim();				
				
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
					sortSongsByTitle();
					break;
				case "23":
					sortSongsByArtist();
					break;
				case "24":
					sortSongsByRating();
					break;
				case "25":
					removeSongFromLibrary();
					break;
				case "26":
					removeAlbumFromLibrary();
					break;
				case "27":
					searchSongsByGenre();
					break;
				case "28":
					shuffleAllSongs();
					break;
				case "29":
					shufflePlaylist();
					break;
				case "30":
					playSong();
					break;
				case "31":
					System.out.println("Goodbye!");
					running = false;
					break;
				default:
					System.out.println("Invalid input try again!");
			}
		}
	}
}
 