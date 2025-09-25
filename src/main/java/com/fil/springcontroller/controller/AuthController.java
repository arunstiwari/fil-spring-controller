package com.fil.springcontroller.controller;

import com.fil.springcontroller.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    private JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user ){
        String username = user.get("username");
        String password = user.get("password");

        if ("admin".equals(username) && "admin".equals(password)){
            return jwtUtil.generateToken(username, Map.of("role", "USER_ROLE"));
        }
        throw new RuntimeException("Invalid Credentials");
    }
}
