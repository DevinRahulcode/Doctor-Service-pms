package com.example.doctor_service.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorRequestDTO {

    @NotNull
    @Size(max = 150, message = "The name should not exceed 150 Characters")
    private String name;

    @NotNull
    private String description;

    @NotNull
    @Email(message = "Please enter a valid email")
    private String email;


}
