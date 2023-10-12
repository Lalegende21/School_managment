package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.SubjectException;
import SchoolManagment.entity.Subject;
import SchoolManagment.repository.SubjectRepo;
import SchoolManagment.serviceImpl.service.SubjectService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepo subjectRepo;

    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

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

    @Override
    public List<Subject> getAllSubject() {
        return this.subjectRepo.findAll();
    }

    @Override
    public Subject getSubject(Long id) {
        Optional<Subject> optionalSubject = this.subjectRepo.findById(id);

        return optionalSubject.orElseThrow(() -> new RuntimeException(SubjectException.DATA_NOT_FOUND));
    }

    @Override
    public String updateSubject(Long id, Subject subject) {
        Subject subjectUpdated = this.getSubject(id);

        if (subjectUpdated.getId() == subject.getId()) {
            subjectUpdated.setName(subject.getName());
            subjectUpdated.setCoeff(subject.getCoeff());
            this.subjectRepo.save(subjectUpdated);
            return SubjectException.SUCCESSFUL;
        }
        else {
            return SubjectException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deleteSubject() {
        this.subjectRepo.deleteAll();
    }

    @Override
    public void deleteSubjectByid(Long id) {
        this.subjectRepo.deleteById(id);
    }
}
