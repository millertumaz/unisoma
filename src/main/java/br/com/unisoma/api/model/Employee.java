package br.com.unisoma.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @NotNull(message = "O CPF não pode ser nulo.")
    @CPF(message = "CPF inválido.")
    @Pattern(regexp="^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$", message = "O CPF deve ser informado no formato 000.000.000-00")
    private String cpf;

    @Column
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 255 caractere.")
    private String name;

    @Column
    @Past(message = "Data de nascimento inválida.")
    private LocalDate birthDate;

    @Column
    @Pattern(regexp="^\\d{10,11}$", message = "O telefone deve ser informado no formato <DDD 2 dígitos><Telefone somente números>")
    private String phone;

    @Column
    @Size(min = 3, max = 255, message = "O endereço deve ter entre 3 e 255 caractere.")
    private String address;

    @Column
    @NotNull(message = "O salário não pode ser nulo.")
    @Digits(integer = 6, fraction = 2, message = "O formato do salário deve ser <6 dígito>.<2 dígitos>")
    private Float salary;
}   
