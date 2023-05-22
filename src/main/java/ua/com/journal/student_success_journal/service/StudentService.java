package ua.com.journal.student_success_journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.journal.student_success_journal.entity.Group;
import ua.com.journal.student_success_journal.entity.Student;
import ua.com.journal.student_success_journal.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    public List<Student> getAllStudentByGroup(Group group) {
        return studentRepository.getAllByGroup(group);
    }
}
