package pl.ps.demo.service;


import pl.ps.demo.ENUMS.RoleName;
import pl.ps.demo.entity.Role;
import pl.ps.demo.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, RoleName roleName);

    User getUser(String userName);

    List<User> getUsers();
}
