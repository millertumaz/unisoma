package br.com.unisoma.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.api.dto.IncomeTaxDto;
import br.com.unisoma.api.service.IncomeTaxService;

@RestController
@RequestMapping("/incometax")
public class IncomeTaxController {

    @Autowired
    private IncomeTaxService incomeTaxService;

    @GetMapping("/{cpf}")
    public IncomeTaxDto tax(@Valid @PathVariable("cpf") String cpf) {
        return this.incomeTaxService.tax(cpf);
    }
}
