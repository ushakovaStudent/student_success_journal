package ua.com.journal.student_success_journal.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DisciplineHasLessonType {

    private Long id;

    private LessonType lessonType;

    private Discipline disciplines;
}
