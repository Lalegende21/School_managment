package SchoolManagment.controller;

import SchoolManagment.dto.StudentDTO;
import SchoolManagment.entity.Student;
import SchoolManagment.model.StudentMapper;
import SchoolManagment.serviceImpl.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "student")
public class StudentController {

    private final StudentServiceImpl studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentServiceImpl studentService, StudentMapper studentMapper) {

        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.mapDTOToStudent(studentDTO);
        this.studentService.saveStudent(student);
        log.info("Student enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<StudentDTO> getAllStudent() {
        List<Student> students = this.studentService.getAllStudent();
        return students.stream()
                .map(student -> studentMapper.mapStudentToDto(student))
                .collect(Collectors.toList());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public StudentDTO getAdmin(@PathVariable String id) {
        Student student = this.studentService.getStudent(id);

        StudentDTO studentDTO = studentMapper.mapStudentToDto(student);

        return  studentDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.mapDTOToStudent(studentDTO);
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
