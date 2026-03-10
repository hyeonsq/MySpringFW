package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {

        // UserService 주입 확인
        assertNotNull(userService);

        // UserRepository 주입 확인
        assertNotNull(userService.getUserRepository());

        // dbType 확인
        assertEquals("MySQL", userService.getUserRepository().getDbType());

        // SecurityService 주입 확인
        assertNotNull(userService.getSecurityService());

        // registerUser 기능 확인
        boolean result = userService.registerUser("hong", "홍길동", "1234");

        assertTrue(result);
    }
}