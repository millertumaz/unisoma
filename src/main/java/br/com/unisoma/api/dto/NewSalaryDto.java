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

    public NewSalaryDto(Employee employee) {
        this.cpf = employee.getCpf();
    }
}
