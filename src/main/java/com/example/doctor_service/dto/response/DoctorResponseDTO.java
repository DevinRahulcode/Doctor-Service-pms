package com.example.doctor_service.dto.response;


import lombok.Data;

@Data
public class DoctorResponseDTO {

    private String id;
    private String name;
    private String description;
    private String email;
}
