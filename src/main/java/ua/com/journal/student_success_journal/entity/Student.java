package ua.com.journal.student_success_journal.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String last_name;

    private String first_name;

    private String middle_name;

    private String email;

    private int phone;


    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    @OneToMany(mappedBy = "studenties")
    private List<Absence> absences;

    @OneToMany(mappedBy = "studentes")
    private List<Total> totalList;
}
