package br.com.unisoma.api.util;

public class BaseNewSalaryHandler {
    protected BaseNewSalaryHandler nextHandler = null;

    protected BaseNewSalaryHandler handler;

    public BaseNewSalaryHandler setNextHandler(BaseNewSalaryHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    CalculateNewSalary handle(CalculateNewSalary salary) {
        if (this.nextHandler == null) {
            return salary;
        }

        return this.nextHandler.handle(salary);
    }
}
