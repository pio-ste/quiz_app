package pl.ps.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ps.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/quizApp")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /*@PostMapping("/login")
    public Authentication  signIN(HttpServletRequest request, HttpServletResponse response){
        return userService.signIN(request.getParameter("userName"), request.getParameter("password"));
    }*/

}
