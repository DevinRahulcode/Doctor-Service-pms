package com.example.doctor_service.controller;


import com.example.doctor_service.dto.request.DoctorRequestDTO;
import com.example.doctor_service.dto.response.DoctorResponseDTO;
import com.example.doctor_service.service.DoctorService;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctor(){
        List<DoctorResponseDTO> doctors = doctorService.getAllDoctor();
        return ResponseEntity.ok().body(doctors);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable UUID id){
        DoctorResponseDTO doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping("/create-doctor")
    public ResponseEntity<DoctorResponseDTO> createDoctor(@Validated({Default.class}) @RequestBody DoctorRequestDTO doctorRequestDTO){
        DoctorResponseDTO newDoctor = doctorService.createDoctor(doctorRequestDTO);
        return ResponseEntity.ok().body(newDoctor);
    }

    @PutMapping("/update-doctor/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable UUID id, @Validated({Default.class}) @RequestBody DoctorRequestDTO doctorRequestDTO){
        DoctorResponseDTO updateDoctor = doctorService.updateDoctor(id,doctorRequestDTO);
        return ResponseEntity.ok().body(updateDoctor);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable UUID id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

}
