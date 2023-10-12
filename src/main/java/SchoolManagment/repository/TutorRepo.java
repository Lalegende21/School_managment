package SchoolManagment.repository;

import SchoolManagment.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepo extends JpaRepository<Tutor, Long> {
    Tutor findByEmail(String email);
}
