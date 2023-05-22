package ua.com.journal.student_success_journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.journal.student_success_journal.entity.Users;

import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

    List<Users> findAllByUsername(String username);
}
