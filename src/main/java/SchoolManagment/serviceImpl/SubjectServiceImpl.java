package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.SubjectException;
import SchoolManagment.entity.Subject;
import SchoolManagment.repository.SubjectRepo;
import SchoolManagment.serviceImpl.service.SubjectService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepo subjectRepo;

    @Override
    public String saveSubject(Subject subject) {
        Subject subjectName = this.subjectRepo.findByName(subject.getName());

        if (subjectName == null) {
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
    public Subject getSubject(String id) {
        Optional<Subject> optionalSubject = this.subjectRepo.findById(id);

        return optionalSubject.orElseThrow(() -> new RuntimeException(SubjectException.DATA_NOT_FOUND));
    }

    @Override
    public String updateSubject(String id, Subject subject) {
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
    public void deleteSubjectByid(String id) {
        this.subjectRepo.deleteById(id);
    }
}
