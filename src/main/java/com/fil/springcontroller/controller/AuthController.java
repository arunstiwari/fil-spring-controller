package com.fil.springcontroller.controller;

import com.fil.springcontroller.service.AdminService;
import com.fil.springcontroller.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    private final AdminService adminService;
//    private JwtUtil jwtUtil;

    public AuthController( AdminService adminService) {
//        this.jwtUtil = jwtUtil;
        this.adminService = adminService;
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
