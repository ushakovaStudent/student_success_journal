package ua.com.journal.student_success_journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.journal.student_success_journal.entity.Discipline;
import ua.com.journal.student_success_journal.repository.DisciplineRepository;

import java.util.List;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public void saveDisc(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public List<Discipline> getAllDiscipline() {
        return disciplineRepository.findAll();
    }

    public Discipline getById(Long id) {
        return disciplineRepository.getById(id);
    }
}