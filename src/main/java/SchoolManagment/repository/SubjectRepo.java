package SchoolManagment.repository;

import SchoolManagment.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, String> {
    Subject findByName(String name);
}
