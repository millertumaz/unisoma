package br.com.unisoma.api.service.chainOfResponsibility.caculateNewSalary;

import br.com.unisoma.api.util.RoundingNumbers;

public class PrimarySalaryHandler extends BaseNewSalaryHandler {

    public CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary >= 0 && salary.currentSalary <= 400) {
            RoundingNumbers b = new RoundingNumbers();
            salary.percentage = 15;
            salary.readjustment = b.RoundingNumber(((salary.currentSalary * salary.percentage) / 100), "en");
            salary.newSalary = b.RoundingNumber(salary.currentSalary + salary.readjustment, "en");

            return salary;
        }

        return super.handle(salary);
    }
}
