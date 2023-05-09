package ua.com.journal.student_success_journal.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Roles {

    private Long id;

    private String name;

    private Set<Users> usersSet;
}
