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
@Table(name = "disciplines")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long numberOfHours;

    private String lecturer;

    @OneToMany(mappedBy = "discipline")
    private List <DisciplineHasLessonType> disciplineHasLessonTypes;

    @OneToMany(mappedBy = "disciplins")
    private List<Mark> markList;

    @OneToMany(mappedBy = "disciplinies")
    private List<Absence> absenceList;
}
