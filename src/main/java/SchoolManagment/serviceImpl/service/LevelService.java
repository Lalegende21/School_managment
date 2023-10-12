package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Level;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LevelService {

    //Enregistrer un salle
    String saveLevel(Level level);

    //Afficher tous les salle
    List<Level> getAllLevel();

    //Afficher un salle par son id
    Level getLevel(Long id);

    //MAJ des donnees d'un salle
    String updateLevel(Long id, Level level);

    //Suppression de tous les salle
    void deleteLevel();

    //Suppression d'un salle par id
    void deleteLevelByid(Long id);
}
