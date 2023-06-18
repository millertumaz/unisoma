package br.com.unisoma.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisoma.api.dto.IncomeTaxDto;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;
import br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax.CalculateIncomeTax;
import br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax.MainIncomeTax;

@Service
public class IncomeTaxService {
    @Autowired
    private EmployeeRepository repository;

    public IncomeTaxDto tax(String cpf) {
        Optional<Employee> employee = this.repository.findById(cpf);

        employee.orElseThrow(() -> new EmployeeNotFoundException());

        CalculateIncomeTax calculateIncomeTax = new MainIncomeTax()
                .calculate(employee.get().getSalary());

        return new IncomeTaxDto(employee.get(), calculateIncomeTax.tax);
    }
}
