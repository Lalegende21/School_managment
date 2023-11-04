package SchoolManagment.serviceImpl;

import SchoolManagment.exception.AdminException;
import SchoolManagment.entity.Admin;
import SchoolManagment.repository.AdminRepo;
import SchoolManagment.serviceImpl.service.AdminService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    //Method to save admin
    @Override
    public String saveAdmin(Admin admin) {

        Admin adminEmail = this.adminRepo.findByEmail(admin.getEmail());

        if (adminEmail==null) {
            admin.setCreate_at(LocalDateTime.now());
            this.adminRepo.save(admin);
            return AdminException.SUCCESSFULL;
        }
        else {
            return AdminException.SOMETHING_WENT_WRONG;
        }
    }

    //Method to read all admins
    @Override
    public List<Admin> getAllAdmin() {
        return this.adminRepo.findAll();
    }


    //Method to read admin by id
    @Override
    public Admin getAdmin(String id) {
        Optional<Admin> optionalAdmin = this.adminRepo.findById(id);

        return optionalAdmin.orElseThrow(() -> new RuntimeException("Admin with id "+id+" not found!"));
    }


    //Method to update admin
    @Override
    public String updateAdmin(String id, Admin admin) {

        Admin adminUpdate = this.getAdmin(id);

        if (adminUpdate.getId().equals(admin.getId())) {
            adminUpdate.setFirstname(admin.getFirstname());
            adminUpdate.setLastname(admin.getLastname());
            adminUpdate.setEmail(admin.getEmail());
            adminUpdate.setHash(admin.getHash());
            adminUpdate.setPhoneNumber(admin.getPhoneNumber());
            adminUpdate.setImage(admin.getImage());
            this.adminRepo.save(adminUpdate);
            return AdminException.SUCCESSFULL;
        }
        else {
            return AdminException.SOMETHING_WENT_WRONG;
        }
    }


    //Method to delete all admins
    @Override
    public void deleteAdmin() {
        this.adminRepo.deleteAll();
    }


    //Method to delete admin by id
    @Override
    public void deleteAdminById(String id) {
        this.adminRepo.deleteById(id);
    }
}
