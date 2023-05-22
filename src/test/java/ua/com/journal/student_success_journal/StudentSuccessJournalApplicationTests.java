package ua.com.journal.student_success_journal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.com.journal.student_success_journal.entity.Users;
import ua.com.journal.student_success_journal.repository.UsersRepository;
import ua.com.journal.student_success_journal.service.UserManagerService;

import static org.mockito.Mockito.*;

public class StudentSuccessJournalApplicationTests {

    @Mock
    private UsersRepository userRepository;

    @InjectMocks
    private UserManagerService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveUserStudentToDB_ShouldSaveUserWithRoleStudentAndPasswordEncoded() {

        Users user = new Users();
        user.setUsername("testuser");
        user.setPassword("testpassword");

        userService.saveUserStudentToDB(user);

        verify(userRepository, times(1)).save(user);

        assert user.getRoles().size() == 1;
        assert user.getRoles().iterator().next().getName().equals("ROLE_Student");

        assert new BCryptPasswordEncoder().matches("testpassword", user.getPassword());
    }

    @Test
    public void saveUserTeacherToDB_ShouldSaveUserWithRoleTeacherAndPasswordEncoded() {

        Users user = new Users();
        user.setUsername("testuser");
        user.setPassword("testpassword");

        userService.saveUserTeacherToDB(user);

        verify(userRepository, times(1)).save(user);

        assert user.getRoles().size() == 1;
        assert user.getRoles().iterator().next().getName().equals("ROLE_Teacher");

        assert new BCryptPasswordEncoder().matches("testpassword", user.getPassword());
    }
}