package com.epam.training.sportsbetting.domain.sportevent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FootballSportEvent extends SportEvent {

    private SportEventType type = SportEventType.FOOTBALL;


    public FootballSportEvent(String title, LocalDate start, LocalDate end) {
        super(title, start, end);
    }

    public SportEventType getType() {
        return type;
    }
}
