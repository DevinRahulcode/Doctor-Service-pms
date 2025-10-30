package com.example.doctor_service.service;


import com.example.doctor_service.dto.request.DoctorRequestDTO;
import com.example.doctor_service.dto.response.DoctorResponseDTO;
import com.example.doctor_service.entity.Doctor;
import com.example.doctor_service.mapper.DoctorMapper;
import com.example.doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorResponseDTO> getAllDoctor(){
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorResponseDTO> doctorResponseDTOS = doctors.stream().map(DoctorMapper::toDTO).toList();

        return doctorResponseDTOS;
    }

    public DoctorResponseDTO getDoctorById(UUID id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->new RuntimeException("The Doctor with that Id Dose not exists"+id));
        return DoctorMapper.toDTO(doctor);

    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO){
        Doctor newDoctor = doctorRepository.save(DoctorMapper.toModel(doctorRequestDTO));
        return DoctorMapper.toDTO(newDoctor);
    }

    public DoctorResponseDTO updateDoctor(UUID id, DoctorRequestDTO doctorRequestDTO){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("Doctor with this ID Dose not exists" +id));
        doctor.setName(doctorRequestDTO.getName());
        doctor.setDescription(doctorRequestDTO.getDescription());
        doctor.setEmail(doctorRequestDTO.getEmail());


        Doctor updateDoctor = doctorRepository.save(doctor);
        return DoctorMapper.toDTO(updateDoctor);

    }

    public void deleteDoctor(UUID id){
        doctorRepository.deleteById(id);
    }

}
