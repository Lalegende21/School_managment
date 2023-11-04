package SchoolManagment.controller;

import SchoolManagment.dto.AdminDTO;
import SchoolManagment.entity.Admin;
import SchoolManagment.model.AdminMapper;
import SchoolManagment.serviceImpl.AdminServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "admin")
public class AdminController {

    private final AdminServiceImpl adminService;
    private final AdminMapper adminMapper;



    //Method to save a admin
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody AdminDTO adminDTO) {
        Admin admin = adminMapper.mapDTOToAdmin(adminDTO);
        this.adminService.saveAdmin(admin);
        return "Admin register successfully!";
    }


    //Method to read all admins
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<AdminDTO> getAllAdmin() {
        List<Admin> admins = this.adminService.getAllAdmin();
        return admins.stream()
                .map(admin -> adminMapper.mapAdminToDTO(admin))
                .collect(Collectors.toList());
//        return this.adminService.getAllAdmin();
    }



    //Method to read admin by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public AdminDTO getAdmin(@PathVariable String id) {
        Admin admin = this.adminService.getAdmin(id);

        AdminDTO adminDTO = adminMapper.mapAdminToDTO(admin);

        return adminDTO;
    }



    //Method to update admin
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateAdmin(@PathVariable String id, @RequestBody AdminDTO adminDTO) {
        Admin admin = adminMapper.mapDTOToAdmin(adminDTO);
        this.adminService.updateAdmin(id, admin);
        return "Update completed successfully!";
    }



    //Method to delete all admins
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllAdmin() {
        this.adminService.deleteAdmin();
        return "All admins have been successfully deleted!";
    }



    //Method to delete admin by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteAdmin(@PathVariable String id) {
        this.adminService.deleteAdminById(id);
        return "Admin delete successfully!";
    }

}
