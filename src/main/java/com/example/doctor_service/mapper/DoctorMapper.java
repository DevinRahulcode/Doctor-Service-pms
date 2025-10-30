package com.example.doctor_service.mapper;

import com.example.doctor_service.dto.request.DoctorRequestDTO;
import com.example.doctor_service.dto.response.DoctorResponseDTO;
import com.example.doctor_service.entity.Doctor;

public class DoctorMapper {

    public static DoctorResponseDTO toDTO(Doctor doctor){

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

        doctorResponseDTO.setId(doctor.getId().toString());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setDescription(doctor.getDescription());
        doctorResponseDTO.setEmail(doctor.getEmail());

        return doctorResponseDTO;
    }

    public static Doctor toModel(DoctorRequestDTO doctorRequestDTO){
        Doctor doctor = new Doctor();

        doctor.setName(doctorRequestDTO.getName());
        doctor.setDescription(doctorRequestDTO.getDescription());
        doctor.setEmail(doctorRequestDTO.getEmail());

        return doctor;
    }
}
