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

public class Users {

    private Long id;

    private String password;

    private Set<Roles> rolesSet;
}
