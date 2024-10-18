import java.util.HashMap;

public class UserDataBase {
    private static HashMap<String, String> users = new HashMap<>();
    
    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;  // User already exists
        }
        users.put(username, password);
        return true;
    }
    
    public static boolean loginUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
