
import java.util.List;

public class UserApp {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Add a new user
        User user1 = new User(0, "John Doe", "john@example.com");
        userDAO.addUser(user1);

        // Get all users
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // Update the first user
        User firstUser = users.get(0);
        firstUser.setName("John Smith");
        firstUser.setEmail("johnsmith@example.com");
        userDAO.updateUser(firstUser);

        // Fetch updated user
        User updatedUser = userDAO.getUserById(firstUser.getId());
        System.out.println("Updated User: " + updatedUser);

        // Delete a user
        userDAO.deleteUser(updatedUser.getId());
        System.out.println("User deleted successfully");
    }
}
