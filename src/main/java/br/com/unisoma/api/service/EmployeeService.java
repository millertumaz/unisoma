package br.com.unisoma.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public EmployeeDto findCpf(String cpf) {
        Optional<Employee> employee = this.repository.findById(cpf);

        employee.orElseThrow(() -> new EmployeeNotFoundException());

        return new EmployeeDto(employee.get());
    }

    public EmployeeDto create(Employee employee) {
        Optional<Employee> exist = this.repository.findById(employee.getCpf());

        if (exist.isPresent()) {
            // Criar uma excessão aqui quando já existir o funcionário.
        }

        Employee save = this.repository.save(employee);

        return new EmployeeDto(save);
    }

    public EmployeeDto update(Employee employee, String cpf) {
        findCpf(cpf);

        employee.setCpf(cpf);

        Employee save = this.repository.save(employee);

        return new EmployeeDto(save);
    }

    public void delete(String cpf) {
        findCpf(cpf);

        this.repository.deleteById(cpf);
    }
}
