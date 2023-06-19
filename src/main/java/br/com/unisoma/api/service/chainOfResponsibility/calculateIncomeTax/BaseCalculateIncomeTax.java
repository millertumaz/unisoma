package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

public class BaseCalculateIncomeTax {
    protected BaseCalculateIncomeTax nextHandler = null;

    protected BaseCalculateIncomeTax setNextHandler(BaseCalculateIncomeTax handler) {
        this.nextHandler = handler;
        return handler;
    }

    CalculateIncomeTax handle(CalculateIncomeTax salary) {
        if (this.nextHandler == null) {
            return salary;
        }

        return this.nextHandler.handle(salary);
    }
}
