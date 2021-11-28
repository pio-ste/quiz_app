package pl.ps.demo.service.dto;

import pl.ps.demo.model.enums.RoleName;

public class UserRoleDTO {

    private String userName;
    private RoleName roleName;

    public UserRoleDTO(String userName, RoleName roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
