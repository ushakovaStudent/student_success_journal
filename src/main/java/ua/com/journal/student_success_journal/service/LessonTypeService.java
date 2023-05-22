package ua.com.journal.student_success_journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.journal.student_success_journal.entity.LessonType;
import ua.com.journal.student_success_journal.repository.LessonTypeRepository;

import java.util.List;

@Service
public class LessonTypeService {
    private final LessonTypeRepository lessonTypeRepository;

    @Autowired
    public LessonTypeService(LessonTypeRepository lessonTypeRepository) {
        this.lessonTypeRepository = lessonTypeRepository;
    }

    public List<LessonType> getAllLessonType() {
        return lessonTypeRepository.findAll();
    }

    public LessonType getById(Long id) {
        return lessonTypeRepository.getById(id);
    }
}
