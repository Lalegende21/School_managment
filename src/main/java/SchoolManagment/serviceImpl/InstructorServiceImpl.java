package SchoolManagment.serviceImpl;

import SchoolManagment.exception.InstructorException;
import SchoolManagment.entity.Instructor;
import SchoolManagment.repository.InstructorRepo;
import SchoolManagment.serviceImpl.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepo instructorRepo;



    //Method to save instructor
    @Override
    public String saveInstructor(Instructor instructor) {
        Instructor instructorEmail = this.instructorRepo.findByEmail(instructor.getEmail());

        if (instructorEmail==null){
            instructor.setCreate_at(LocalDateTime.now());
            this.instructorRepo.save(instructor);
            return InstructorException.SUCCESSFUL;
        }
        else {
            return InstructorException.DATA_NOT_FOUND;
        }
    }


    //Method to read all instructors
    @Override
    public List<Instructor> getAllInstructor() {
        return this.instructorRepo.findAll();
    }


    //Method to read instructor by id
    @Override
    public Instructor getInstructor(String id) {
        Optional<Instructor> optionalInstructor = this.instructorRepo.findById(id);

        return optionalInstructor.orElseThrow(() -> new RuntimeException("Instructor with id "+id+" not found!"));
    }


    //Method to update instructor
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


    //Method to delete all instructors
    @Override
    public void deleteInstructor() {
        this.instructorRepo.deleteAll();
    }


    //Method to delete instructor by id
    @Override
    public void deleteInstructorById(String id) {
        this.instructorRepo.deleteById(id);
    }
}
