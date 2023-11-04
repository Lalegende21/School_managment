package SchoolManagment.controller;

import SchoolManagment.dto.StudentDTO;
import SchoolManagment.entity.Student;
import SchoolManagment.files.CloudinaryServiceImpl;
import SchoolManagment.model.StudentMapper;
import SchoolManagment.serviceImpl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "student")
public class StudentController {

    private final StudentServiceImpl studentService;

    private final CloudinaryServiceImpl cloudinaryService;

    private final StudentMapper studentMapper;



    //Method to save a student
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "saveStudent")
    public String Create(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.mapDTOToStudent(studentDTO);
        this.studentService.saveStudent(student);
        return "Student register successfully!";
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "uploadImage")
    public String uploadImage(@RequestParam("image") MultipartFile file){
        Map data = this.cloudinaryService.upload(file);
        String imageUrl = (String) data.get("secure_url");
        System.out.println(imageUrl);
        return "Image uploading successfully!";
    }



    //Method to insert student with tutor
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/save-with-tutor")
    public String createWithTutor(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.mapDTOToStudent(studentDTO);
        this.studentService.saveStudentWithTutor(student);
        return "Student register successfully!";
    }



    //Method to read all students
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<StudentDTO> getAllStudent() {
        List<Student> students = this.studentService.getAllStudent();
        return students.stream()
                .map(student -> studentMapper.mapStudentToDto(student))
                .collect(Collectors.toList());
    }



    //Method to read student by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public StudentDTO getAdmin(@PathVariable String id) {
        Student student = this.studentService.getStudent(id);

        StudentDTO studentDTO = studentMapper.mapStudentToDto(student);

        return  studentDTO;
    }


    //Method to update student
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.mapDTOToStudent(studentDTO);
        this.studentService.updateStudent(id, student);
        return "Update completed successfully!";
    }

    //Method to delete all students
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllStudent() {
        this.studentService.deleteStudent();
        return "All students have been successfully deleted!";
    }


    //Method to delete student by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteStudent(@PathVariable String id) {
        this.studentService.deleteStudentById(id);
        return "Student deleted successfully!";
    }
}
