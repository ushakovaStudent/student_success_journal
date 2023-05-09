package ua.com.journal.student_success_journal.entity;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Students {

private Long id;

private String last_name;

private String first_name;

private String middle_name;

private String email;

private int phone;

private Users users;

private Courses courses;

private List<Marks> marks;

private List<Absences> absences;

private List<Total> totalList;

}
