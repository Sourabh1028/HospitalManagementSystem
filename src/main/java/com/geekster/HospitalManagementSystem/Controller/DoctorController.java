package com.geekster.HospitalManagementSystem.Controller;

import com.geekster.HospitalManagementSystem.Model.Doctor;
import com.geekster.HospitalManagementSystem.Service.DoctorService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){
        JSONObject valid = doctorService.validDoctor(doctor);
        if(!valid.isEmpty()){
            return new ResponseEntity<>(valid.toString(), HttpStatus.BAD_REQUEST);
        }

        doctorService.addDoctor(doctor);

        return new ResponseEntity<>("Doctor added Successfully !!!", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @DeleteMapping("deleteDoctor/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Integer doctorId){
        return doctorService.deleteDoctor(doctorId);
    }
 }
