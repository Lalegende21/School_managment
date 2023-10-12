package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {

    //Enregistrer un admin
    String saveInstructor(Instructor instructor);

    //Afficher tous les admin
    List<Instructor> getAllInstructor();

    //Afficher un Instructor par son id
    Instructor getInstructor(Long id);

    //MAJ des donnees d'un Instructor
    String updateInstructor(Long id, Instructor instructor);

    //Suppression de tous les Instructor
    void deleteInstructor();

    //Suppression d'un Instructor par id
    void deleteInstructorByid(Long id);
}
