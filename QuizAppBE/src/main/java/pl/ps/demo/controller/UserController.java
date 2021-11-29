package pl.ps.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.service.dto.QuizDTO;
import pl.ps.demo.service.dto.UserDTO;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.entity.User;
import pl.ps.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@RequestMapping("/quizApp")
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/tutor/getUsers")
    public List<UserDTO> getAllUsers(){
        return userService.getStudents();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/saveStudent")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveStudent(userDTO);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/saveTutor")
    public UserDTO saveTutor(@RequestBody UserDTO userDTO) {
        return userService.saveTutor(userDTO);
    }

    @ResponseStatus(CREATED)
    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }
}
