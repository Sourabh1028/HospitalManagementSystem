package com.geekster.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Doctor_tbl")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Email(message = "Enter valid Email")
    private String doctorEmail;

    @Column(name = "doctor_city")
    private String doctorCity;

    @Column(name = "doctor_PNumber")
    @Length(min = 10, max = 15, message = "Enter valid Number")
    private String PhoneNumber;

    @Column(name = "doctor_Specialization")
    private String doctorSpecialization;

}
