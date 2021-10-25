package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.ENUMS.RoleName;
import pl.ps.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(RoleName roleName);
}
