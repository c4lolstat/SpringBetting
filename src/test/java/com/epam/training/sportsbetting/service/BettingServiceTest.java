package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.bet.Bet;
import com.epam.training.sportsbetting.domain.outcome.Outcome;
import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.outcome.OutcomeType;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas on 2018.06.18..
 */
@RunWith(MockitoJUnitRunner.class)
public class BettingServiceTest {

    private List<Bet> betList = new ArrayList<>();
    BettingService bettingService = new BettingService();

    @Mock
    SportEvent event;

    @Before
    public void setup(){

        Mockito.when(event.toString()).thenReturn("test");

            /*Bets*/
        OutcomeOdd odd1 = new OutcomeOdd(5.0d, LocalTime.now(),LocalTime.now());
        Outcome outcome1 = new Outcome("Loki");
        outcome1.addOdd(odd1);
        Bet bet1 = new Bet(event, OutcomeType.WINNER);
        bet1.addOutcome(outcome1);

        OutcomeOdd odd2 = new OutcomeOdd(2.0d, LocalTime.now(),LocalTime.now());
        Outcome outcome2 = new Outcome("Fiorentina");
        outcome2.addOdd(odd2);
        bet1.addOutcome(outcome2);

        OutcomeOdd odd3 = new OutcomeOdd(3.5d, LocalTime.now(),LocalTime.now());
        Outcome outcome3 = new Outcome("3");
        outcome3.addOdd(odd3);
        Bet bet2 = new Bet(event, OutcomeType.GOALS);
        bet2.addOutcome(outcome3);

        betList.add(bet1);
        betList.add(bet2);
    }

    @Test
    public void testProperListStringGeneration(){
        String result = bettingService.getOutcomeList(betList);
        Assert.assertEquals(307,result.length());
    }

    @Test
    public void testBetCanBeSelectedFromList(){
        Bet result = bettingService.selectBet(betList,"1");
        Assert.assertEquals("Fiorentina",result.getOutcome(0).getValue());
    }
}
