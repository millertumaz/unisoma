package br.com.unisoma.api.util;

public class QuaternarySalaryHandler extends BaseNewSalaryHandler {

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary > 1200 && salary.currentSalary <= 2000) {
            salary.percentage = 7;
            salary.readjustment = (salary.currentSalary * salary.percentage) / 100;
            salary.newSalary = salary.currentSalary + salary.readjustment;

            return salary;
        }

        return super.handle(salary);
    }
}