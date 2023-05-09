package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Courses{

    private Long id;

    private Long number;

    private List<Groups> groupsList;

    private List<Students> students;
}