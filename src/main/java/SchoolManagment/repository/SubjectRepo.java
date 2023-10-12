package SchoolManagment.repository;

import SchoolManagment.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
}
