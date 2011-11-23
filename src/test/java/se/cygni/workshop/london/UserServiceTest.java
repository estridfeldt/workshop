package se.cygni.workshop.london;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void shouldReturnUserFromId() {
        //fixtures
        int userId = 1;
        User user = new User();

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.getUserById(userId)).thenReturn(user);

        UserService target = new UserServiceImpl(userRepository);

        //test
        User result = target.getUser(userId);

        //assert
        assertEquals(user, result);
    }
}
