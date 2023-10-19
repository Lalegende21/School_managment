package SchoolManagment.serviceImpl;

import SchoolManagment.dto.StudentDTO;
import SchoolManagment.dto.TutorDTO;
import SchoolManagment.entity.Student;
import SchoolManagment.entity.Tutor;
import SchoolManagment.exception.StudentException;
import SchoolManagment.repository.StudentRepo;
import SchoolManagment.repository.TutorRepo;
import SchoolManagment.serviceImpl.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final TutorRepo tutorRepo;

    private final TutorServiceImpl tutorService;


    //Methode pour save un etudiant
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

    @Transactional
    public void saveStudentWithTutor(Student student) {
        Tutor tutor = student.getTutor();

        if (tutor != null) {
            if (tutor.getId() == null) {
                // Le tuteur n'a pas encore d'ID, donc nous devons vérifier s'il existe déjà
                Optional<Tutor> existingTutor = tutorRepo.findByFullName(tutor.getFullName());

                if (existingTutor.isPresent()) {
                    // Le tuteur existe déjà, nous l'assignons à l'étudiant
                    student.setTutor(existingTutor.get());
                } else {
                    // Le tuteur n'existe pas, nous le créons et l'assignons à l'étudiant
                    UUID newTutorId = UUID.randomUUID();
                    tutor.setId(String.valueOf(newTutorId));
                    tutor.setCreate_at(LocalDateTime.now());
                    tutorRepo.save(tutor);
                    student.setTutor(tutor);
                }
            } else {
                // Le tuteur a déjà un ID, nous supposons qu'il existe déjà
                student.setTutor(tutor);
            }
        }

        student.setCreate_at(LocalDateTime.now());
        studentRepo.save(student);
    }




    //Methode pour lire un etudiant
    @Override
    public List<Student> getAllStudent() {
        return this.studentRepo.findAll();
    }



    //Methode pour lire un etudiant par son id
    @Override
    public Student getStudent(String id) {
        Optional<Student> optionalStudent = this.studentRepo.findById(id);
        return optionalStudent.orElseThrow(() -> new RuntimeException(StudentException.DATA_NOT_FOUND));
    }


    //Methode pour modifier un etudiant
    @Override
    public String updateStudent(String id, Student student) {
        Student studentUpdated = this.getStudent(id);

        if (studentUpdated.getId().equals(student.getId())) {
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



    //Methode pour supprimer un etudiant
    @Override
    public void deleteStudent() {
        this.studentRepo.deleteAll();
    }



    //Methode pour supprimer un etudiant par son id
    @Override
    public void deleteStudentByid(String id) {
        this.studentRepo.deleteById(id);
    }
}
