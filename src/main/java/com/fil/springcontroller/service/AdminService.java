package com.fil.springcontroller.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @Secured("ROLE_ADMIN")
    public String doSomeAdminAction(){
        System.out.println("Only Admin guys can execute this function");
        return "Only Admin guys can execute this function";
    }
}
