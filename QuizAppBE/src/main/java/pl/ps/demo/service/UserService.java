package pl.ps.demo.service;


import pl.ps.demo.model.enums.RoleName;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.entity.User;

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
