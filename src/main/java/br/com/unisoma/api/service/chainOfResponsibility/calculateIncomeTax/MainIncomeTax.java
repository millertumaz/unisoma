package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

public class MainIncomeTax {
    public CalculateIncomeTax calculate(Float salary) {
        CalculateIncomeTax calculateIncomeTax = new CalculateIncomeTax(salary);

        PrimaryIncomeTaxHandler primaryIncomeTaxHandler = new PrimaryIncomeTaxHandler();

        primaryIncomeTaxHandler
                .setNextHandler(new SecondaryIncomeTaxHandler())
                .setNextHandler(new TertiaryIncomeTaxHandle())
                .setNextHandler(new QuaternaryIncomeTaxHandler());

        return primaryIncomeTaxHandler.handle(calculateIncomeTax);
    }
}
