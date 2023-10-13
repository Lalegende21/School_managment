package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Instructor;

import java.util.List;

public interface InstructorService {

    //Enregistrer un admin
    String saveInstructor(Instructor instructor);

    //Afficher tous les admin
    List<Instructor> getAllInstructor();

    //Afficher un Instructor par son id
    Instructor getInstructor(String id);

    //MAJ des donnees d'un Instructor
    String updateInstructor(String id, Instructor instructor);

    //Suppression de tous les Instructor
    void deleteInstructor();

    //Suppression d'un Instructor par id
    void deleteInstructorByid(String id);
}
