package br.com.unisoma.api.util;

public class TertiarySalaryHandler extends BaseNewSalaryHandler {

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary > 800 && salary.currentSalary <= 1200) {
            salary.percentage = 10;
            salary.readjustment = (salary.currentSalary * salary.percentage) / 100;
            salary.newSalary = salary.currentSalary + salary.readjustment;

            return salary;
        }

        return super.handle(salary);
    }
}
