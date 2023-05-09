package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Marks {

    private Long id;

    private Date dateOfMarks;

    private Long grade;

    private Students students;

    private Disciplines disciplines;
}