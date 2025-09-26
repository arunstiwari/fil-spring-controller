package com.fil.springcontroller.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/vulnerable/idor")
public class InsecureDirectObjectReferenceController {

    private static final Map<Integer, String> records;
    static {
        records = new HashMap<>();
        records.put(1, "Record for Alice");
        records.put(2, "Record for Bob");
    }



    // Vulnerable: Direct access without authorization checks
    @GetMapping("/record/{id}")
    public String getRecord(@PathVariable Integer id) {
        return records.getOrDefault(id, "Not found");
    }
}