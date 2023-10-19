package SchoolManagment.serviceImpl;

import SchoolManagment.exception.SerieException;
import SchoolManagment.entity.Serie;
import SchoolManagment.repository.SerieRepo;
import SchoolManagment.serviceImpl.service.SerieService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SerieServiceImpl implements SerieService {

    private final SerieRepo serieRepo;

    public SerieServiceImpl(SerieRepo serieRepo) {
        this.serieRepo = serieRepo;
    }

    @Override
    public String saveSerie(Serie serie) {
            serie.setCreate_at(LocalDateTime.now());
            this.serieRepo.save(serie);
            return SerieException.SUCCESSFUL;
    }

    @Override
    public List<Serie> getAllSerie() {
        return this.serieRepo.findAll();
    }

    @Override
    public Serie getSerie(String id) {
        Optional<Serie> optionalSerie = this.serieRepo.findById(id);
        return optionalSerie.orElseThrow(() -> new RuntimeException(SerieException.DATA_NOT_FOUND));
    }

    @Override
    public String updateSerie(String id, Serie serie) {
        Serie serieUpdated = this.getSerie(id);

        if (serieUpdated.getId().equals(serie.getId())) {
            serieUpdated.setName(serie.getName());
            serieUpdated.setAmount(serie.getAmount());
            serieUpdated.setFirstinstallment(serie.getFirstinstallment());
            serieUpdated.setSecondinstallment(serie.getSecondinstallment());
            this.serieRepo.save(serieUpdated);
            return SerieException.SUCCESSFUL;
        }
        else {
            return SerieException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deleteSerie() {
        this.serieRepo.deleteAll();
    }

    @Override
    public void deleteSerieByid(String id) {
        this.serieRepo.deleteById(id);
    }
}
