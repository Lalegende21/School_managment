package SchoolManagment.serviceImpl;

import SchoolManagment.entity.Role;
import SchoolManagment.repository.RoleRepo;
import SchoolManagment.serviceImpl.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Override
    public void created(Role role) {
        this.roleRepo.save(role);
    }


}
