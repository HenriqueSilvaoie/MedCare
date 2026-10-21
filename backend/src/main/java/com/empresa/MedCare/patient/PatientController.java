package com.empresa.MedCare.patient;

import com.empresa.MedCare.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientDTO dto) {
        Patient newPatient = patientService.registerPatient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Patient> getPatientByCpf(@PathVariable String cpf) {
        Patient getPatient = patientService.findByCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(getPatient);
    }


}
