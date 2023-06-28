package com.geekster.HospitalManagementSystem.Service;

import com.geekster.HospitalManagementSystem.Model.Doctor;
import com.geekster.HospitalManagementSystem.Repositary.DoctorRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepo doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }

    public JSONObject validDoctor(Doctor doctor){
        JSONObject errors=new JSONObject();

        String city=doctor.getDoctorCity();
        if(city.equalsIgnoreCase("Delhi") && !city.equalsIgnoreCase("Noida") && !city.equalsIgnoreCase("faridabad")){
            errors.put(city,"Doctor should live in NCR");
        }

        String speciality=doctor.getDoctorSpecialization();
        if(!speciality.equalsIgnoreCase("Orthopedic") && !speciality.equalsIgnoreCase("Gynecology") && !speciality.equalsIgnoreCase("Dermatology") && !speciality.equalsIgnoreCase("ENT")){
            errors.put(speciality, "Doctor should be specialized in Orthopedic, Gynecology, Dermatology, ENT");
        }

        return errors;
    }

    public ResponseEntity<String> deleteDoctor(Integer doctorId) {
        if(!doctorRepo.findById(doctorId).isPresent()){
            return new ResponseEntity<>("Doctor is not present", HttpStatus.BAD_REQUEST);
        }

        doctorRepo.deleteById(doctorId);
        return new ResponseEntity<>("Doctor Deleted successfully !!!", HttpStatus.OK);
    }
}
