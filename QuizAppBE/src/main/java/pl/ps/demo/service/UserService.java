package pl.ps.demo.service;


import org.springframework.security.core.Authentication;
import pl.ps.demo.model.entity.User;
import pl.ps.demo.model.enums.RoleName;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveStudent(UserDTO userDTO);

    UserDTO saveTutor(UserDTO userDTO);

    Role saveRole(Role role);

    UserDTO updateUser(UserDTO userDTO);

    void addRoleToUser(String userName, RoleName roleName);

    User getUser(String userName);

    List<UserDTO> getStudents();
}
