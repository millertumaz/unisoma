package br.com.unisoma.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @NotNull
    @CPF
    private String cpf;

    @Column
    // @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @Column
    // @NotNull
    private LocalDate birthDate;

    @Column
    // @NotNull
    private Long phone;

    @Column
    // @NotNull
    private String address;

    @Column
    // @NotNull
    private Float salary;
}
