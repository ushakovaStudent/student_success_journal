package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Course {

    private Long id;

    private Long number;

    private List<Group> groupsList;
}