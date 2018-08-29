package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Farkas on 2018.06.14..
 */
public class UserService {

    public Player createPlayer(String name, LocalDate dob, BigDecimal balance, Currency currency) {
        return new Player.PlayerBuilder()
                .setName(name)
                .setDateOfBirth(dob)
                .setBalance(balance)
                .setCurrency(currency)
                .build();
    }

    public void updateUserBalance(Player player, BigDecimal money) {
        BigDecimal old = player.getBalance();
        player.setBalance(old.subtract(money));
    }
}
