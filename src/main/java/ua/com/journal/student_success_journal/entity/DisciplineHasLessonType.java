package ua.com.journal.student_success_journal.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "discipline_has_lesson_type")
public class DisciplineHasLessonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_type_id")
    private LessonType lesson_type;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
}
