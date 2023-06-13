package br.com.unisoma.api.repository;

import br.com.unisoma.api.dto.EmployeeDto;
//import br.com.unisoma.api.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDto, String> {
}
