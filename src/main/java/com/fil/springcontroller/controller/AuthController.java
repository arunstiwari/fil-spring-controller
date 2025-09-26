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

//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody Map<String, String> user ){
//        String username = user.get("username");
//        String password = user.get("password");
//
//        if ("admin".equals(username) && "admin".equals(password)){
//            String access_token = jwtUtil.generateToken(username, List.of("ROLE_ADMIN"),60);
//            String refresh_token = jwtUtil.generateToken(username, List.of("ROLE_ADMIN"),60*24*7);
//            return Map.of(
//                    "access_token",access_token,
//                    "refresh_token",refresh_token
//                    );
//        }
//        if ("user".equals(username) && "user".equals(password)){
//            String access_token = jwtUtil.generateToken(username, List.of("ROLE_ADMIN"),60);
//            String refresh_token = jwtUtil.generateToken(username, List.of("ROLE_ADMIN"),60*24*7);
//            return Map.of(
//                            "access_token",access_token,
//                            "refresh_token",refresh_token
//                    );
//
//        }
//        throw new RuntimeException("Invalid Credentials");
//    }
//
//    @PostMapping("/refresh")
//    public Map<String, String> refresh(@RequestBody Map<String, String> token ) {
//        String refresh_token = token.get("refresh_token");
//
//        if (jwtUtil.validateToken(refresh_token, jwtUtil.extractUsername(refresh_token))){
//            String username = jwtUtil.extractUsername(refresh_token);
//            Claims claims = jwtUtil.extractAllClaims(refresh_token);
//            List<String> roles = claims.get("roles", List.class);
//            String newAccessToken = jwtUtil.generateToken(username, roles, 15); // 15 mins
//            return Map.of("access_token", newAccessToken);
//        }
//        throw  new RuntimeException("Invalid Refresh Token");
//    }


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
