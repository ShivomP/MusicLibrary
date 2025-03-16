package view;

import model.Users;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class UserView {
    private Users users;
    private Scanner scanner;
    private String loggedInUser;

    public UserView() { 
        this.users = new Users();
        this.scanner = new Scanner(System.in);
    }

    public void startMenu() {
    	System.out.println("\nWelcome to the Music Library!");
        System.out.println("1. Create Account, enter: 1");
        System.out.println("2. Login, enter: 2");
        System.out.println("3. Exit, enter: 3");
    }
    
     
    private void startRun() {
    	boolean running = true;
    	while(running) {
    		startMenu();
    
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    boolean result = login();
                    if (result) {
                    	loadUserData();
                    }
                    break;
                case "3":
                    System.out.println("Exiting.....");
                    running = false;
					break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
    

    private void createAccount() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.createUser(username, password)) {
            System.out.println("Account created successfully. Please log in.");
        } else {
            System.out.println("Username already exists. Try another one.");
        }
    }

    private boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (users.authenticateUser(username, password)) {
            System.out.println("Login successful");
            this.loggedInUser = username;
            return true;
        } else {
            System.out.println("Invalid username or password. Try again.");
            return false;
        }
    }
    
	private void loadUserData() {
	  try (BufferedReader reader = new BufferedReader(new FileReader("src/model/" + loggedInUser + ".txt"))) {
	      String line;
	      String result = "";
	      while ((line = reader.readLine()) != null) {
	    	  result = result + line + "\n";
	      }
	      System.out.println(result);
	      InputStream originalIn = System.in;
	      ByteArrayInputStream inputStream = new ByteArrayInputStream(result.getBytes());
	      System.setIn(inputStream);
	      LibraryView view = new LibraryView(loggedInUser);
	      view.run();
	      System.setIn(originalIn);
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	}
	    
    public String getLoggedInUser() {
        return loggedInUser;
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.startRun();
    }
} 
