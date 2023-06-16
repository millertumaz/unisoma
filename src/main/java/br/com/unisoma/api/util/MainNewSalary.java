package br.com.unisoma.api.util;

public class MainNewSalary {
    public CalculateNewSalary calculate(Float salary) {
        CalculateNewSalary calculateNewSalary = new CalculateNewSalary(salary);

        PrymarySalaryHandler prymarySalaryHandler = new PrymarySalaryHandler();

        prymarySalaryHandler
                .setNextHandler(new SecundarySalaryHandler())
                .setNextHandler(new TertiarySalaryHandler())
                .setNextHandler(new QuartenarySalaryHandler())
                .setNextHandler(new QuintenarySalaryHandler());

        return prymarySalaryHandler.handle(calculateNewSalary);
    }
}
