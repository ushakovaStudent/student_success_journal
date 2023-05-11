package ua.com.journal.student_success_journal.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "total")
public class Total {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;

    private Double GPA;

    private Long quantityOfAbsences;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentes;
}
