package model;

import java.io.*;
import java.util.*;

import org.mindrot.jbcrypt.BCrypt;

 
public class Users {
    private static final String USERS_FILE = "src/model/users.txt";
    private Map<String, String> userCredentials;

    public Users() {
        this.userCredentials = new HashMap<String, String>();
        loadUsers();
    }
    
    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userCredentials.put(parts[0], parts[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean createUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        userCredentials.put(username, hashedPassword);
        saveUsers();
        File userFile = new File("src/model/" + username + ".txt");
        
        try {
            userFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean authenticateUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return BCrypt.checkpw(password, userCredentials.get(username));
        }
        return false;
    }
    
    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (Map.Entry<String, String> entry : userCredentials.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();  
        }  
    }  
    
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
} 
