package SchoolManagment.serviceImpl;

import SchoolManagment.entity.Student;
import SchoolManagment.entity.Tutor;
import SchoolManagment.exception.StudentException;
import SchoolManagment.mails.EmailService;
import SchoolManagment.repository.StudentRepo;
import SchoolManagment.repository.TutorRepo;
import SchoolManagment.serviceImpl.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final TutorRepo tutorRepo;

    private final EmailService emailService;


    //Method to save student
    @Override
    public String saveStudent(Student student) {
        Student studentMatricule = this.studentRepo.findByMatricule(student.getMatricule());

        if (studentMatricule == null){
                student.setCreate_at(LocalDateTime.now());
                student.generateMatricule();
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
                // Tutor and admin don't get id, so we need to check if it already exists
                Optional<Tutor> existingTutor = tutorRepo.findByFullName(tutor.getFullName());

                if (existingTutor.isPresent()) {
                    // Tutor exist, we assign it to the student
                    student.setTutor(existingTutor.get());
                } else {
                    // Tutor don't exist, we create it and assign it to the student
                    UUID newTutorId = UUID.randomUUID();
                    tutor.setId(String.valueOf(newTutorId));
                    tutor.setCreate_at(LocalDateTime.now());
                    tutorRepo.save(tutor);
                    student.setTutor(tutor);
                }
            } else {
                // Tutor already have an id, we assume that it already exists
                student.setTutor(tutor);
            }
        }

        //Register student
        student.setCreate_at(LocalDateTime.now());
        student.generateMatricule();
        studentRepo.save(student);


        //We send an email //to the tutor
        Tutor tutorEmail = student.getTutor();

        if (tutorEmail != null) {
            if (tutorEmail.getEmail() == null) {
                // Tutor's and admin email is null, we need to find the tutor by id
                Optional<Tutor> existingTutor = tutorRepo.findById(tutorEmail.getId());
                System.out.println(existingTutor);

                if (existingTutor.isPresent()) {
                    // Tutor with the specified id exists, assign it to the student
                    Tutor foundTutor = existingTutor.get();
                    System.out.println(foundTutor);

                    student.setTutor(foundTutor);
                    String tutorMail = foundTutor.getEmail();
                    System.out.println(tutorMail);

                    if (tutorMail != null) {
                        String subject = "Registering a new student!";
                        String message = "Dear " + foundTutor.getFullName() + ",\n\nyour student " +
                                student.getFirstname() + " " + student.getLastname() + " has been successfully registered!";
                        emailService.sendEmail(tutorMail, subject, message);
                        log.info("Message sent successfully!");
                    } else {
                        System.out.println("Tutor email cannot be null!");
                        log.info("Tutor email not found");
                    }
                } else {
                    System.out.println("Tutor not found!");
                    log.info("Tutor not found");
                    log.info("Admin not found");
                }
            } else {
                // Tutor's email is already available, use it to send the email
                String tutorMail = tutorEmail.getEmail();
                System.out.println(tutorMail);

                String subject = "Registering a new student!";
                String message = "Dear " + tutorEmail.getFullName() + ",\n\nyour student " +
                        student.getFirstname() + " " + student.getLastname() + " has been successfully registered!";
                emailService.sendEmail(tutorMail, subject, message);
                log.info("Message sent successfully!");
            }
        } else {
            System.out.println("Tutor is null!");
            log.info("Tutor not found");
            log.info("Admin not found");
        }

    }




    //Method to read student
    @Override
    public List<Student> getAllStudent() {
        return this.studentRepo.findAll();
    }



    //Method to read student by id
    @Override
    public Student getStudent(String id) {
        Optional<Student> optionalStudent = this.studentRepo.findById(id);
        return optionalStudent.orElseThrow(() -> new RuntimeException(StudentException.DATA_NOT_FOUND));
    }


    //Method to update student
    @Override
    public String updateStudent(String id, Student student) {
        Student studentUpdated = this.getStudent(id);

        if (studentUpdated.getId().equals(student.getId())) {
            studentUpdated.setFirstname(student.getFirstname());
            studentUpdated.setLastname(student.getLastname());
            studentUpdated.setDate_of_birth(student.getDate_of_birth());
            this.studentRepo.save(studentUpdated);
            return StudentException.SUCCESSFUL;
        }
        else {
            return StudentException.SOMETHING_WENT_WRONG;
        }
    }



    //Method to delete student
    @Override
    public void deleteStudent() {
        this.studentRepo.deleteAll();
    }



    //Method to delete student by id
    @Override
    public void deleteStudentById(String id) {
        this.studentRepo.deleteById(id);
    }
}
