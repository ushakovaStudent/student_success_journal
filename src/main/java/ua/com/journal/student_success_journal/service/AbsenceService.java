package ua.com.journal.student_success_journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.journal.student_success_journal.entity.Absence;
import ua.com.journal.student_success_journal.entity.Student;
import ua.com.journal.student_success_journal.repository.AbsenceRepository;

import java.util.List;

@Service
public class AbsenceService {
    private final AbsenceRepository absenceRepository;

    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public void saveAbsence(Absence absence){
        absenceRepository.save(absence);
    }

    public List<Absence> getAllByStudent(Student student){
        return absenceRepository.getAllByStudent(student);
    }
}
