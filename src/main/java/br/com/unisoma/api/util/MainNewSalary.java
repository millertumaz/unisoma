package br.com.unisoma.api.util;

public class MainNewSalary {
    public CalculateNewSalary calculate(Float salary) {
        CalculateNewSalary calculateNewSalary = new CalculateNewSalary(salary);

        PrimarySalaryHandler primarySalaryHandler = new PrimarySalaryHandler();

        primarySalaryHandler
                .setNextHandler(new SecondarySalaryHandler())
                .setNextHandler(new TertiarySalaryHandler())
                .setNextHandler(new QuaternarySalaryHandler())
                .setNextHandler(new QuintenarySalaryHandler());

        return primarySalaryHandler.handle(calculateNewSalary);
    }
}
