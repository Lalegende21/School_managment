package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    //Save student
    String saveStudent(Student student);


    //read all student
    List<Student> getAllStudent();

    //read student by id
    Student getStudent(String id);

    //Update student
    String updateStudent(String id, Student student);

    //Delete all student
    void deleteStudent();

    //Delete student by id
    void deleteStudentById(String id);
}
