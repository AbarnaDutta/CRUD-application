// File: UserDAOTest.java
import org.junit.jupiter.api.*;

import com.example.User;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    private static UserDAO userDAO;

    @BeforeAll
    public static void setup() {
        userDAO = new UserDAO();
    }

    @Test
    public void testAddUser() {
        User user = new User(0, "Test User", "test@example.com");
        assertDoesNotThrow(() -> userDAO.addUser(user));
        List<User> users = userDAO.getAllUsers();
        assertFalse(users.isEmpty());
    }

    @Test
    public void testGetUserById() {
        User user = userDAO.getUserById(1);
        assertNotNull(user);
    }

    @Test
    public void testUpdateUser() {
        User user = userDAO.getUserById(1);
        user.setName("Updated Name");
        userDAO.updateUser(user);
        User updatedUser = userDAO.getUserById(1);
        assertEquals("Updated Name", updatedUser.getName());
    }

    @Test
    public void testDeleteUser() {
        userDAO.deleteUser(1);
        User user = userDAO.getUserById(1);
        assertNull(user);
    }
}
