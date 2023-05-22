package ua.com.journal.student_success_journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.journal.student_success_journal.entity.*;
import ua.com.journal.student_success_journal.service.*;

@Controller
public class AdministratorController {

    private final UserManagerService userManagerService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final GroupService groupService;
    private final DisciplineService disciplineService;

    @Autowired
    public AdministratorController(UserManagerService userManagerService, StudentService studentService,
                                   TeacherService teacherService, GroupService groupService,
                                   DisciplineService disciplineService) {
        this.userManagerService = userManagerService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.groupService = groupService;
        this.disciplineService = disciplineService;
    }

    @GetMapping("/allStudent")
    public String getPageStudent(Model model) {

        model.addAttribute("students", studentService.getAllStudent());
        model.addAttribute("groups", groupService.getAllGroup());

        return "admStudent";
    }

    @GetMapping("/allTeacher")
    public String getPageTeacher(Model model) {

        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "admTeacher";
    }

    @GetMapping("/addUser")
    public String getUserAdminPage(Model model) {
        model.addAttribute("groups", groupService.getAllGroup());
        model.addAttribute("usersList", userManagerService.getAllUser());
        return "addUser";
    }

    @PostMapping("/addStudent")
    public String addNewStudent(@RequestParam("firstName") String first_name,
                                @RequestParam("LastName") String last_name,
                                @RequestParam("midl_name") String midl_name,
                                @RequestParam("phone") Long phone,
                                @RequestParam("email") String email,
                                @RequestParam("group") Long id,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password

    ) {

        if (userManagerService.getLogicByUser(username)) {
            return "redirect:/addUser";
        }

        Users users = new Users();

        users.setUsername(username);
        users.setPassword(password);
        Users users1 = userManagerService.saveUserStudentToDB(users);


        Student student = new Student();

        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setMiddle_name(midl_name);
        student.setUser(users1);
        student.setGroup(groupService.getById(id));
        student.setPhone(phone);
        student.setEmail(email);

        studentService.saveStudent(student);
        return "redirect:/addUser";
    }

    @PostMapping("/addTeacher")
    public String addNewTeacher(@RequestParam("firstNameTeacher") String first_name,
                                @RequestParam("LastNameTeacher") String last_name,
                                @RequestParam("midl_name_Teacher") String middle_name,
                                @RequestParam("usernameTeacher") String username,
                                @RequestParam("passwordTeacher") String password

    ) {
        if (userManagerService.getLogicByUser(username)) {
            return "redirect:/addUser";
        }

        Users users = new Users();

        users.setUsername(username);
        users.setPassword(password);

        Users users1 = userManagerService.saveUserTeacherToDB(users);


        Teacher teacher = new Teacher();

        teacher.setFirst_name(first_name);
        teacher.setLast_name(last_name);
        teacher.setMiddle_name(middle_name);
        teacher.setUsers(users1);

        teacherService.saveTeacher(teacher);

        return "redirect:/addUser";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") Long id) {

        studentService.deleteStudent(id);
        userManagerService.deleteUser(id);

        return "redirect:/allStudent";
    }

    @PostMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("id") Long id) {

        teacherService.deleteTeacher(id);
        userManagerService.deleteUser(id);

        return "redirect:/allTeacher";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestParam("UpdatedId") Long UpdatedId,
                                @RequestParam("studentId") Long studentId) {

        Student student = studentService.getById(studentId);
        Group group = groupService.getById(UpdatedId);

        student.setGroup(group);

        studentService.saveStudent(student);

        return "redirect:/allStudent";
    }

    @GetMapping("/adminDiscipline")
    public String getPageDiscipline(Model model) {

        model.addAttribute("discList", disciplineService.getAllDiscipline());

        return "admDiscipline";
    }

    @PostMapping("/addDisc")
    public String addNewDiscipline(@RequestParam("nameDisc") String name,
                                   @RequestParam("numberHours") String hours1) {

        int hours = Integer.parseInt(hours1);

        Discipline discipline = new Discipline();
        discipline.setName(name);
        discipline.setNumberOfHours(hours);

        disciplineService.saveDisc(discipline);

        return "redirect:/adminDiscipline";
    }
}