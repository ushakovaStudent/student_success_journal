package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Disciplines {

    private Long id;

    private String name;

    private Long numberOfHours;

    private String lecturer;

    private List <DisciplinesHasLessonType> disciplinesHasLessonTypeList;

    private List<Marks> marks;

    private List<Absences> absences;
}
