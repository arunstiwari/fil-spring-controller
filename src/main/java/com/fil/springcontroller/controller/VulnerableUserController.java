package com.fil.springcontroller.controller;

import com.fil.springcontroller.entity.AppUser;
import com.fil.springcontroller.repository.UserRepository;
import com.fil.springcontroller.repository.VulnerableUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vulnerable/user")
public class VulnerableUserController {
    private VulnerableUserRepository vulnerableUserRepository;
    private final UserRepository userRepository;


    public VulnerableUserController(VulnerableUserRepository vulnerableUserRepository, UserRepository userRepository) {
        this.vulnerableUserRepository = vulnerableUserRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/search")
    public List<AppUser> search(@RequestParam(name = "username") String username) {
        return userRepository.findByUsername(username);
    }
}
