package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.SerieException;
import SchoolManagment.entity.Serie;
import SchoolManagment.repository.SerieRepo;
import SchoolManagment.serviceImpl.service.SerieService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SerieServiceImpl implements SerieService {

    private SerieRepo serieRepo;

    public SerieServiceImpl(SerieRepo serieRepo) {
        this.serieRepo = serieRepo;
    }

    @Override
    public String saveSerie(Serie serie) {
        Serie serieName = this.serieRepo.findByName(serie.getName());

        if (serieName == null) {
            serie.setCreate_at(LocalDateTime.now());
            this.serieRepo.save(serieName);
            return SerieException.SUCCESSFUL;
        }
        else {
            return SerieException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public List<Serie> getAllSerie() {
        return this.serieRepo.findAll();
    }

    @Override
    public Serie getSerie(Long id) {
        Optional<Serie> optionalSerie = this.serieRepo.findById(id);
        return optionalSerie.orElseThrow(() -> new RuntimeException(SerieException.DATA_NOT_FOUND));
    }

    @Override
    public String updateSerie(Long id, Serie serie) {
        Serie serieUpdated = this.getSerie(id);

        if (serieUpdated.getId() == serie.getId()) {
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
    public void deleteSerieByid(Long id) {
        this.serieRepo.deleteById(id);
    }
}
