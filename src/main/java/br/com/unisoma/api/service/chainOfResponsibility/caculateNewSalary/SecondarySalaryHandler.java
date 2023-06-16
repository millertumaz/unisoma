package br.com.unisoma.api.service.chainOfResponsibility.caculateNewSalary;

import br.com.unisoma.api.util.RoundingNumbers;

public class SecondarySalaryHandler extends BaseNewSalaryHandler {

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary > 400 && salary.currentSalary <= 800) {
            RoundingNumbers b = new RoundingNumbers();
            salary.percentage = 12;
            salary.readjustment = b.RoundingNumber(((salary.currentSalary * salary.percentage) / 100), "en");
            salary.newSalary = b.RoundingNumber(salary.currentSalary + salary.readjustment, "en");

            return salary;
        }

        return super.handle(salary);
    }
}
