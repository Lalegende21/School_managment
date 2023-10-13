package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.TutorException;
import SchoolManagment.entity.Tutor;
import SchoolManagment.repository.TutorRepo;
import SchoolManagment.serviceImpl.service.TutorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepo tutorRepo;

    public TutorServiceImpl(TutorRepo tutorRepo) {
        this.tutorRepo = tutorRepo;
    }

    @Override
    public String saveTutor(Tutor tutor) {
        Tutor tutorEmail = this.tutorRepo.findByEmail(tutor.getEmail());

        if (tutorEmail == null) {
            tutor.setCreate_at(LocalDateTime.now());
            this.tutorRepo.save(tutor);
            return TutorException.SUCCESSFUL;
        }
        else {
            return TutorException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public List<Tutor> getAllTutor() {
        return this.tutorRepo.findAll();
    }

    @Override
    public Tutor getTutor(String id) {
        Optional<Tutor> optionalTutor = this.tutorRepo.findById(id);
        return optionalTutor.orElseThrow(() -> new RuntimeException(TutorException.DATA_NOT_FOUND));
    }

    @Override
    public String updateTutor(String id, Tutor tutor) {
        Tutor tutorUpdated = this.getTutor(id);

        if (tutorUpdated.getId().equals(tutor.getId())) {
            tutorUpdated.setFullName(tutor.getFullName());
            tutorUpdated.setType(tutor.getType());
            tutorUpdated.setEmail(tutor.getEmail());
            tutorUpdated.setPhoneNumber(tutor.getPhoneNumber());
            this.tutorRepo.save(tutorUpdated);
            return TutorException.SUCCESSFUL;
        }
        else {
            return TutorException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deleteTutor() {
        this.tutorRepo.deleteAll();
    }

    @Override
    public void deleteTutorByid(String id) {
        this.tutorRepo.deleteById(id);
    }
}
