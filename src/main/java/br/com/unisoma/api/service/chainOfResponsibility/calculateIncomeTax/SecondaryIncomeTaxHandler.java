package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

public class SecondaryIncomeTaxHandler extends BaseCalculateIncomeTax {

    public CalculateIncomeTax handle(CalculateIncomeTax tax) {
        if (tax.salary > 2000 && tax.salary <= 3000 ) {

            tax.tax = "R$ ";

            return tax;
        }

        return super.handle(tax);
    }    
}