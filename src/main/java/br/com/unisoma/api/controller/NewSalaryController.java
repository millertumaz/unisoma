package br.com.unisoma.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.api.dto.NewSalaryDto;
import br.com.unisoma.api.service.NewSalaryService;

@RestController
@RequestMapping(value = "/api/newsalary")
public class NewSalaryController {

    @Autowired
    private NewSalaryService newSalaryService;

    @PutMapping("/{cpf}")
    public NewSalaryDto newSalary(@Valid @PathVariable("cpf") String cpf) {
        return this.newSalaryService.newSalary(cpf);
    }
}
