package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    //Enregistrer un student
    String saveStudent(Student student);

    //Afficher tous les student
    List<Student> getAllStudent();

    //Afficher un student par son id
    Student getStudent(Long id);

    //MAJ des donnees d'un student
    String updateStudent(Long id, Student student);

    //Suppression de tous les student
    void deleteStudent();

    //Suppression d'un student par id
    void deleteStudentByid(Long id);
}
