package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LessonType {

    private Long id;

    private String name;

    private String description;

    private List <DisciplinesHasLessonType> disciplinesHasLessonTypeList;
}

