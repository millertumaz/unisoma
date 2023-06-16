package br.com.unisoma.api.util;

public class SecundarySalaryHandler extends BaseNewSalaryHandler {

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary > 400 && salary.currentSalary <= 800) {
            salary.percentage = 12;
            salary.readjustment = (salary.currentSalary * salary.percentage) / 100;
            salary.newSalary = salary.currentSalary + salary.readjustment;

            return salary;
        }

        return super.handle(salary);
    }
}
