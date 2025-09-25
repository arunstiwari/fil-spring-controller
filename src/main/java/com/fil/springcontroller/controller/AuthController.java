package com.fil.springcontroller.controller;

import com.fil.springcontroller.service.AdminService;
import com.fil.springcontroller.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    private final AdminService adminService;
    private JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil, AdminService adminService) {
        this.jwtUtil = jwtUtil;
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user ){
        String username = user.get("username");
        String password = user.get("password");

        if ("admin".equals(username) && "admin".equals(password)){
            return jwtUtil.generateToken(username, List.of("ROLE_ADMIN"));
        }
        if ("user".equals(username) && "user".equals(password)){
            return jwtUtil.generateToken(username, List.of("ROLE_USER"));
        }
        throw new RuntimeException("Invalid Credentials");
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "You can access it as you are admin user";
    }

    @GetMapping("/user")
    public String getUser(){
        adminService.doSomeAdminAction();
        return "You can access it as you are either admin or regular user";
    }
}
