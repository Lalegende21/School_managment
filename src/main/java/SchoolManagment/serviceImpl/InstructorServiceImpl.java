package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.InstructorException;
import SchoolManagment.entity.Instructor;
import SchoolManagment.repository.InstructorRepo;
import SchoolManagment.serviceImpl.service.InstructorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;


@NoArgsConstructor
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepo instructorRepo;

    @Override
    public String saveInstructor(Instructor instructor) {
        Instructor instructorEmail = this.instructorRepo.findByEmail(instructor.getEmail());
        Instructor instructorPhone = this.instructorRepo.findByPhone(instructor.getPhonenumber());

        if (instructorEmail==null && instructorPhone==null){
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

        if (instructorUpdated.getId() == instructor.getId()) {
            instructorUpdated.setFirstname(instructor.getFirstname());
            instructorUpdated.setLastname(instructor.getLastname());
            instructorUpdated.setEmail(instructor.getEmail());
            instructorUpdated.setCNI(instructor.getCNI());
            instructorUpdated.setPhonenumber(instructor.getPhonenumber());
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
