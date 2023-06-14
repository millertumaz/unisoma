package br.com.unisoma.api.dto;

import br.com.unisoma.api.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewSalaryDto {
    private String cpf;
    private Float newSalary;
    private Float readjustment;
    private int readjustmentPercentage;


    public NewSalaryDto(Employee employee, Float newSalary, Float readjustment, int percentage) {
        this.cpf = employee.getCpf();
        this.newSalary = newSalary;
        this.readjustment = readjustment;
        this.readjustmentPercentage = percentage;
    }
}
