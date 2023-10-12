package SchoolManagment.repository;

import SchoolManagment.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepo extends JpaRepository<Serie, Long> {
    Serie findByName(String name);
}
