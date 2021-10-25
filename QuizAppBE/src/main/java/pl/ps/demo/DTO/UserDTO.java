package pl.ps.demo.DTO;

import pl.ps.demo.ENUMS.RoleName;

public class UserDTO {

    private String userName;
    private RoleName roleName;

    public UserDTO(String userName, RoleName roleName) {
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
