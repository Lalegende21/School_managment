package SchoolManagment.repository;

import SchoolManagment.entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepo extends JpaRepository<Validation, String> {

    Optional<Validation> findByCode(String code);
}
