package ua.com.journal.student_success_journal.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Total {

    private String month;

    private Double GPA;

    private Long quantityOfAbsences;

    private Students students;
}
