package com.epam.training.sportsbetting.domain.user;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.epam.training.sportsbetting.domain.wager.Currency;

public class Player {

    private String name;
    private String accountNumber;
    private BigDecimal balance;
    private Currency currency;
    private LocalDate dateOfBirth;

    public static class PlayerBuilder {

        private String email = "";
        private String pass = "";
        private String name = "";
        private String accountNumber = "";
        private BigDecimal balance = BigDecimal.ZERO;
        private Currency currency;
        private LocalDate dateOfBirth;

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PlayerBuilder setPassword(String pass) {
            this.pass = pass;
            return this;
        }

        public PlayerBuilder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public PlayerBuilder setBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public PlayerBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public PlayerBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Player build() {
            return new Player(email, pass, name, accountNumber, balance, currency, dateOfBirth);
        }
    }

    private Player(String email, String pass, String name, String accountNumber, BigDecimal balance, Currency currency, LocalDate dateOfBirth) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void subtractBalance(String number) {
        balance = balance.subtract(new BigDecimal(number));
    }

    public void addBalance(String number) {
        balance = balance.add(new BigDecimal(number));
    }

}
