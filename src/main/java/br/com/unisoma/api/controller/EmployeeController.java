package br.com.unisoma.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.api.dto.EmployeeDto;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<EmployeeDto> list() {
        return this.repository.findAll();
    }

    @GetMapping("/{cpf}")
    public Optional<EmployeeDto> get(@PathVariable("cpf") String cpf) {
        return this.repository.findById(cpf);
    }

    @PostMapping
    public EmployeeDto save(@RequestBody EmployeeDto employee) {
        return this.repository.save(employee);
    }
}
