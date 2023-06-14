package br.com.unisoma.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.api.dto.NewSalaryDto;
import br.com.unisoma.api.model.Employee;
import br.com.unisoma.api.service.NewSalaryService;

@RestController
@RequestMapping(value = "/api/newsalary")
public class NewSalaryController {

    @Autowired
    private NewSalaryService newSalaryService;
    
    @PutMapping
    public ResponseEntity<NewSalaryDto> newSalary(@Valid @RequestBody Employee newSalary, String cpf) {
        return this.newSalaryService.newSalary(newSalary.getCpf());
    }    
}
