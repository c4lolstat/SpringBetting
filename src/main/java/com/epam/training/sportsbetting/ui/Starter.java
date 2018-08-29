package com.epam.training.sportsbetting.ui;

import com.epam.training.sportsbetting.domain.bet.Bet;
import com.epam.training.sportsbetting.domain.outcome.OutcomeType;
import com.epam.training.sportsbetting.domain.outcome.Outcome;
import com.epam.training.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.domain.sportevent.Result;
import com.epam.training.sportsbetting.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.domain.sportevent.SportEventType;
import com.epam.training.sportsbetting.domain.user.Player;
import com.epam.training.sportsbetting.domain.wager.Currency;
import com.epam.training.sportsbetting.domain.wager.Wager;
import com.epam.training.sportsbetting.service.BettingService;
import com.epam.training.sportsbetting.service.PaymentService;
import com.epam.training.sportsbetting.service.SportEventFactory;
import com.epam.training.sportsbetting.service.UserService;

import javax.activation.UnsupportedDataTypeException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Farkas on 2018.06.14..
 */
public class Starter {

    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService();
    private SportEventFactory sportEventService = new SportEventFactory();
    private BettingService bettingService = new BettingService();
    private PaymentService paymentService = new PaymentService();

    private List<Bet> betList = new ArrayList<>();
    private List<Wager> wagerList = new ArrayList<>();
    private List<Result> resultList = new ArrayList<>();
    private boolean run = true;


    public Starter(){
        generateSportEvents();
    }

    public void start(){
        while(run){
            Player player = createPlayer();
            makeBets(player);
            payOutPlayer(player);
        }
    }

    private Player createPlayer() {
        System.out.println("Hi, what is your name?");
        String name = sc.nextLine();

        System.out.println("When were you born? eg.:1990-02-03");
        LocalDate dob = LocalDate.parse(sc.nextLine());

        System.out.println("What is your currency? (HUF, EUR or USD) ");
        Currency currency = Currency.valueOf(sc.nextLine().toUpperCase());
        ;

        System.out.println("How much money do you have (more than 0)? ");
        BigDecimal balance = new BigDecimal(sc.nextLine());

        return userService.createPlayer(name, dob, balance, currency);
    }

    private void makeBets(Player player) {
        while (!player.getBalance().equals(BigDecimal.ZERO)){
            System.out.println("What are you want to bet on? (choose a number or press q for quit)");

            System.out.print(bettingService.getOutcomeList(betList));

            System.out.println("Choose an outcome!");
            String betIndex = sc.nextLine();
            Bet selectedBet = bettingService.selectBet(betList, betIndex);

            System.out.println("How much do you want to bet on it?");
            BigDecimal money = new BigDecimal(sc.nextLine());

            wagerList.add(new Wager(player,selectedBet,money));

            userService.updateUserBalance(player,money);
            System.out.println("Your new balance is: " + player.getBalance() + player.getCurrency());
        }
    }

    private void payOutPlayer(Player player) {
        paymentService.processWagers(resultList, wagerList);
        BigDecimal prize = paymentService.cashOut(wagerList);
        System.out.println("You won: " + prize + player.getCurrency());
        run = false;
    }

    private void generateSportEvents() {
        try {
            SportEvent event = sportEventService.createEvent("BattleRoyal", LocalDate.of(2018, 6, 9), LocalDate.of(2018, 6, 9), SportEventType.FOOTBALL);

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

            /*Results*/
            Result result1 = new Result(event, OutcomeType.WINNER);
            result1.addOutcome(new Outcome("Loki"));

            Result result2 = new Result(event, OutcomeType.GOALS);
            result2.addOutcome( new Outcome("4"));

            resultList.add(result1);
            resultList.add(result2);

        } catch (UnsupportedDataTypeException e) {
            e.printStackTrace();
        }
    }
}
