package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    //Enregistrer un admin
    String saveAdmin(Admin admin);

    //Afficher tous les admin
    List<Admin> getAllAdmin();

    //Afficher un admin par son id
    Admin getAdmin(String id);

    //MAJ des donnees d'un admin
    String updateAdmin(String id, Admin admin);

    //Suppression de tous les admin
    void deleteAdmin();

    //Suppression d'un admin par id
    void deleteAdminByid(String id);
}
