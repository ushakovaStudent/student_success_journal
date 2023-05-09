package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Absence {

    private Long id;

    private Date dateOfAbsences;

    private String cause;

    private Student students;

    private Discipline disciplines;


}
