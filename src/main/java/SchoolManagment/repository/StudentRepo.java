package SchoolManagment.repository;

import SchoolManagment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByMatricule(String matricule);
}
