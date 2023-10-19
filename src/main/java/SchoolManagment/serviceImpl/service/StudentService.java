package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Student;
import SchoolManagment.entity.Tutor;

import java.util.List;
import java.util.UUID;

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
