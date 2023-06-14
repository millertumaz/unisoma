package br.com.unisoma.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.unisoma.api.dto.NewSalaryDto;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

@Service
public class NewSalaryService {

    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<NewSalaryDto> newSalary(String cpf) {

        Optional<Employee> employee = this.repository.findById(cpf);

        employee.orElseThrow(() -> new EmployeeNotFoundException());

        Float currentSalary = employee.get().getSalary();
        Float newSalaryCalculate = (float) 0;
        int percentage = 0;

        if (currentSalary >= 0 && currentSalary <= 400){
            newSalaryCalculate = currentSalary * 1.15f;
            percentage = 15;
        } else if (currentSalary > 400 && currentSalary <= 800){
            newSalaryCalculate = currentSalary * 1.12f;
            percentage = 12;
        } else if (currentSalary > 800 && currentSalary <= 1200){
            newSalaryCalculate = currentSalary * 1.10f;
            percentage = 10;
        } else if (currentSalary > 1200 && currentSalary <= 2000){
            newSalaryCalculate = currentSalary * 1.07f;
            percentage = 7;
        } else {
            newSalaryCalculate = currentSalary * 1.04f;
            percentage = 4;
        }
        
        Float readjustment = (float) (newSalaryCalculate - currentSalary);

        this.repository.updateSalary(cpf, newSalaryCalculate);

        return ResponseEntity.ok(new NewSalaryDto(employee.get(), newSalaryCalculate, readjustment, percentage));
    }
}
