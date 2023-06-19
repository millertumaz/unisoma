package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

import br.com.unisoma.api.util.RoundingNumbers;

public class SecondaryIncomeTaxHandler extends BaseCalculateIncomeTax {

    public CalculateIncomeTax handle(CalculateIncomeTax tax) {
        if (tax.salary > 2000 && tax.salary <= 3000) {
            RoundingNumbers b = new RoundingNumbers();

            Float taxa = (((tax.salary - 2000) * 8) / 100);

            taxa = b.RoundingNumber(taxa, "en");

            tax.tax = "R$ " + String.format("%.02f", taxa);

            return tax;
        }

        return super.handle(tax);
    }
}