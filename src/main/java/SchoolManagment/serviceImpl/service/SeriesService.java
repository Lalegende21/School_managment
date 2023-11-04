package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Serie;

import java.util.List;

public interface SeriesService {

    //Save series
    String saveSeries(Serie serie);

    //Read all series
    List<Serie> getAllSeries();

    //Read series by id
    Serie getSeries(String id);

    //Update series
    String updateSeries(String id, Serie serie);

    //Delete all series
    void deleteSeries();

    //Delete series by id
    void deleteSeriesById(String id);
}
