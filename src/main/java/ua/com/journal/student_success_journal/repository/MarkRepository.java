package ua.com.journal.student_success_journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.journal.student_success_journal.entity.Mark;
import ua.com.journal.student_success_journal.entity.Student;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> getAllByStudentIn(List<Student> studentList);

    List<Mark> findAllByStudent(Student student);

    List<Mark> getAllByDisciplineId(Long id);
}
