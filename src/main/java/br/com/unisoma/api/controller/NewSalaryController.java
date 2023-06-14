package br.com.unisoma.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.api.dto.EmployeeDto;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api/newsalary")
public class NewSalaryController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/{cpf}")
    public ResponseEntity<EmployeeDto> get(@PathVariable("cpf") String cpf) {
        Optional<Employee> employee = this.repository.findById(cpf);

        if (employee.isPresent()) {
            return ResponseEntity.ok(new EmployeeDto(employee.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
