package ua.com.journal.student_success_journal.bl;

import lombok.*;
import ua.com.journal.student_success_journal.entity.Discipline;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class AverageMark {
    private Discipline discipline;
    private double average;
}