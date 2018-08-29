package com.epam.training.sportsbetting.domain.sportevent;

import com.epam.training.sportsbetting.domain.outcome.OutcomeType;
import com.epam.training.sportsbetting.domain.outcome.Outcome;

import java.util.ArrayList;
import java.util.List;

public class Result{

    private SportEvent sportEvent;
    private List<Outcome> outcomes = new ArrayList<>();
    private OutcomeType outcomeType;

    public Result(SportEvent sportEvent, OutcomeType outcomeType) {
        this.sportEvent = sportEvent;
        this.outcomeType = outcomeType;
    }

    public Outcome getOutcome(int i) {
        return outcomes.get(i);
    }

    public void addOutcome(Outcome outcome){
        this.outcomes.add(outcome);
    }


    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public OutcomeType getOutcomeType() {
        return outcomeType;
    }

    public void setOutcomeType(OutcomeType outcomeType) {
        this.outcomeType = outcomeType;
    }
}
