package com.empresa.MedCare.patient;

import com.empresa.MedCare.insurance.HealthInsurance;
import com.empresa.MedCare.insurance.HealthInsuranceRepository;
import com.empresa.MedCare.user.User;
import com.empresa.MedCare.user.UserRepository;
import com.empresa.MedCare.user.UserRole;
import com.empresa.MedCare.user.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HealthInsuranceRepository healthInsuranceRepository;
    private final UserService userService;

    @Transactional
    public Patient registerPatient(PatientDTO dto) {

        HealthInsurance healthInsurance = findHealthInsuranceIfExists(dto.healthInsuranceId());

        User user = userService.createUser(dto.email(), dto.password(), UserRole.ROLE_PATIENT);

        Patient patient = Patient.builder()
                .name(dto.name())
                .cpf(dto.cpf())
                .email(dto.email())
                .phone(dto.phone())
                .healthInsurance(healthInsurance)
                .user(user)
                .build();

        return patientRepository.save(patient);
    }

    /*método criado por dois motivos:
            1º porque nem todo paciente possui um convênio
            2º porque no BD o convênio é um objeto, e o que é passado nos parâmetros é um ID.
        */
    private HealthInsurance findHealthInsuranceIfExists(Long healthInsuranceId) {
        if (healthInsuranceId == null) return null;
        return healthInsuranceRepository.findById(healthInsuranceId)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com o ID " + healthInsuranceId));
    }


}