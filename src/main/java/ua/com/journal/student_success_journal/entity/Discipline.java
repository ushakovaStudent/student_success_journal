package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Discipline {

    private Long id;

    private String name;

    private Long numberOfHours;

    private String lecturer;

    private List <DisciplineHasLessonType> disciplinesHasLessonTypeList;

    private List<Mark> marks;

    private List<Absence> absences;
}
