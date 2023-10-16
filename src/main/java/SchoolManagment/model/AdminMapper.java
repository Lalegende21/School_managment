package SchoolManagment.model;

import SchoolManagment.dto.AdminDTO;
import SchoolManagment.entity.Admin;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    private ModelMapper modelMapper = new ModelMapper();

    //Methode pour convetir l'entite en DTO
    public AdminDTO mapAdminToDTO(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    //Methode pour convertir le DTO en entite
    public Admin mapDTOToAdmin(AdminDTO adminDTO) {
        return modelMapper.map(adminDTO, Admin.class);
    }
}
