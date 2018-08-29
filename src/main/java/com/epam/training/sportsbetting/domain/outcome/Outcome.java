package com.epam.training.sportsbetting.domain.outcome;

import java.util.ArrayList;
import java.util.List;

public class Outcome {

    private List<OutcomeOdd> odds = new ArrayList<>();
    private String value;

    public Outcome(String value) {
        this.value = value;
    }

    public List<OutcomeOdd> getOdds() {
        return odds;
    }

    public void addOdd(OutcomeOdd odd){
        this.odds.add(odd);
    }

    public void setOdds(List<OutcomeOdd> odds) {
        this.odds = odds;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){
        return value + odds.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Outcome outcome = (Outcome) o;

        return !(value != null ? !value.equals(outcome.value) : outcome.value != null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
