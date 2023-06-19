package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

public class PrimaryIncomeTaxHandler extends BaseCalculateIncomeTax {

    public CalculateIncomeTax handle(CalculateIncomeTax tax) {
        if (tax.salary >= 0 && tax.salary <= 2000 ) {
            tax.tax = "Isento";

            return tax;
        }

        return super.handle(tax);
    }    
}
