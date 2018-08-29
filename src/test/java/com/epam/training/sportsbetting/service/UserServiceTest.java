package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Currency;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.math.BigDecimal.valueOf;

/**
 * Created by Farkas on 2018.06.18..
 */

public class UserServiceTest {

    private UserService userService = new UserService();


    @Test
    public void testPlayerCreation(){
        Player result = userService.createPlayer("Ultra Viola", LocalDate.now() ,BigDecimal.ONE, Currency.HUF);
        Assert.assertEquals("Ultra Viola",result.getName());
        Assert.assertEquals(BigDecimal.ONE, result.getBalance());
        Assert.assertEquals(Currency.HUF, result.getCurrency());
    }

    @Test
    public void testBalanceUpdateable(){
        Player result = userService.createPlayer("Ultra Viola", LocalDate.now(), valueOf(100), Currency.HUF);
        userService.updateUserBalance(result, valueOf(50));
        Assert.assertTrue(result.getBalance().equals(valueOf(50)));
    }
}
