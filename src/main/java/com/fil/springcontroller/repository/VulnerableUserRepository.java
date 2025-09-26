package com.fil.springcontroller.repository;

import com.fil.springcontroller.entity.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VulnerableUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<AppUser> findByUsername(String username){
        String jpql = "SELECT u FROM AppUser u WHERE u.username = '" + username + "'";
        return entityManager.createQuery(jpql, AppUser.class).getResultList();
    }
}
