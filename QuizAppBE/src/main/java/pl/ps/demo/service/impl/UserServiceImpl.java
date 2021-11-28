package pl.ps.demo.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ps.demo.exception.ValidationException;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.entity.User;
import pl.ps.demo.model.enums.RoleName;
import pl.ps.demo.model.repository.RoleRepository;
import pl.ps.demo.model.repository.UserRepository;
import pl.ps.demo.security.service.UserDetailsImpl;
import pl.ps.demo.service.UserService;
import pl.ps.demo.service.dto.UserDTO;
import pl.ps.demo.service.mapper.UserMapper;
import pl.ps.demo.service.validation.UserValidation;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO saveStudent(UserDTO userDTO) {
        List<String> exceptionList = new LinkedList<>();
        var userValidation = new UserValidation(exceptionList, userDTO);
        userValidation.validate();
        var user = UserMapper.mapFromDtoToEntity(userDTO);
        Role role = roleRepository.findByRoleName(RoleName.STUDENT);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return UserMapper.mapFromEntityToDto(userRepository.save(user));
    }

    @Override
    public UserDTO saveTutor(UserDTO userDTO) {
        List<String> exceptionList = new LinkedList<>();
        var userValidation = new UserValidation(exceptionList, userDTO);
        userValidation.validate();
        var user = UserMapper.mapFromDtoToEntity(userDTO);
        Role role = roleRepository.findByRoleName(RoleName.TUTOR);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return UserMapper.mapFromEntityToDto(userRepository.save(user));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        List<String> exceptionList = new LinkedList<>();
        var userValidation = new UserValidation(exceptionList, userDTO);
        userValidation.validate();
        User user = userRepository.getByIdOrThrow(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserName(userDTO.getUserName());
        return UserMapper.mapFromEntityToDto(user);
    }

    @Override
    public void addRoleToUser(String userName, RoleName roleName) {
        User user = userRepository.findByUserNameOrThrow(userName);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUserNameOrThrow(userName);
    }

    @Override
    public List<UserDTO> getStudents() {
        List<UserDTO> userDTOS = new LinkedList<>();
        Role role = roleRepository.findByRoleName(RoleName.STUDENT);
        userRepository.findUserByRolesEquals(role).forEach(user ->
                userDTOS.add(UserMapper.mapFromEntityToDto(user)));
        return userDTOS;
    }

    /*@Override
    public Authentication signIN(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()){
            List<String> exceptionList = new LinkedList<>();
            exceptionList.add("Wpisz");
            throw new ValidationException(exceptionList);
        } else {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
            return authenticationManager.authenticate(authenticationToken);
        }
    }*/

    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user = userRepository.findByUserNameOrThrow(userName);
        if (user != null){
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            });
            return new UserDetailsImpl(user.getId(), user.getUserName(), user.getEmail(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("Nie znaleziono użytkownika");
        }
    }
}
