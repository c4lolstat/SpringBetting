package com.epam.training.sportsbetting.domain.bet;

import com.epam.training.sportsbetting.domain.outcome.OutcomeType;
import com.epam.training.sportsbetting.domain.sportevent.Result;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;

public class Bet extends Result {

    private String description = "";

    public Bet(SportEvent sportEvent, OutcomeType outcomeType) {
        super (sportEvent, outcomeType);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOdd () {
        return super.getOutcome(0).getOdds().get(0).getOdd();
    }

    public String toString(){
        return super.getOutcomeType().getText();
    }
}
