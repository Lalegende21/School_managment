package SchoolManagment.serviceImpl;

import SchoolManagment.exception.SubjectException;
import SchoolManagment.entity.Subject;
import SchoolManagment.repository.SubjectRepo;
import SchoolManagment.serviceImpl.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;


    //Method to save subject
    @Override
    public String saveSubject(Subject subject) {
        Subject subjectName = this.subjectRepo.findByName(subject.getName());

        if (subjectName == null) {
            subject.setCreate_at(LocalDateTime.now());
            this.subjectRepo.save(subject);
            return SubjectException.SUCCESSFUL;
        }
        else {
            return SubjectException.SOMETHING_WENT_WRONG;
        }
    }


    //Method to read all subjects
    @Override
    public List<Subject> getAllSubject() {
        return this.subjectRepo.findAll();
    }


    //Method to read subject by id
    @Override
    public Subject getSubject(String id) {
        Optional<Subject> optionalSubject = this.subjectRepo.findById(id);

        return optionalSubject.orElseThrow(() -> new RuntimeException(SubjectException.DATA_NOT_FOUND));
    }


    //Method to update subject
    @Override
    public String updateSubject(String id, Subject subject) {
        Subject subjectUpdated = this.getSubject(id);

        if (subjectUpdated.getId().equals(subject.getId())) {
            subjectUpdated.setName(subject.getName());
            subjectUpdated.setCoeff(subject.getCoeff());
            this.subjectRepo.save(subjectUpdated);
            return SubjectException.SUCCESSFUL;
        }
        else {
            return SubjectException.SOMETHING_WENT_WRONG;
        }
    }


    //Method to delete all subjects
    @Override
    public void deleteSubject() {
        this.subjectRepo.deleteAll();
    }


    //Method to delete subject by id
    @Override
    public void deleteSubjectById(String id) {
        this.subjectRepo.deleteById(id);
    }
}
