package br.com.unisoma.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.unisoma.api.dto.EmployeeDto;
import br.com.unisoma.api.exceptionhandler.EmployeeAlreadyRegisteredException;
import br.com.unisoma.api.exceptionhandler.EmployeeNotFoundException;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    @Autowired
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository repository;

    private Employee employee;

    private EmployeeDto employeeDto;

    private Optional<Employee> employeeOptional;

    private static final String CPF = "106.432.520-37";
    private static final String NAME = "João da Silva";
    private static final LocalDate BIRTHDATE = LocalDate.of(1984, 8, 25);
    private static final String PHONE = "11988888888";
    private static final String ADDRESS = "R. Benedita Amaral Pinto, 330 - Jardim Santa Genebra, Campinas - SP.";
    private static final Float SALARY = 2380.72f;

    private static final String CPF_NOT_FOUND = "867.694.646-91";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startEmployees();
    }

    @Test
    void testCreate() {
        when(repository.save(any())).thenReturn(employee);

        EmployeeDto response = employeeService.create(employee);

        assertNotNull(response);
        assertEquals(EmployeeDto.class, response.getClass());

        assertEquals(response.getCpf(), CPF);
        assertEquals(response.getName(), NAME);
        assertEquals(response.getBirthDate(), BIRTHDATE);
        assertEquals(response.getPhone(), PHONE);
        assertEquals(response.getAddress(), ADDRESS);
        assertEquals(response.getSalary(), SALARY);
    }

    @Test
    void testCreateAlreadyRegistered() {
        when(repository.findById(anyString())).thenThrow(new EmployeeAlreadyRegisteredException());
        
        try{
            employeeOptional.get().setCpf(CPF);
            employeeService.create(employee);
        } catch (Exception ex) {
            assertEquals(EmployeeAlreadyRegisteredException.class, ex.getClass());
        }
    }

    @Test
    void testDelete() {
        when(repository.findById(anyString())).thenReturn(employeeOptional);

        doNothing().when(repository).deleteById(anyString());

        employeeService.delete(CPF);

        verify(repository, times(1)).deleteById(anyString());
    }

    @Test
    void testDeleteNotFound() {
        when(repository.findById(anyString())).thenThrow(new EmployeeNotFoundException());

        try{
            employeeService.delete(CPF_NOT_FOUND);
        } catch (Exception ex) {
            assertEquals(EmployeeNotFoundException.class, ex.getClass());
        }

    }

    @Test
    void testFindAll() {
        List<Employee> list = new ArrayList<Employee>();

        list.add(employee);

        when(repository.findAll()).thenReturn(list);

        List<EmployeeDto> response = employeeService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(EmployeeDto.class, response.get(0).getClass());

        assertEquals(response.get(0).getCpf(), CPF);
        assertEquals(response.get(0).getName(), NAME);
        assertEquals(response.get(0).getBirthDate(), BIRTHDATE);
        assertEquals(response.get(0).getPhone(), PHONE);
        assertEquals(response.get(0).getAddress(), ADDRESS);
        assertEquals(response.get(0).getSalary(), SALARY);
    }

    @Test
    void testFindCpf() {
        when(repository.findById(anyString())).thenReturn(employeeOptional);

        EmployeeDto response = employeeService.findCpf(CPF);

        assertNotNull(response);

        assertEquals(EmployeeDto.class, response.getClass());

        assertEquals(response.getCpf(), CPF);
        assertEquals(response.getName(), NAME);
        assertEquals(response.getBirthDate(), BIRTHDATE);
        assertEquals(response.getPhone(), PHONE);
        assertEquals(response.getAddress(), ADDRESS);
        assertEquals(response.getSalary(), SALARY);
    }

    @Test
    void testFindCpfNotFound() {
        when(repository.findById(anyString())).thenThrow(new EmployeeNotFoundException());

        try{
            employeeService.findCpf(CPF_NOT_FOUND);
        } catch (Exception ex) {
            assertEquals(EmployeeNotFoundException.class, ex.getClass());
        }
    }

    @Test
    void testUpdateNotFound() {
        when(repository.findById(anyString())).thenThrow(new EmployeeNotFoundException());

        try{
            employeeService.update(employee);
        } catch (Exception ex) {
            assertEquals(EmployeeNotFoundException.class, ex.getClass());
        }
    }

    private void startEmployees() {
        employee = new Employee(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY);

        employeeDto = new EmployeeDto(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY);

        employeeOptional = Optional.of(new Employee(CPF, NAME, BIRTHDATE, PHONE, ADDRESS, SALARY));
    }
}