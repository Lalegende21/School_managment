package SchoolManagment.repository;

import SchoolManagment.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, String> {
}
