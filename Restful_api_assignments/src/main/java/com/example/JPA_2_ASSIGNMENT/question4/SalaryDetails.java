package com.example.JPA_2_ASSIGNMENT.question4;

import jakarta.persistence.Embeddable;

@Embeddable
public class SalaryDetails {
    Float basicSalary;
    Float bonusSalary;
    Float taxAmount;
    Float specialAllowanceSalary;
    public SalaryDetails (){}
    public SalaryDetails(Float basicSalary, Float bonusSalary, Float taxAmount, Float specialAllowanceSalary) {
        this.basicSalary = basicSalary;
        this.bonusSalary = bonusSalary;
        this.taxAmount = taxAmount;
        this.specialAllowanceSalary = specialAllowanceSalary;
    }

    public Float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Float getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(Float bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public Float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Float getSpecialAllowanceSalary() {
        return specialAllowanceSalary;
    }

    public void setSpecialAllowanceSalary(Float specialAllowanceSalary) {
        this.specialAllowanceSalary = specialAllowanceSalary;
    }

    @Override
    public String toString() {
        return "SalaryDetails{" +
                "basicSalary=" + basicSalary +
                ", bonusSalary=" + bonusSalary +
                ", taxAmount=" + taxAmount +
                ", specialAllowanceSalary=" + specialAllowanceSalary +
                '}';
    }
}
