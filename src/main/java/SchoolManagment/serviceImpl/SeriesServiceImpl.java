package SchoolManagment.serviceImpl;

import SchoolManagment.exception.SerieException;
import SchoolManagment.entity.Serie;
import SchoolManagment.repository.SerieRepo;
import SchoolManagment.serviceImpl.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SerieRepo serieRepo;


    //Method to save series
    @Override
    public String saveSeries(Serie serie) {
            serie.setCreate_at(LocalDateTime.now());
            this.serieRepo.save(serie);
            return SerieException.SUCCESSFUL;
    }


    //Method to read all series
    @Override
    public List<Serie> getAllSeries() {
        return this.serieRepo.findAll();
    }



    //Method to read series by id
    @Override
    public Serie getSeries(String id) {
        Optional<Serie> optionalSeries = this.serieRepo.findById(id);
        return optionalSeries.orElseThrow(() -> new RuntimeException(SerieException.DATA_NOT_FOUND));
    }


    //Method to update series
    @Override
    public String updateSeries(String id, Serie serie) {
        Serie seriesUpdated = this.getSeries(id);

        if (seriesUpdated.getId().equals(serie.getId())) {
            seriesUpdated.setName(serie.getName());
            seriesUpdated.setAmount(serie.getAmount());
            seriesUpdated.setFirstinstallment(serie.getFirstinstallment());
            seriesUpdated.setSecondinstallment(serie.getSecondinstallment());
            this.serieRepo.save(seriesUpdated);
            return SerieException.SUCCESSFUL;
        }
        else {
            return SerieException.SOMETHING_WENT_WRONG;
        }
    }


    //Method to delete all series
    @Override
    public void deleteSeries() {
        this.serieRepo.deleteAll();
    }


    //Method to delete series by id
    @Override
    public void deleteSeriesById(String id) {
        this.serieRepo.deleteById(id);
    }
}
