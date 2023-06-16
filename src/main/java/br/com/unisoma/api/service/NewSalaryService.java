package br.com.unisoma.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisoma.api.dto.NewSalaryDto;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;
import br.com.unisoma.api.util.CalculateNewSalary;
import br.com.unisoma.api.util.MainNewSalary;

@Service
public class NewSalaryService {

    @Autowired
    private EmployeeRepository repository;

    public NewSalaryDto newSalary(String cpf) {

        Optional<Employee> employee = this.repository.findById(cpf);

        employee.orElseThrow(() -> new EmployeeNotFoundException());

        CalculateNewSalary calculateNewSalary = new MainNewSalary()
                .calculate(employee.get().getSalary());

        this.repository.updateSalary(cpf, calculateNewSalary.newSalary);

        return new NewSalaryDto(employee.get(), calculateNewSalary.newSalary,
                calculateNewSalary.readjustment, calculateNewSalary.percentage);
    }
}
