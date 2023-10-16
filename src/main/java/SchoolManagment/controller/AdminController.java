package SchoolManagment.controller;

import SchoolManagment.dto.AdminDTO;
import SchoolManagment.entity.Admin;
import SchoolManagment.model.AdminMapper;
import SchoolManagment.serviceImpl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(path = "admin")
public class AdminController {

    private final AdminServiceImpl adminService;
    private final AdminMapper adminMapper;

    public AdminController(AdminServiceImpl adminService, AdminMapper adminMapper) {
        this.adminService = adminService;
        this.adminMapper = adminMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody AdminDTO adminDTO) {
        Admin admin = adminMapper.mapDTOToAdmin(adminDTO);
        this.adminService.saveAdmin(admin);
        log.info("Admin enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<AdminDTO> getAllAdmin() {
        List<Admin> admins = this.adminService.getAllAdmin();
        return admins.stream()
                .map(admin -> adminMapper.mapAdminToDTO(admin))
                .collect(Collectors.toList());
//        return this.adminService.getAllAdmin();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public AdminDTO getAdmin(@PathVariable String id) {
        Admin admin = this.adminService.getAdmin(id);

        AdminDTO adminDTO = adminMapper.mapAdminToDTO(admin);

        return adminDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateAdmin(@PathVariable String id, @RequestBody AdminDTO adminDTO) {
        Admin admin = adminMapper.mapDTOToAdmin(adminDTO);
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
    public void deleteAdmin(@PathVariable String id) {
        this.adminService.deleteAdminByid(id);
        log.info("Admin supprime avec succes !");
    }

}
