package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Payment;
import SchoolManagment.entity.Serie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SerieService {

    //Enregistrer un serie
    String saveSerie(Serie serie);

    //Afficher tous les serie
    List<Serie> getAllSerie();

    //Afficher un serie par son id
    Serie getSerie(Long id);

    //MAJ des donnees d'un serie
    String updateSerie(Long id, Serie serie);

    //Suppression de tous les serie
    void deleteSerie();

    //Suppression d'un serie par id
    void deleteSerieByid(Long id);
}
