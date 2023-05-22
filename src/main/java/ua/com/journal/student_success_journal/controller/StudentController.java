package ua.com.journal.student_success_journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.journal.student_success_journal.bl.AverageMark;
import ua.com.journal.student_success_journal.entity.*;
import ua.com.journal.student_success_journal.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final UserManagerService userManagerService;
    private final MarkService markService;
    private final AbsenceService absenceService;
    private final DisciplineService disciplineService;

    @Autowired
    public StudentController(StudentService studentService, UserManagerService userManagerService, MarkService markService, AbsenceService absenceService, DisciplineService disciplineService) {
        this.studentService = studentService;
        this.userManagerService = userManagerService;
        this.markService = markService;
        this.absenceService = absenceService;
        this.disciplineService = disciplineService;
    }

    @GetMapping("/student")
    public String getPageStudent(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = userManagerService.loadUserByUsername(authentication.getName());
        Student student = studentService.getById(users.getId());

        List<Mark> markList = markService.getByOneStudentIn(student);

        List<AverageMark> averageMarks = new ArrayList<>();

        Map<Discipline, List<Mark>> marksByDiscipline = markList.stream()
                .filter(mark -> mark.getMark() > 0)
                .collect(Collectors.groupingBy(Mark::getDiscipline));

        for (Map.Entry<Discipline, List<Mark>> entry : marksByDiscipline.entrySet()) {
            Discipline discipline = entry.getKey();
            List<Mark> marks = entry.getValue();

            double averageMark = marks.stream()
                    .mapToDouble(Mark::getMark)
                    .average()
                    .orElse(0.0);

            AverageMark averageMarkObject = new AverageMark(discipline, averageMark);
            averageMarks.add(averageMarkObject);
        }

        model.addAttribute("students", student);
        model.addAttribute("marksStudent", markList);
        model.addAttribute("averageMarks", averageMarks);

        return "student";
    }

    @GetMapping("/absence")
    public String getPageAbsence(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = userManagerService.loadUserByUsername(authentication.getName());
        Student student = studentService.getById(users.getId());

        model.addAttribute( "absence", absenceService.getAllByStudent(student));
        model.addAttribute("discList", disciplineService.getAllDiscipline());

        return "absence";
    }

    @PostMapping("/addAbsence")
    public String addAbsence(@RequestParam("dateAbsence") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateAbsence,
                             @RequestParam("cause") String cause,
                             @RequestParam("discipline") Long disc){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = userManagerService.loadUserByUsername(authentication.getName());
        Student student = studentService.getById(users.getId());

        Absence absence = new Absence();

        absence.setStudent(student);
        absence.setCause(cause);
        absence.setDateOfAbsences(dateAbsence);
        absence.setDiscipline(disciplineService.getById(disc));

        absenceService.saveAbsence(absence);

        return "redirect:/absence";
    }
}
