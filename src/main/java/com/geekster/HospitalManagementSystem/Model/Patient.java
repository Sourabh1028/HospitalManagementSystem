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
@Table(name = "Patient_tbl")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;

    @Column(name = "patient_name")
    @Length(min = 3, message = "Please enter at last 3 characters")
    private String patientName;

    @Column(name = "patient_Email")
    @Email(message = "Enter valid Email")
    private String patientEmail;

    @Column(name = "patient_city")
    @Length(min = 3, message = "Please enter city max 20 characters")
    private String patientCity;

    @Column(name = "patient_PNumber")
    @Length(min = 10, max = 15, message = "Enter valid Number")
    private String patientPhoneNumber;

    @Column(name = "symptoms")
    private String symptoms;

}
