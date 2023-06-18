package br.com.unisoma.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.unisoma.api.dto.NewSalaryDto;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

public class NewSalaryServiceTest {

    @InjectMocks
    private NewSalaryService newSalaryService;

    @Mock
    private EmployeeRepository repository;

    private Employee employee;

    private Optional<Employee> employeeOptional;

    private static final String CPF = "106.432.520-37";
    private static final String NAME = "João da Silva";
    private static final LocalDate BIRTHDATE = LocalDate.of(1984, 8, 25);
    private static final String PHONE = "11988888888";
    private static final String ADDRESS = "R. Benedita Amaral Pinto, 330 - Jardim Santa Genebra, Campinas - SP.";
    private static final Float SALARY = 2380.72f;

    private static final Float NEWSALARY = 2475.95f;
    private static final Float REAJUSTMENT = 95.23f;
    private static final String PERCENTAGEREAJUSTMENT = "4%";

    private static final String CPF_NOT_FOUND = "867.694.646-91";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startEmployees();
    }

    @Test
    void testNewSalary() {
        when(repository.findById(anyString())).thenReturn(employeeOptional);
        repository.save(employee);

        NewSalaryDto response = newSalaryService.newSalary(CPF);

        assertNotNull(response);

        assertEquals(NewSalaryDto.class, response.getClass());

        assertEquals(response.getCpf(), CPF);
        assertEquals(response.getNewSalary(), NEWSALARY);
        assertEquals(response.getReadjustment(), REAJUSTMENT);
        assertEquals(response.getReadjustmentPercentage(), PERCENTAGEREAJUSTMENT);
    }

    @Test
    void testNewSalaryEmployeeNotFound() {
       when(repository.findById(anyString())).thenThrow(new EmployeeNotFoundException());

        try{
            newSalaryService.newSalary(CPF_NOT_FOUND);
        } catch (Exception ex) {
            assertEquals(EmployeeNotFoundException.class, ex.getClass());
        }
    }

    private void startEmployees() {
        employee = new Employee(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY);

        employeeOptional = Optional.of(new Employee(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY));
    }
}
