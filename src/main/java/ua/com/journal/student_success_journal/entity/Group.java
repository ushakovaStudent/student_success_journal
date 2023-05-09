package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Group {

    private Long id;

    private Long number;

    private Course courses ;

    private List<Student> students;
}
