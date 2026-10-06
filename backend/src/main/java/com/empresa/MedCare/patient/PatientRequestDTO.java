package com.empresa.MedCare.patient;

import org.springframework.web.bind.annotation.RequestParam;

public record PatientRequestDTO(
        String name,
        String cpf,
        String email,
        String phone,
        Long healthInsuranceId
) {}
