package br.com.unisoma.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.api.dto.EmployeeDto;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/{cpf}")
    public EmployeeDto getCpf(@Valid @PathVariable("cpf") String cpf) {
        return this.employeeService.findCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@Valid @RequestBody Employee employee) {
        return this.employeeService.create(employee);
    }

    @PutMapping("/{cpf}")
    public EmployeeDto alter(@PathVariable("cpf") String cpf, @RequestBody Employee employee) {
        employee.setCpf(cpf);

        return this.employeeService.update(employee);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("cpf") String cpf) {
        this.employeeService.delete(cpf);
    }
}
