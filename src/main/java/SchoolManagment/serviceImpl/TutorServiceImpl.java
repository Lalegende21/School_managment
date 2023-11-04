package SchoolManagment.serviceImpl;

import SchoolManagment.exception.TutorException;
import SchoolManagment.entity.Tutor;
import SchoolManagment.repository.TutorRepo;
import SchoolManagment.serviceImpl.service.TutorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TutorServiceImpl implements TutorService {

    private final TutorRepo tutorRepo;


    //Method to save tutor
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


    //Method to read all tutor
    @Override
    public List<Tutor> getAllTutor() {
        return this.tutorRepo.findAll();
    }


    //Method to read tutor by id
    @Override
    public Tutor getTutor(String id) {
        Optional<Tutor> optionalTutor = this.tutorRepo.findById(id);
        return optionalTutor.orElseThrow(() -> new RuntimeException(TutorException.DATA_NOT_FOUND));
    }


    //Method to update
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


    //Method to delete all tutors
    @Override
    public void deleteTutor() {
        this.tutorRepo.deleteAll();
    }


    //Method to delete tutor by id
    @Override
    public void deleteTutorById(String id) {
        this.tutorRepo.deleteById(id);
    }
}
