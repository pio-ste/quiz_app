package pl.ps.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.model.enums.RoleName;
import pl.ps.demo.model.entity.Role;

public interface RoleRepository extends AbstractJpaRepository<Role> {

    Role findByRoleName(RoleName roleName);
}
