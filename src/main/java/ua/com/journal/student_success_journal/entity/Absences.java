package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Absences {

    private Long id;

    private Date dateOfAbsences;

    private String cause;

    private Students students;

    private Disciplines disciplines;


}
