package br.com.unisoma.api.util;

public class CalculateNewSalary {
    public Float currentSalary;
    public Float newSalary;
    public int percentage;
    public Float readjustment;

    public CalculateNewSalary(Float currentSalary) {
        this.currentSalary = currentSalary;
    }
}
