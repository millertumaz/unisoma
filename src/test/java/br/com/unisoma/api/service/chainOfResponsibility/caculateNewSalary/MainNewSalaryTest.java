package br.com.unisoma.api.service.chainOfResponsibility.caculateNewSalary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainNewSalaryTest {

    @Test
    void testCalculateNewSalaryFourHundred() {
        CalculateNewSalary calculateNewSalary = new MainNewSalary()
                .calculate(400f);

        assertEquals(CalculateNewSalary.class, calculateNewSalary.getClass());
        assertEquals(calculateNewSalary.newSalary, 460.0f);
    }

    @Test
    void testCalculateNewSalaryEightHundred() {
        CalculateNewSalary calculateNewSalary = new MainNewSalary()
                .calculate(800f);

        assertEquals(CalculateNewSalary.class, calculateNewSalary.getClass());
        assertEquals(calculateNewSalary.newSalary, 896.0f);
    }

    @Test
    void testCalculateNewSalaryThousandAndTwoHundred() {
        CalculateNewSalary calculateNewSalary = new MainNewSalary()
                .calculate(1200f);

        assertEquals(CalculateNewSalary.class, calculateNewSalary.getClass());
        assertEquals(calculateNewSalary.newSalary, 1320.0f);
    }

    @Test
    void testCalculateNewSalaryTwoThousand() {
        CalculateNewSalary calculateNewSalary = new MainNewSalary()
                .calculate(2000f);

        assertEquals(CalculateNewSalary.class, calculateNewSalary.getClass());
        assertEquals(calculateNewSalary.newSalary, 2140.0f);
    }

    @Test
    void testCalculateNewSalaryFiveThousand() {
        CalculateNewSalary calculateNewSalary = new MainNewSalary()
                .calculate(5000f);

        assertEquals(CalculateNewSalary.class, calculateNewSalary.getClass());
        assertEquals(calculateNewSalary.newSalary, 5200.0f);
    }
}
