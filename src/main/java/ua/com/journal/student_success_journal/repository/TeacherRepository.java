package ua.com.journal.student_success_journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.journal.student_success_journal.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher getById(Long id);
}
