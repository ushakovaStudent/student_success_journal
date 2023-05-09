package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Mark {

    private Long id;

    private Date dateOfMarks;

    private Long grade;

    private Student students;

    private Discipline disciplines;
}