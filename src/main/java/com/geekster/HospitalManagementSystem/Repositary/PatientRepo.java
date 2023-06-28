package com.geekster.HospitalManagementSystem.Repositary;

import com.geekster.HospitalManagementSystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
