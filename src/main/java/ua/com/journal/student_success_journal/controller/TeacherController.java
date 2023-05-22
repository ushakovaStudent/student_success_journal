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
import ua.com.journal.student_success_journal.entity.Discipline;
import ua.com.journal.student_success_journal.entity.Mark;
import ua.com.journal.student_success_journal.entity.Student;
import ua.com.journal.student_success_journal.entity.Teacher;
import ua.com.journal.student_success_journal.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class TeacherController {

    private final TeacherService teacherService;
    private final UserManagerService userManagerService;
    private final DisciplineService disciplineService;
    private final GroupService groupService;
    private final StudentService studentService;
    private final MarkService markService;
    private final LessonTypeService lessonTypeService;

    @Autowired
    public TeacherController(TeacherService teacherService, UserManagerService userManagerService,
                             DisciplineService disciplineService, GroupService groupService,
                             StudentService studentService, MarkService markService, LessonTypeService lessonTypeService) {
        this.teacherService = teacherService;
        this.userManagerService = userManagerService;
        this.disciplineService = disciplineService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.markService = markService;
        this.lessonTypeService = lessonTypeService;
    }

    @GetMapping("/teacher")
    public String getTeacher(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Teacher teacher =
                teacherService.getTeacherById(
                        userManagerService.loadUserByUsername(authentication.getName()).getId());

        model.addAttribute("teacher", teacher);

        return "teacher";
    }

    @GetMapping("/group")
    public String getPageGroupById(@RequestParam("id") Long id,
                                   Model model) {

        List<Student> studentList = studentService.getAllStudentByGroup(groupService.getById(id));

        model.addAttribute("disciplines", disciplineService.getAllDiscipline());
        model.addAttribute("students", studentList);
        model.addAttribute("marks", markService.getAllByStudentIn(studentList));
        model.addAttribute("lessonType", lessonTypeService.getAllLessonType());

        return "group";
    }

    @GetMapping("/Groups")
    public String getAllGroup(Model model) {

        model.addAttribute("group", groupService.getAllGroup());

        return "groups";
    }

    @PostMapping("/addMark")
    public String addNewStudDisc(@RequestParam("mark") int mark,
                                 @RequestParam("dateMark") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateMark,
                                 @RequestParam("typeLesson") Long typeLesson,
                                 @RequestParam("student") Long student,
                                 @RequestParam("discipline") Long discipline,
                                 @RequestParam("truancy") boolean truancy) {

        Mark mark1 = new Mark();
        mark1.setMark(mark);
        mark1.setDateOfMarks(dateMark);
        mark1.setLesson_type(lessonTypeService.getById(typeLesson));
        mark1.setStudent(studentService.getById(student));
        mark1.setDiscipline(disciplineService.getById(discipline));
        mark1.setTruancy(truancy);

        markService.saveMark(mark1);

        return "redirect:/Groups";
    }

    @GetMapping("/studentDetail")
    public String studentDetail(@RequestParam("studentId") Long id, Model model) {
        Student student = studentService.getById(id);

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

        model.addAttribute("student", student);
        model.addAttribute("marksStudent", markList);

        model.addAttribute("averageMarks", averageMarks);

        return "studentDetail";
    }

    @GetMapping("/disciplines")
    public String getPageDiscipline(Model model) {

        model.addAttribute("discipline", disciplineService.getAllDiscipline());

        return "disciplines";
    }

    @GetMapping("/seeDisc")
    public String seeOneDiscInfo(@RequestParam("id") Long id,
                                 Model model){

        model.addAttribute("marks", markService.getAllByDisciplineId(id));

        return "seeOneDisc";
    }
}