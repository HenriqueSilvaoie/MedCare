package com.empresa.MedCare.common.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder //constructors override made by lombok
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String phone;
}
