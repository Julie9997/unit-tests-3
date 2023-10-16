package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    UserRepository userRepository;
    User adminUser;
    User user1;

    @BeforeEach
    void setup() {
        userRepository = new UserRepository();

        adminUser = new User("admin", "admin", true);
        user1 = new User("user1", "password1", false);

        userRepository.addUser(adminUser);
        userRepository.addUser(user1);

        adminUser.authenticate("admin", "admin");
        user1.authenticate("user1", "password1");
    }

    @Test
    void authenticatedAdminTest() {
        assertTrue(adminUser.isAuthenticate);
    }
    @Test
    void authenticatedUserTest() {
        assertTrue(user1.isAuthenticate);
    }

    @Test
    void logoutUsersAdminTest() {
        userRepository.logoutAllUsers();
        assertTrue(adminUser.isAuthenticate);
    }

    @Test
    void logoutRegularUserTest() {
        userRepository.logoutAllUsers();
        assertFalse(user1.isAuthenticate);
    }
}