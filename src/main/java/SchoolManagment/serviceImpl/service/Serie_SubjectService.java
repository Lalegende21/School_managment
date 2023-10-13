package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Serie_Subject;

import java.util.List;

public interface Serie_SubjectService {

    //Enregistrer un serie_subject
    String saveSerie_Subject(Serie_Subject serie_subject);

    //Afficher tous les serie_subject
    List<Serie_Subject> getAllSerie_Subject();

    //Afficher un serie_subject par son id
    Serie_Subject getSerie_Subject(String id);

    //MAJ des donnees d'un serie_subject
    String updateSerie_Subject(String id, Serie_Subject serie_subject);

    //Suppression de tous les serie_subject
    void deleteSerie_Subject();

    //Suppression d'un serie_subject par id
    void deleteSerie_SubjectByid(String id);
}
