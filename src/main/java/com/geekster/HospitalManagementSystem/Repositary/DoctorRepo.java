package com.geekster.HospitalManagementSystem.Repositary;

import com.geekster.HospitalManagementSystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
