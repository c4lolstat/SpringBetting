package com.epam.training.sportsbetting.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.sportsbetting.domain.wager.Currency;

public class CheckInputData {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckInputData.class);

    public static boolean isOnlyDigits(String line) {
        return line.matches("[1-9][0-9]*");
    }

    public static boolean isCurrency(String line) {
        try {
            Currency.valueOf(line.toUpperCase());
            return true;
        } catch (IllegalArgumentException iae) {
           LOGGER.error(iae.getMessage());
        } 
        return false;
    }

    public static LocalDate stringToDate(String line) {
        try {
            return LocalDate.parse(line);
        } catch (DateTimeParseException dtpe) {
            LOGGER.error(dtpe.getMessage());
        }
        return LocalDate.MAX;
    }

    public static boolean isBetweenTwoNumber(String number, int min, int max) {
        return isOnlyDigits(number) && Integer.parseInt(number) >= min  && Integer.parseInt(number) <= max;
    }

}
