package SchoolManagment.repository;

import SchoolManagment.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, String> {
    Admin findByEmail(String email);

    Admin findByPhone(String phonenumber);
}
