package ua.com.journal.student_success_journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.journal.student_success_journal.entity.Role;
import ua.com.journal.student_success_journal.entity.Users;
import ua.com.journal.student_success_journal.repository.UsersRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserManagerService implements UserDetailsService {

    private final UsersRepository userRepository;

    @Autowired
    public UserManagerService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean getLogicByUser(String username) {
        return !userRepository.findAllByUsername(username).isEmpty();
    }


    public Users saveUserStudentToDB(Users user) {

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_Student")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    public Users saveUserTeacherToDB(Users user) {

        user.setRoles(Collections.singleton(new Role(2L, "ROLE_Teacher")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user1 = userRepository.findByUsername(username);

        if (user1 == null) {
            throw new UsernameNotFoundException("User not found!!!");
        }

        return user1;
    }

    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}