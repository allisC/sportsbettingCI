package com.epam.training.sportsbetting.domain.outcome;

import java.time.LocalDate;

public class OutcomeOdd {

    Outcome outcome;
    private double oddValue;
    private LocalDate validFrom;
    private LocalDate validTo;

    public OutcomeOdd(Outcome outcome, double oddValue, LocalDate validFrom, LocalDate validTo) {
        super();
        this.outcome = outcome;
        this.oddValue = oddValue;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public double getOddValue() {
        return oddValue;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    @Override
    public String toString() {
        return "OutcomeOdd [outcome=" + outcome + ", oddValue=" + oddValue + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
    }

}
