package SchoolManagment.controller;

import SchoolManagment.entity.Admin;
import SchoolManagment.serviceImpl.AdminServiceImpl;
import SchoolManagment.serviceImpl.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "admin")
public class AdminController {

    private AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Admin admin) {
        this.adminService.saveAdmin(admin);
        log.info("Admin enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Admin> getAllAdmin() {
        return this.adminService.getAllAdmin();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Admin getAdmin(@PathVariable Long id) {
        return this.adminService.getAdmin(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        this.adminService.updateAdmin(id, admin);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllAdmin() {
        this.adminService.deleteAdmin();
        log.info("Tous les admin ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteAdmin(@PathVariable Long id) {
        this.adminService.deleteAdminByid(id);
        log.info("Admin supprime avec succes !");
    }

}
