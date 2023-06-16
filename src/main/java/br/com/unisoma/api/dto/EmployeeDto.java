package br.com.unisoma.api.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.unisoma.api.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private Float salary;

    public EmployeeDto(Employee employee) {
        this.name = employee.getName();
        this.cpf = employee.getCpf();
        this.birthDate = employee.getBirthDate();
        this.phone = employee.getPhone();
        this.address = employee.getAddress();
        this.salary = employee.getSalary();
    }

    public static List<EmployeeDto> convert(List<Employee> employee) {
        return employee.stream().map(EmployeeDto::new).collect(Collectors.toList());
    }
}
