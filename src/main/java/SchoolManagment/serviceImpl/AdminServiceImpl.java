package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.AdminException;
import SchoolManagment.entity.Admin;
import SchoolManagment.repository.AdminRepo;
import SchoolManagment.serviceImpl.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminRepo adminRepo;

    //Methode pour inserer des admin
    @Override
    public String saveAdmin(Admin admin) {

        Admin adminEmail = this.adminRepo.findByEmail(admin.getEmail());
        Admin adminPhone = this.adminRepo.findByPhone(admin.getPhonenumber());

        if (adminEmail==null && adminPhone == null) {
            this.adminRepo.save(admin);
            return AdminException.SUCCESSFULL;
        }
        else {
            return AdminException.SOMETHING_WENT_WRONG;
        }
    }

    //Methode pour afficher tous les admin
    @Override
    public List<Admin> getAllAdmin() {
        return this.adminRepo.findAll();
    }


    //Methode pour afficher un admin grace a son id
    @Override
    public Admin getAdmin(String id) {
        Optional<Admin> optionalAdmin = this.adminRepo.findById(id);

        return optionalAdmin.orElseThrow(() -> new RuntimeException("Admin ayant l'id "+id+" pas trouve!"));
    }


    //Methode pour faire la MAJ d'un admin
    @Override
    public String updateAdmin(String id, Admin admin) {

        Admin adminUpdate = this.getAdmin(id);

        if (adminUpdate.getId() == admin.getId()) {
            adminUpdate.setFirstname(admin.getFirstname());
            adminUpdate.setLastname(admin.getLastname());
            adminUpdate.setEmail(admin.getEmail());
            adminUpdate.setHash(admin.getHash());
            adminUpdate.setPhonenumber(admin.getPhonenumber());
            adminUpdate.setImage(admin.getImage());
            this.adminRepo.save(adminUpdate);
            return AdminException.SUCCESSFULL;
        }
        else {
            return AdminException.SOMETHING_WENT_WRONG;
        }
    }


    //Methode  pour supprimer tous les admin
    @Override
    public void deleteAdmin() {
        this.adminRepo.deleteAll();
    }

    @Override
    public void deleteAdminByid(String id) {
        this.adminRepo.deleteById(id);
    }
}
