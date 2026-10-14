package com.empresa.MedCare.patient;

import com.empresa.MedCare.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PatientDTO(
        @NotBlank String name,
        @NotBlank String cpf,
        @NotBlank @Email String email,
        @NotBlank String phone,
        Long healthInsuranceId,
        @NotBlank String password
) {}
