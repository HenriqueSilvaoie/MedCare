package com.empresa.MedCare.doctor;

import com.empresa.MedCare.common.model.Person;
import com.empresa.MedCare.insurance.HealthInsurance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "doctors")
public class Doctor extends Person {
    @Column(name = "crm", nullable = false, unique = true, length = 20)
    private String crm;

    @Column(nullable = false, length = 50)
    private String speciality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_insurance_id")
    private HealthInsurance healthInsurance;
}
