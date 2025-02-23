package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class TestLibraryView {
	LibraryModel libraryModel = new LibraryModel();
	LibraryView libraryView = new LibraryView(libraryModel);
	
	@Test
	void testMain() {
		libraryView.main();
	}
}
