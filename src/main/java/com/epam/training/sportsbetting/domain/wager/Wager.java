package com.epam.training.sportsbetting.domain.wager;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.epam.training.sportsbetting.domain.bet.Bet;
import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.user.Player;

public class Wager {

    private Player player;
    private Bet bet;
    private BigDecimal amount;
    private LocalDate timestamp;
    private boolean processed;
    private boolean win;

    public Wager(Player player, Bet bet, BigDecimal amount) {
        this.player = player;
        this.amount = amount;
        this.bet= bet;
        timestamp = LocalDate.now();
        processed = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
