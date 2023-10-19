package SchoolManagment.repository;

import SchoolManagment.entity.Tutor;
import SchoolManagment.enums.TutorType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepo extends JpaRepository<Tutor, String> {
    Tutor findByEmail(String email);

    Optional<Tutor> findByFullName(String fullName);
}
