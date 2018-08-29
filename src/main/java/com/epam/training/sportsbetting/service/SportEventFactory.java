package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.sportevent.FootballSportEvent;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.domain.sportevent.SportEventType;
import com.epam.training.sportsbetting.domain.sportevent.TennisSportEvent;

import javax.activation.UnsupportedDataTypeException;
import java.time.LocalDate;

/**
 * Created by Farkas on 2018.06.14..
 */
public class SportEventFactory {

    public SportEvent createEvent(String title, LocalDate start, LocalDate end, SportEventType type) throws UnsupportedDataTypeException {
        switch (type) {
            case FOOTBALL:
                return new FootballSportEvent(title, start, end);
            case TENIS:
                return new TennisSportEvent(title, start, end);
            default:
                throw new UnsupportedDataTypeException("Unknow type...");
        }
    }
}
