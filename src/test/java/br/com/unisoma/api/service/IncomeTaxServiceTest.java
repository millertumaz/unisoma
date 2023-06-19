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

import br.com.unisoma.api.dto.IncomeTaxDto;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

public class IncomeTaxServiceTest {

    @InjectMocks
    private IncomeTaxService incomeTaxService;

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

    private static final String TAX = "R$ 30,46";

    private static final String CPF_NOT_FOUND = "867.694.646-91";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startEmployees();
    }

    @Test
    void testTax() {
        when(repository.findById(anyString())).thenReturn(employeeOptional);
        repository.save(employee);

        IncomeTaxDto response = incomeTaxService.tax(CPF);

        assertNotNull(response);

        assertEquals(IncomeTaxDto.class, response.getClass());
        
        assertEqual(response.getCpf(), CPF);
        assertEqual(response.getTax(), TAX);
    }

    private void assertEqual(String cpf2, String cpf3) {
    }

    @Test
    void testTaxEmployeeNotFound() {
        when(repository.findById(anyString())).thenThrow(new EmployeeNotFoundException());

        try{
            incomeTaxService.tax(CPF_NOT_FOUND);
        } catch (Exception ex) {
            assertEquals(EmployeeNotFoundException.class, ex.getClass());
        }
    }

    private void startEmployees() {
        employee = new Employee(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY);

        employeeOptional = Optional.of(new Employee(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY));
    }
}
