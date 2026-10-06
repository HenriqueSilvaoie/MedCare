package com.empresa.MedCare.patient;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name="patients")
public class Patient extends Person {

    @ManyToOne(fetch = FetchType.LAZY) //carrega dados somente se for solicitado
    @JoinColumn(name = "health_insurance_id")
    private HealthInsurance healthInsurance;
}
