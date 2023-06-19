package br.com.unisoma.api.dto;

import br.com.unisoma.api.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeTaxDto {
    private String cpf;
    private String tax;

    public IncomeTaxDto(Employee employee, String tax) {
        this.cpf = employee.getCpf();
        this.tax = tax;
    }
}
