package pl.ps.demo.model.entity;

import pl.ps.demo.model.enums.RoleName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "quiz_app")
public class Role extends IdField {

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role(Long id, RoleName roleName) {
        super(id);
        this.roleName = roleName;
    }

    public Role() {
    }

    public String getRoleName() {
        return roleName.toString();
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
