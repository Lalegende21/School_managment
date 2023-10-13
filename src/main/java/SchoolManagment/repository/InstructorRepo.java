package SchoolManagment.repository;

import SchoolManagment.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, String> {
    Instructor findByEmail(String email);
}
