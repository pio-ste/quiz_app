package pl.ps.demo.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.entity.User;
import pl.ps.demo.model.enums.RoleName;
import pl.ps.demo.model.repository.RoleRepository;
import pl.ps.demo.model.repository.UserRepository;
import pl.ps.demo.service.UserService;

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
    public User saveStudent(User user) {
        Role role = roleRepository.findByRoleName(RoleName.STUDENT);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User saveTutor(User user) {
        Role role = roleRepository.findByRoleName(RoleName.TUTOR);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User updateUser(User user) {
        User newUser = userRepository.findUserById(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUserName(user.getUserName());
        return userRepository.save(newUser);
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
    public List<User> getStudents() {
        Role role = roleRepository.findByRoleName(RoleName.STUDENT);
        return userRepository.findUserByRolesEquals(role);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameOrThrow(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Nie znaleziono użytkownika");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}
