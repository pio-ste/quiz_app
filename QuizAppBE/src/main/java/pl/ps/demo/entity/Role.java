package pl.ps.demo.entity;

import pl.ps.demo.ENUMS.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "role", schema = "quiz_app")
public class Role extends IdField{

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, length = 10)
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
