package SchoolManagment.repository;

import SchoolManagment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepo extends JpaRepository<Student, String> {
    Student findByMatricule(String matricule);
}
