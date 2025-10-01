package com.fil.springcontroller.repository;

import com.fil.springcontroller.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
