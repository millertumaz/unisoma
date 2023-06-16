package br.com.unisoma.api.util;

public class PrymarySalaryHandler extends BaseNewSalaryHandler {

    public CalculateNewSalary handle(CalculateNewSalary salary) {
        if (salary.currentSalary >= 0 && salary.currentSalary <= 400) {
            salary.percentage = 15;
            salary.readjustment = (salary.currentSalary * salary.percentage) / 100;
            salary.newSalary = salary.currentSalary + salary.readjustment;

            return salary;
        }

        return super.handle(salary);
    }
}
