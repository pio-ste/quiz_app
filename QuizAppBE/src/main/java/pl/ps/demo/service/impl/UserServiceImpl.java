package pl.ps.demo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ps.demo.exception.MyCustomException;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

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
        var userValidation = new UserValidation(exceptionList, userDTO, userRepository);
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
        var userValidation = new UserValidation(exceptionList, userDTO, userRepository);
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
        var userValidation = new UserValidation(exceptionList, userDTO, userRepository);
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

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String userName = decodedJWT.getSubject();
                User user = userRepository.findByUserNameOrThrow(userName);
                String access_token = JWT.create()
                        .withSubject(user.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error ", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> tokens = new HashMap<>();
                tokens.put("error_message", exception.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }
        } else {
            throw new MyCustomException("Refresh token is missing");
        }
    }

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
