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
    private String taxa;

    public IncomeTaxDto(Employee employee, String taxa) {
        this.cpf = employee.getCpf();
        this.taxa = taxa;
    }
}
