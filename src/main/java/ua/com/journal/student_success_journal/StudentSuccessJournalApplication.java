package ua.com.journal.student_success_journal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.com.journal.student_success_journal.entity.*;
import ua.com.journal.student_success_journal.repository.*;

import java.util.Collections;

@SpringBootApplication
public class StudentSuccessJournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSuccessJournalApplication.class, args);
    }

    @Bean
    CommandLineRunner run(DisciplineRepository disciplineRepository, UsersRepository userRepository,
                          RoleRepository roleRepository, GroupRepository groupRepository,
                          LessonTypeRepository lessonTypeRepository) {


        return args -> {
            if (roleRepository.findAll().isEmpty()) {
                roleRepository.save(new Role(1L, "ROLE_Student"));
                roleRepository.save(new Role(2L, "ROLE_Teacher"));
                roleRepository.save(new Role(3L, "ROLE_Admin"));
            }
            if (groupRepository.findAll().isEmpty()) {
                groupRepository.save(new Group(1L, 1, 1));
                groupRepository.save(new Group(2L, 2, 1));
                groupRepository.save(new Group(3L, 1, 2));
                groupRepository.save(new Group(4L, 2, 2));
            }
            if (userRepository.findAll().isEmpty()) {

                Users users = new Users();

                users.setUsername("root");
                users.setRoles(Collections.singleton(new Role(3L, "ROLE_Admin")));
                users.setPassword(new BCryptPasswordEncoder().encode("root"));

                userRepository.save(users);
            }
            if (disciplineRepository.findAll().isEmpty()) {
                disciplineRepository.save(new Discipline(1L, "Культура", 60));
                disciplineRepository.save(new Discipline(2L, "Філософія", 80));
                disciplineRepository.save(new Discipline(3L, "Англійська мова", 55));
            }
            if (lessonTypeRepository.findAll().isEmpty()) {
                lessonTypeRepository.save(new LessonType(1L, "Лекція", " "));
                lessonTypeRepository.save(new LessonType(2L, "Практика", " "));
                lessonTypeRepository.save(new LessonType(3L, "Лабораторне заняття", " "));
            }
        };

    }
}
