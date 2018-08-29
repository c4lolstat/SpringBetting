package com.epam.training.sportsbetting.domain.outcome;

public enum OutcomeType {

    GOALS(" the number of scored goals will be "), WINNER(" the winner will be "), WHOSCORE("");

    private String text;

    OutcomeType(String s) {
        this.text = s;
    }

    public String getText(){
        return text;
    }
}
