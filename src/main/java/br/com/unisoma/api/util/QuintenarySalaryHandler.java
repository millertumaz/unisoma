package br.com.unisoma.api.util;

public class QuintenarySalaryHandler extends BaseNewSalaryHandler {

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary > 2000) {
            salary.percentage = 4;
            salary.readjustment = (salary.currentSalary * salary.percentage) / 100;
            salary.newSalary = salary.currentSalary + salary.readjustment;

            return salary;
        }

        return super.handle(salary);
    }
}