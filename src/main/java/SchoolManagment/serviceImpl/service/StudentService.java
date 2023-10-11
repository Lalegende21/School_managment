package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Serie;
import SchoolManagment.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    //Enregistrer un student
    String saveStudent(Student student);

    //Afficher tous les student
    List<Student> getAllStudent();

    //Afficher un student par son id
    Student getStudent(String id);

    //MAJ des donnees d'un student
    String updateStudent(String id, Student student);

    //Suppression de tous les student
    void deleteStudent();

    //Suppression d'un student par id
    void deleteStudentByid(String id);
}
