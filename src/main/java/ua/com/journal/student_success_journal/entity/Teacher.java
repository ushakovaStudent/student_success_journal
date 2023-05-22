package ua.com.journal.student_success_journal.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String last_name;

    private String first_name;

    private String middle_name;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users users;
}
