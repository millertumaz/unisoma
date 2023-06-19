package br.com.unisoma.api.service.chainOfResponsibility.calculateIncomeTax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainIncomeTaxTest {

    @Test
    void testCalculatIncomeTaxTwoThousand() {
        CalculateIncomeTax calculateIncomeTax = new MainIncomeTax()
                .calculate(2000f);

        assertEquals(CalculateIncomeTax.class, calculateIncomeTax.getClass());

        assertEquals(calculateIncomeTax.tax, "Isento");
    }

    @Test
    void testCalculatIncomeTaxThreeThousand() {
        CalculateIncomeTax calculateIncomeTax = new MainIncomeTax()
                .calculate(3000f);

        assertEquals(CalculateIncomeTax.class, calculateIncomeTax.getClass());

        assertEquals(calculateIncomeTax.tax, "R$ 80,00");
    }

    @Test
    void testCalculatIncomeTaxFourThousandAndFiveHundred() {
        CalculateIncomeTax calculateIncomeTax = new MainIncomeTax()
                .calculate(4500f);

        assertEquals(CalculateIncomeTax.class, calculateIncomeTax.getClass());

        assertEquals(calculateIncomeTax.tax, "R$ 350,00");
    }

    @Test
    void testCalculatIncomeTaxEightThousand() {
        CalculateIncomeTax calculateIncomeTax = new MainIncomeTax()
                .calculate(8000f);

        assertEquals(CalculateIncomeTax.class, calculateIncomeTax.getClass());

        assertEquals(calculateIncomeTax.tax, "R$ 1330,00");
    }
}
