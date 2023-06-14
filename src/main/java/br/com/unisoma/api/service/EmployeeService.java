package br.com.unisoma.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.unisoma.api.dto.EmployeeDto;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDto> findAll() {
        List<Employee> employees = this.repository.findAll();
        return EmployeeDto.convert(employees);
    }

    public ResponseEntity<EmployeeDto> findCpf(String cpf) {
        Optional<Employee> employee = this.repository.findById(cpf);

        if (employee.isPresent()) {
            System.out.println(cpf);
            return ResponseEntity.ok(new EmployeeDto(employee.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public Employee create(@Valid @RequestBody Employee employee) {
        return this.repository.save(employee);
    }

    public Employee update(@Valid @RequestBody Employee employee, String cpf) {
        employee.setCpf(cpf);

        Optional<Employee> exist = this.repository.findById(cpf);

        if (!exist.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return this.repository.save(employee);
    }

    public void delete(String cpf) {
        Optional<Employee> employee = this.repository.findById(cpf);

        if (!employee.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(cpf);
    }
}
