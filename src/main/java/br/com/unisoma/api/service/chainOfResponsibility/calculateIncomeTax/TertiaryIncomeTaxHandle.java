package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

import br.com.unisoma.api.util.RoundingNumbers;

public class TertiaryIncomeTaxHandle extends BaseCalculateIncomeTax {

    public CalculateIncomeTax handle(CalculateIncomeTax tax) {
        if (tax.salary > 3000 && tax.salary <= 4500) {
            RoundingNumbers b = new RoundingNumbers();

            Float taxa = (((tax.salary - 3000) * 18) / 100) + 80;

            taxa = b.RoundingNumber(taxa, "en");

            tax.tax = "R$ " + String.format("%.02f", taxa);

            return tax;
        }

        return super.handle(tax);
    }
}
