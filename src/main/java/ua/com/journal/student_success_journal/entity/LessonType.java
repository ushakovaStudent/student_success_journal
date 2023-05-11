package ua.com.journal.student_success_journal.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "lesson_types")
public class LessonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "lesson_type")
    private List <DisciplineHasLessonType> disciplineHasLessonTypeList;
}

