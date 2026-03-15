package org.demo.authentication.controller;

import org.demo.authentication.dto.LoginRequest;
import org.demo.authentication.model.User;
import org.demo.authentication.security.JwtUtil;
import org.demo.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userService.registerUser(user);
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        return jwtUtil.generateToken(loginRequest.getUsername());
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Secure API";
    }
}
