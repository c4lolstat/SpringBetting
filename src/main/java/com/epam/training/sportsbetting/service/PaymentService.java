package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.bet.Bet;
import com.epam.training.sportsbetting.domain.outcome.Outcome;
import com.epam.training.sportsbetting.domain.sportevent.Result;
import com.epam.training.sportsbetting.domain.wager.Wager;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Farkas on 2018.06.16..
 */
public class PaymentService {

    public void processWagers(List<Result> resultList, List<Wager> wagerList) {
        for (Wager wager : wagerList) {
            Bet bet = wager.getBet();
            for (Result result : resultList) {
                if (result.getSportEvent().equals(bet.getSportEvent()) && result.getOutcomeType() == bet.getOutcomeType()) {
                    Outcome betOutcome = bet.getOutcome(0);
                    for (Outcome outcome : result.getOutcomes()) {
                        if (betOutcome.equals(outcome)) {
                            wager.setWin(true);
                        }
                    }
                }
            }
        }

    }

    public BigDecimal cashOut(List<Wager> wagerList) {
        BigDecimal prize = BigDecimal.ZERO;
        for (Wager wager : wagerList) {
            if (wager.isWin()){
                BigDecimal amount = wager.getAmount();
                double odd = wager.getBet().getOdd();
                prize = prize.add(amount.multiply(BigDecimal.valueOf(odd)));
            }
            wager.setProcessed(true);
        }
        return prize;
    }
}
