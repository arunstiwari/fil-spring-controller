package com.fil.springcontroller.repository;

import com.fil.springcontroller.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByUsername(String username);
}
