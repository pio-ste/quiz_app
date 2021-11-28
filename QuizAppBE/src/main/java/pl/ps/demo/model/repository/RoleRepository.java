package pl.ps.demo.model.repository;

import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.enums.RoleName;

public interface RoleRepository extends AbstractJpaRepository<Role> {

    Role findByRoleName(RoleName roleName);
}
