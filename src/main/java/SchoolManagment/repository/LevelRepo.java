package SchoolManagment.repository;

import SchoolManagment.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepo extends JpaRepository<Level, String> {
    Level findByName(String name);
}
