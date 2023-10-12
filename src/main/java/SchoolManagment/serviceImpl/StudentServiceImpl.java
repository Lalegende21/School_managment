package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.StudentException;
import SchoolManagment.entity.Student;
import SchoolManagment.repository.StudentRepo;
import SchoolManagment.serviceImpl.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public String saveStudent(Student student) {
        Student studentMatricule = this.studentRepo.findByMatricule(student.getMatricule());

        if (studentMatricule == null){
            student.setCreate_at(LocalDateTime.now());
            this.studentRepo.save(student);
            return StudentException.SUCCESSFUL;
        }
        else {
            return StudentException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepo.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> optionalStudent = this.studentRepo.findById(id);
        return optionalStudent.orElseThrow(() -> new RuntimeException(StudentException.DATA_NOT_FOUND));
    }

    @Override
    public String updateStudent(Long id, Student student) {
        Student studentUpdated = this.getStudent(id);

        if (studentUpdated.getId() == student.getId()) {
            studentUpdated.setFirstname(student.getFirstname());
            studentUpdated.setLastname(student.getLastname());
            studentUpdated.setDate_of_birth(student.getDate_of_birth());
            studentUpdated.setImage(student.getImage());
            this.studentRepo.save(studentUpdated);
            return StudentException.SUCCESSFUL;
        }
        else {
            return StudentException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deleteStudent() {
        this.studentRepo.deleteAll();
    }

    @Override
    public void deleteStudentByid(Long id) {
        this.studentRepo.deleteById(id);
    }
}
