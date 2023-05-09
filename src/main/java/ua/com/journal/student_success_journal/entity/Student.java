package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {

    private Long id;

    private String last_name;

    private String first_name;

    private String middle_name;

    private String email;

    private int phone;

    private Users users;

    private Group groups;

    private List<Mark> marks;

    private List<Absence> absences;

    private List<Total> totalList;
}
