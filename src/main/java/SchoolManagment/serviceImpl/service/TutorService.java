package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TutorService {

    //Enregistrer un tutor
    String saveTutor(Tutor tutor);

    //Afficher tous les tutor
    List<Tutor> getAllTutor();

    //Afficher un tutor par son id
    Tutor getTutor(Long id);

    //MAJ des donnees d'un tutor
    String updateTutor(Long id, Tutor tutor);

    //Suppression de tous les tutor
    void deleteTutor();

    //Suppression d'un tutor par id
    void deleteTutorByid(Long id);
}
