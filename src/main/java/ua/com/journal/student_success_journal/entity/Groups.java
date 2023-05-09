package ua.com.journal.student_success_journal.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Groups {

    private Long id;

    private Long number;

    private Courses courses ;
}
