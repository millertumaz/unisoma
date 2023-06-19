package br.com.unisoma.api.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "br.com.unisoma.api.controller")
public class EmployeeControllerAdvice {
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> employeeNotFound(EmployeeNotFoundException employeeNotFound) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Funcionário não encontrado!");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(EmployeeAlreadyRegisteredException.class)
    public ResponseEntity<MessageExceptionHandler> employeeAlreadyRegistered(EmployeeAlreadyRegisteredException employeeAlreadyRegistered) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Já existe funcionário cadastrado com o CPF informado.");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
