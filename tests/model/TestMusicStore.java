package model;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestMusicStore {
	MusicStore store = new MusicStore();

	@Test
	void testGetAlbums() {
		List<Album> albums = store.getAlbumsList();
		for (int i = 0; i < albums.size(); i++) {
			System.out.println(albums.get(i).getTitle());
		}
	}
	
	@Test
	void testGetSongs() {
		List<Song> songs = store.getSongsList();
		for (int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i).getTitle());
		}
	}

}
