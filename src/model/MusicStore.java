package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// File: MusicStore.java
// Author: Viswa Sushanth Karuturi
// Purpose: The purpose of this class is to make a database for our library
// and implement methods to work on it

public class MusicStore {
    private ArrayList<String> albumFileNames;
    private ArrayList<Album> albums;
    private ArrayList<Song> songs;

    public MusicStore() {
        this.albumFileNames = new ArrayList<String>();
        this.albums = new ArrayList<Album>();
        this.songs = new ArrayList<Song>();
        getAlbumFileNames();
        createAlbums();
        createSongsList();
    }

    private void getAlbumFileNames() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/model/albums.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String albumTitle = parts[0].trim();
                String artist = parts[1].trim();
                albumFileNames.add("src/model/" + albumTitle + "_" + artist + ".txt");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAlbums() {

        for (int i = 0; i < albumFileNames.size(); i++) {

            try (BufferedReader reader = new BufferedReader(new FileReader(albumFileNames.get(i)))) {
                String line;
                int count = 0;

                while ((line = reader.readLine()) != null) {

                    if (count == 0) {
                        String[] parts = line.split(",");
                        String title = parts[0].trim();
                        String artist = parts[1].trim();
                        String genre = parts[2].trim();
                        String year = parts[3].trim();
                        albums.add(new Album(title, artist, genre, year));
                    } else {
                        String[] parts = line.split(",");
                        Song curSong = new Song(parts[0].trim(), albums.get(i).getArtist(), albums.get(i).getTitle(), albums.get(i).getGenre());
                        albums.get(i).addSong(curSong);
                    }
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void createSongsList() {

        for (int i = 0; i < albums.size(); i++) {

            for (int j = 0; j < albums.get(i).getSongs().size(); j++) {
                this.songs.add(albums.get(i).getSongs().get(j));
            }

        }
    }

    public List<Album> getAlbumsList() {
        return Collections.unmodifiableList(this.albums);
    }

    public List<Song> getSongsList() {
        return Collections.unmodifiableList(this.songs);
    }
}