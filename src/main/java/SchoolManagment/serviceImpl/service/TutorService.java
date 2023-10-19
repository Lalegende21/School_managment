package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Tutor;

import java.util.List;

public interface TutorService {

    //Enregistrer un tutor
    String saveTutor(Tutor tutor);

    //Afficher tous les tutor
    List<Tutor> getAllTutor();

    //Afficher un tutor par son id
    Tutor getTutor(String id);

    //MAJ des donnees d'un tutor
    String updateTutor(String id, Tutor tutor);

    //Suppression de tous les tutor
    void deleteTutor();

    //Suppression d'un tutor par id
    void deleteTutorByid(String id);

}
