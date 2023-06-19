package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

import br.com.unisoma.api.util.RoundingNumbers;

public class QuaternaryIncomeTaxHandler extends BaseCalculateIncomeTax {

    public CalculateIncomeTax handle(CalculateIncomeTax tax) {
        if (tax.salary > 4500) {
            RoundingNumbers b = new RoundingNumbers();

            Float taxa = (((tax.salary - 4500) * 28) / 100) + 80 + 270;

            taxa = b.RoundingNumber(taxa, "en");

            tax.tax = "R$ " + String.format("%.02f", taxa);
            System.out.println(taxa);
            return tax;
        }

        return super.handle(tax);
    }
}