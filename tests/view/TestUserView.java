package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import view.*;

class TestUserView {
    InputStream originalIn = System.in;
    String command;
    ByteArrayInputStream inputStream;
    
    @AfterEach 
    void cleanUp() {
    	System.setIn(originalIn);
    }
    
    
	@Test
	void testCreateAccount() {
    	command = "1\n"
    			+ "shivom\n"
    			+ "12\n"
    			+ "1\n"
    			+ "new\n"
    			+ "user\n"
    			+ "3\n";
    	inputStream = new ByteArrayInputStream(command.getBytes());
    	System.setIn(inputStream);
    	UserView.main(null);
	}
	
	@Test
	void testLogin() {
		command = "2\n"
				+ "shivom\n"
				+ "123\n"
				+ "3\n";
		inputStream = new ByteArrayInputStream(command.getBytes());
		System.setIn(inputStream);
		UserView.main(null);
	}

}
