package ua.com.journal.student_success_journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.journal.student_success_journal.entity.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {}
