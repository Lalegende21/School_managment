package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.InstructorException;
import SchoolManagment.entity.Instructor;
import SchoolManagment.repository.InstructorRepo;
import SchoolManagment.serviceImpl.service.InstructorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepo instructorRepo;

    public InstructorServiceImpl(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public String saveInstructor(Instructor instructor) {
        Instructor instructorEmail = this.instructorRepo.findByEmail(instructor.getEmail());

        if (instructorEmail==null){
            instructor.setCreate_at(LocalDateTime.now());
            this.instructorRepo.save(instructor);
            return InstructorException.SUCCESSFUL;
        }
        else {
            return InstructorException.INVALID_DATA;
        }
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return this.instructorRepo.findAll();
    }

    @Override
    public Instructor getInstructor(String id) {
        Optional<Instructor> optionalInstructor = this.instructorRepo.findById(id);

        return optionalInstructor.orElseThrow(() -> new RuntimeException("Admin ayant l'id "+id+" pas trouve!"));
    }

    @Override
    public String updateInstructor(String id, Instructor instructor) {
        Instructor instructorUpdated = this.getInstructor(id);

        if (instructorUpdated.getId().equals(instructor.getId())) {
            instructorUpdated.setFirstname(instructor.getFirstname());
            instructorUpdated.setLastname(instructor.getLastname());
            instructorUpdated.setEmail(instructor.getEmail());
            instructorUpdated.setCNI(instructor.getCNI());
            instructorUpdated.setPhoneNumber(instructor.getPhoneNumber());
            instructorUpdated.setImage(instructor.getImage());
            this.instructorRepo.save(instructor);
            return InstructorException.SUCCESSFUL;
        }
        else {
            return InstructorException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deleteInstructor() {
        this.instructorRepo.deleteAll();
    }

    @Override
    public void deleteInstructorByid(String id) {
        this.instructorRepo.deleteById(id);
    }
}
