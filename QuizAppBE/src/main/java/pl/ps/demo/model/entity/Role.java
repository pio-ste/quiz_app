package pl.ps.demo.model.entity;

import com.sun.istack.NotNull;
import pl.ps.demo.model.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "quiz_app")
public class Role extends IdField {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, length = 10)
    @NotNull
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
