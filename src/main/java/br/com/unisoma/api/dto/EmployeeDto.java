package br.com.unisoma.api.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;

import br.com.unisoma.api.model.Employee;

public class EmployeeDto {

    private String cpf;
    private String name;    
    private LocalDate birthDate;
    private Number phone;
    private String address;
    private Float salary;

    public void Employee(String name, String cpf, LocalDate birthDate, Integer phone, String address, Float salary){
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }

    public EmployeeDto(Employee employee){
        this.name = employee.getName();
        this.cpf = employee.getCPF();
        this.birthDate = employee.getBirthDate();
        this.phone = employee.getPhone();
        this.address = employee.getAddress();
        this.salary = employee.getSalary();
    }

    public EmployeeDto() {}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCPF() { return cpf; }

    public void setCPF(String cpf) { this.cpf = cpf; }

    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Number getPhone() { return phone; }

    public void setPhone(Number phone) { this.phone = phone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Float getSalary() { return salary; }

    public void setSalary(Float salary) { this.salary = salary; }
}
