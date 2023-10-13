package SchoolManagment.controller;

import SchoolManagment.entity.Student;
import SchoolManagment.serviceImpl.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Student student) {
        this.studentService.saveStudent(student);
        log.info("Student enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Student> getAllStudent() {
        return this.studentService.getAllStudent();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Student getAdmin(@PathVariable String id) {
        return this.studentService.getStudent(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable String id, @RequestBody Student student) {
        this.studentService.updateStudent(id, student);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllStudent() {
        this.studentService.deleteStudent();
        log.info("Tous les student ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable String id) {
        this.studentService.deleteStudentByid(id);
        log.info("Student supprime avec succes !");
    }
}
