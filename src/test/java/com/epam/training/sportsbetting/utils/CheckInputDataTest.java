package com.epam.training.sportsbetting.utils;

import java.time.LocalDate;

import com.epam.training.sportsbetting.utils.CheckInputData;
import org.junit.Assert;
import org.junit.Test;

public class CheckInputDataTest {

    @Test
    public void testIsOnlyDigitsShouldTrueWhenGetOnlyDigit() {
        //GIVEN
        String input = "15423";
        
        //WHEN
        boolean result = CheckInputData.isOnlyDigits(input);
        
        //THEN
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void testIsOnlyDigitsShouldFalseeWhenGetAlphabetict() {
        //GIVEN
        String input = "154A23";
        
        //WHEN
        boolean result = CheckInputData.isOnlyDigits(input);
        
        //THEN
        Assert.assertEquals(false, result);
    }
    
    @Test
    public void testStringToDateSouldGiveLocalDateWhenGetValidDateFormat() {
        //GIVEN
        String input = "1990-01-01";
        
        //WHEN
        LocalDate result = CheckInputData.stringToDate(input);
        
        //THEN
        Assert.assertEquals(LocalDate.parse("1990-01-01"), result);
    }
    
    @Test
    public void testStringToDateSouldGiveMaxDateWhenGetInvalidDateFormat() {
        //GIVEN
        String input = "1990-Jan-01";
        
        //WHEN
        LocalDate result = CheckInputData.stringToDate(input);
        
        //THEN
        Assert.assertEquals(LocalDate.MAX, result);
    }
    
    @Test
    public void testIsBetweenTwoNumberSouldGiveTrueWhenBetweenTwoNumber() {
        //GIVEN
        String number = "25";
        int max = 25;
        int min = 10;
        
        //WHEN
        boolean result = CheckInputData.isBetweenTwoNumber(number, min, max);
        
        //THEN
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void testIsBetweenTwoNumberSouldGiveFalseWhenGetTooLittleNumber() {
        //GIVEN
        String number = "5";
        int max = 25;
        int min = 10;
        
        //WHEN
        boolean result = CheckInputData.isBetweenTwoNumber(number, min, max);
        
        //THEN
        Assert.assertEquals(false, result);
    }
    
    
    @Test
    public void testIsCurrencySouldGiveTrueWhenGetCurrency() {
        //GIVEN
        String line = "huf";
        
        //WHEN
        boolean result = CheckInputData.isCurrency(line);
        
        //THEN
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void testIsCurrencySouldGiveFalseWhenGetNotCurrency() {
        //GIVEN
        String line = "usa";
        
        //WHEN
        boolean result = CheckInputData.isCurrency(line);
        
        //THEN
        Assert.assertEquals(false, result);
    }

}
