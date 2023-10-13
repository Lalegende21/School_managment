package SchoolManagment.repository;

import SchoolManagment.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepo extends JpaRepository<Serie, String> {
    Serie findByName(String name);
}
