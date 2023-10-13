package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Serie;

import java.util.List;

public interface SerieService {

    //Enregistrer un serie
    String saveSerie(Serie serie);

    //Afficher tous les serie
    List<Serie> getAllSerie();

    //Afficher un serie par son id
    Serie getSerie(String id);

    //MAJ des donnees d'un serie
    String updateSerie(String id, Serie serie);

    //Suppression de tous les serie
    void deleteSerie();

    //Suppression d'un serie par id
    void deleteSerieByid(String id);
}
