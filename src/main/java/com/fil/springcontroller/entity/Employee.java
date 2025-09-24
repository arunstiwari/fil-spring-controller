package com.fil.springcontroller.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min=5, max=50, message = "Name should be between 5 and 50 characters")
    private String name;
    private String department;

}
