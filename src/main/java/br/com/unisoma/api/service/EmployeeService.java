package br.com.unisoma.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.unisoma.api.dto.EmployeeDto;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
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
        
        employee.orElseThrow(() -> new EmployeeNotFoundException());

        return ResponseEntity.ok(new EmployeeDto(employee.get()));
    }

    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    public Employee update(Employee employee, String cpf) {
        findCpf(cpf);
        
        employee.setCpf(cpf);

        return this.repository.save(employee);
    }

    public void delete(String cpf) {
        findCpf(cpf);

        this.repository.deleteById(cpf);
    }
}
