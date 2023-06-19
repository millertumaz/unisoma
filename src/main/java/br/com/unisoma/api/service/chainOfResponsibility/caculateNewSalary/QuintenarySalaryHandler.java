package br.com.unisoma.api.service.chainOfResponsibility.caculateNewSalary;

import br.com.unisoma.api.util.RoundingNumbers;

public class QuintenarySalaryHandler extends BaseNewSalaryHandler {

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary > 2000) {
            RoundingNumbers b = new RoundingNumbers();
            salary.percentage = 4;
            salary.readjustment = b.RoundingNumber(((salary.currentSalary * salary.percentage) / 100), "en");
            salary.newSalary = b.RoundingNumber(salary.currentSalary + salary.readjustment, "en");
            
            return salary;
        }

        return super.handle(salary);
    }
}