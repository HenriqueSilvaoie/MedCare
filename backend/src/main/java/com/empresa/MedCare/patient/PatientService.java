package com.empresa.MedCare.patient;

import com.empresa.MedCare.insurance.HealthInsurance;
import com.empresa.MedCare.insurance.HealthInsuranceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final HealthInsuranceRepository healthInsuranceRepository;

    public PatientService(
            PatientRepository patientRepository,
            HealthInsuranceRepository healthInsuranceRepository) {
        this.patientRepository = patientRepository;
        this.healthInsuranceRepository = healthInsuranceRepository;
    }

    @Transactional
    public Patient registerPatient(
            String name,
            String cpf,
            String email,
            String phone,
            Long healthInsuranceId) {
        /*Usado por dois motivos:
            1º porque nem todo paciente possui um convênio
            2º porque no BD "healthInsurance" é um objeto, e não um ID. Logo, para vincular
               o paciente ao banco de dados, é necessário passar o objeto.
        */
        HealthInsurance healthInsurance = null;

        if (healthInsuranceId != null) {
            healthInsurance = healthInsuranceRepository.findById(healthInsuranceId)
                    .orElseThrow(() -> new RuntimeException("Convênio não encontrado com o ID " + healthInsuranceId));
        }

        Patient patient = Patient.builder()
                .name(name)
                .cpf(cpf)
                .email(email)
                .phone(phone)
                .healthInsurance(healthInsurance)
                .build();
        return patientRepository.save(patient);
    }


}