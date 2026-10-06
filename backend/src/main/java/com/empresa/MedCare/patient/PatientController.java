package com.empresa.MedCare.patient;

import com.empresa.MedCare.insurance.HealthInsurance;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientRequestDTO dto) {
        Patient newPatient = patientService.registerPatient(
                dto.name(),
                dto.cpf(),
                dto.email(),
                dto.phone(),
                dto.healthInsuranceId()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
    }

}
