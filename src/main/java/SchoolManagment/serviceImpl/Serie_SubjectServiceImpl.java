package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.Serie_SubjectException;
import SchoolManagment.entity.Serie_Subject;
import SchoolManagment.repository.Serie_SubjectRepo;
import SchoolManagment.serviceImpl.service.Serie_SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Serie_SubjectServiceImpl implements Serie_SubjectService {

    private final Serie_SubjectRepo serie_subjectRepo;

    public Serie_SubjectServiceImpl(Serie_SubjectRepo serie_subjectRepo) {
        this.serie_subjectRepo = serie_subjectRepo;
    }

    @Override
    public String saveSerie_Subject(Serie_Subject serie_subject) {
        this.serie_subjectRepo.save(serie_subject);
        return Serie_SubjectException.SUCCESSFUL;
    }

    @Override
    public List<Serie_Subject> getAllSerie_Subject() {
        return this.serie_subjectRepo.findAll();
    }

    @Override
    public Serie_Subject getSerie_Subject(String id) {
        Optional<Serie_Subject> optionalSerie_subject = this.serie_subjectRepo.findById(id);
        return optionalSerie_subject.orElseThrow(() -> new RuntimeException(Serie_SubjectException.DATA_NOT_FOUND));
    }

    @Override
    public String updateSerie_Subject(String id, Serie_Subject serie_subject) {
        Serie_Subject serie_subjectUpdate = this.getSerie_Subject(id);

        if (serie_subjectUpdate.getId().equals(serie_subject.getId())) {
            serie_subjectUpdate.setSubject(serie_subject.getSubject());
            serie_subjectUpdate.setSerie(serie_subject.getSerie());
            this.serie_subjectRepo.save(serie_subjectUpdate);
            return Serie_SubjectException.SUCCESSFUL;
        }
        return Serie_SubjectException.SOMETHING_WENT_WRONG;
    }

    @Override
    public void deleteSerie_Subject() {
        this.serie_subjectRepo.deleteAll();
    }

    @Override
    public void deleteSerie_SubjectByid(String id) {
        this.serie_subjectRepo.deleteById(id);
    }
}
