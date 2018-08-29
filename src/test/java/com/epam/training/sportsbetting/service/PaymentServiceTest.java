package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.bet.Bet;
import com.epam.training.sportsbetting.domain.outcome.Outcome;
import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.outcome.OutcomeType;
import com.epam.training.sportsbetting.domain.sportevent.Result;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Wager;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas on 2018.06.18..
 */

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    private List<Result> resultList = new ArrayList<>();
    private List<Wager> wagerList;
    private PaymentService paymentService = new PaymentService();
    @Mock
    private SportEvent event;

    @Mock
    private Player player;

    @Before
    public void setup(){
        wagerList = new ArrayList<>();

        Result result1 = new Result(event, OutcomeType.WINNER);
        result1.addOutcome(new Outcome("Loki"));

        Result result2 = new Result(event, OutcomeType.GOALS);
        result2.addOutcome( new Outcome("4"));

        resultList.add(result1);
        resultList.add(result2);
    }

    @Test
    public void testWagerCanBeProcessed(){
        OutcomeOdd odd = new OutcomeOdd(5.0d, LocalTime.now(),LocalTime.now());
        Outcome outcome = new Outcome("Loki");
        outcome.addOdd(odd);
        Bet bet = new Bet(event, OutcomeType.WINNER);
        bet.addOutcome(outcome);

        Wager wager = new Wager(player,bet, BigDecimal.valueOf(100));

        wagerList.add(wager);
        paymentService.processWagers(resultList, wagerList);
        Assert.assertTrue(wager.isWin());
    }

    @Test
    public void testWinnigWagerCanBeCashedOut(){
        OutcomeOdd odd = new OutcomeOdd(5.0d, LocalTime.now(),LocalTime.now());
        Outcome outcome = new Outcome("Loki");
        outcome.addOdd(odd);
        Bet bet = new Bet(event, OutcomeType.WINNER);
        bet.addOutcome(outcome);

        Wager wager = new Wager(player,bet, BigDecimal.valueOf(100));
        wager.setWin(true);
        wagerList.add(wager);

        BigDecimal result = paymentService.cashOut(wagerList);
        Assert.assertEquals(BigDecimal.valueOf(500.0d),result);
    }
}
