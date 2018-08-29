package com.epam.training.sportsbetting.domain.outcome;

import java.time.LocalTime;

public class OutcomeOdd {

    private double odd;
    private LocalTime validFrom;
    private LocalTime validTo;

    public OutcomeOdd(double odd, LocalTime validFrom, LocalTime validTo) {
        this.odd = odd;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public double getOdd() {
        return odd;
    }

    public LocalTime getValidFrom() {
        return validFrom;
    }

    public LocalTime  getValidTo() {
        return validTo;
    }

    public String toString(){
        return  ". The odd on this is " + odd + " valid from " + validFrom + " to " + validTo;
    }
}
