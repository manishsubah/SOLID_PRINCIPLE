// 1. Interface Segregation Principle (ISP)

import java.util.HashMap;
import java.util.Map;

interface UserSignup {
    void signup(String username, String password);
}

interface UserLogin {
    boolean login(String username, String password);
}

// 2. Dependency Inversion Principle (DIP) - Abstraction for user storage
interface UserStorage {
    void saveUser(String username, String password);
    boolean isValidUser(String username, String password);
}

// 3. Single Responsibility Principle (SRP) - Separate responsibilities
class UserStorageInMemory implements UserStorage {
    private Map<String, String> users = new HashMap<>();

    @Override
    public void saveUser(String username, String password) {
        users.put(username, password);
    }

    @Override
    public boolean isValidUser(String username, String password) {
        return password.equals(users.get(username));
    }
}

class UserAuth implements UserSignup, UserLogin {
    private final UserStorage userStorage;

    // Dependency Injection for DIP
    public UserAuth(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public void signup(String username, String password) {
        userStorage.saveUser(username, password);
        System.out.println("User signed up successfully!");
    }

    @Override
    public boolean login(String username, String password) {
        if (userStorage.isValidUser(username, password)) {
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }
}

public class SolidExample {
    public static void main(String[] args) {
        // Storage mechanism
        UserStorage storage = new UserStorageInMemory();

        // Authentication service
        UserAuth auth = new UserAuth(storage);

        // User actions
        auth.signup("manish", "password123");
        auth.login("manish", "password123"); // Successful login
        auth.login("manish", "wrongpassword"); // Failed login
    }
}
