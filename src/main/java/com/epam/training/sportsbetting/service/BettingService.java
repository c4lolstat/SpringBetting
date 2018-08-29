package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.bet.Bet;
import java.util.List;

/**
 * Created by Farkas on 2018.06.14..
 */
public class BettingService {

    public String getOutcomeList(List<Bet> betList) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Bet bet : betList) {
            int outcomesSize = bet.getOutcomes().size();
            for (int m = 0; m < outcomesSize; m++) {
                sb.append(index)
                        .append(": ")
                        .append(bet.getSportEvent())
                        .append(bet)
                        .append(bet.getOutcome(m))
                        .append("\n");
                index++;
            }
        }
        return sb.toString();
    }

    public Bet selectBet(List<Bet> betList, String betIndex) {
        int index = 0;
        for (int n = 0; n < betList.size(); n++){
            Bet bet = betList.get(n);
            int outcomesSize = bet.getOutcomes().size();
            for (int m = 0; m < outcomesSize; m++){
                if (index == Integer.parseInt(betIndex)){
                    Bet betSubset = new Bet(betList.get(n).getSportEvent(),betList.get(n).getOutcomeType());
                    betSubset.addOutcome(betList.get(n).getOutcome(m));
                    return betSubset;
                }
                index++;
            }
        }
        return null;
    }
}
