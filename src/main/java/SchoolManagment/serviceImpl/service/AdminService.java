package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Admin;

import java.util.List;

public interface AdminService {

    //Save admin
    String saveAdmin(Admin admin);

    //Read all admins
    List<Admin> getAllAdmin();

    //Read admin by id
    Admin getAdmin(String id);

    //Update admin
    String updateAdmin(String id, Admin admin);

    //Delete all admins
    void deleteAdmin();

    //Delete admin by id
    void deleteAdminById(String id);
}
