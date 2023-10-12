package SchoolManagment.repository;

import SchoolManagment.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {
    Instructor findByEmail(String email);
}
