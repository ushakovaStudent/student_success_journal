package ua.com.journal.student_success_journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.journal.student_success_journal.entity.Mark;
import ua.com.journal.student_success_journal.entity.Student;
import ua.com.journal.student_success_journal.repository.MarkRepository;

import java.util.List;

@Service
public class MarkService {
    private final MarkRepository markRepository;

    @Autowired
    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Mark> getAllByStudentIn(List<Student> studentList) {
        return markRepository.getAllByStudentIn(studentList);
    }

    public void saveMark(Mark mark) {
        markRepository.save(mark);
    }

    public List<Mark> getByOneStudentIn(Student student) {
        return markRepository.findAllByStudent(student);
    }

    public List<Mark> getAllByDisciplineId(Long id){
        return markRepository.getAllByDisciplineId(id);
    }
}
