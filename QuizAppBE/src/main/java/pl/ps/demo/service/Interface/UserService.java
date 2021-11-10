package pl.ps.demo.service.Interface;


import pl.ps.demo.ENUMS.RoleName;
import pl.ps.demo.entity.Role;
import pl.ps.demo.entity.User;

import java.util.List;

public interface UserService {

    User saveStudent(User user);

    User saveTutor(User user);

    Role saveRole(Role role);

    User updateUser(User user);

    void addRoleToUser(String userName, RoleName roleName);

    User getUser(String userName);

    List<User> getStudents();
}
